package org.maxwe.epub.android.lib;

import android.content.Context;

import org.maxwe.epub.android.lib.core.data.IBookData;
import org.maxwe.epub.android.lib.core.data.IContentData;
import org.maxwe.epub.android.lib.core.model.IBook;
import org.maxwe.epub.android.lib.data.ContentData;
import org.maxwe.epub.android.lib.data.EPubData;
import org.maxwe.epub.android.lib.model.Content;
import org.maxwe.epub.android.lib.model.EPub;
import org.maxwe.epub.android.lib.util.FileUtils;
import org.maxwe.epub.android.lib.util.MyLog;
import org.maxwe.epub.android.lib.util.Timer;
import org.maxwe.epub.parser.EPubParser;
import org.maxwe.epub.parser.core.INavigation;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Pengwei Ding on 2016-02-17 15:32.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: EPub管理器
 * 识别EPub的状态进行入库配置等操作
 */
public class EPubManager {

    private IBookData iBookData = new EPubData();
    private IContentData iContentData = new ContentData();

    private Context context;
    private IBook ePub;
    private OnEPubManageListener onEPubManageListener = new OnEPubManageListener() {
        @Override
        public void onBookNotExists(IBook book) {

        }

        @Override
        public void onUnzipEPubError(IBook ePub, Exception exception) {

        }

        @Override
        public void onTableContentFail(IBook ePub) {

        }

        @Override
        public void onSuccess(IBook ePub) {

        }
    };

    public EPubManager(Context context, EPub ePub, OnEPubManageListener onEPubManageListener) {
        this.context = context;
        this.ePub = ePub;

        /**
         * 确保OnEPubManageListener不为空
         * 减少后续代码对确保OnEPubManageListener对象的非空判断
         */
        if (onEPubManageListener != null) {
            this.onEPubManageListener = onEPubManageListener;
        }
    }

    public EPubManager manage() {
        MyLog.addLogAccess(this.getClass());
        Timer.configureStart = System.currentTimeMillis();
        if (!new File(this.ePub.getBookPath()).exists()) {
            this.onEPubManageListener.onBookNotExists(this.ePub);
            return this;
        }

        IBook bookById = null;
        try {
            bookById = this.iBookData.findBookById(this.context, this.ePub.getBookId());
            if (bookById != null) {
                this.ePub = bookById;
            } else {
                /**
                 * 新书
                 * 数据库中没有这本书的信息
                 */
                this.iBookData.saveBook(context, this.ePub);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!this.ePub.isUnziped() || this.ePub.getBookDir() == null || !new File(this.ePub.getBookDir()).exists()) {
            /**
             * 没有解压或者解压后的文件被删除了
             * 解压操作
             */
            try {
                this.ePub = this.unzip((EPub) this.ePub);
            } catch (Exception e) {
                this.onEPubManageListener.onUnzipEPubError(this.ePub, e);
                return this;
            }
            /**
             * 解压完成后保存
             */
            try {
                this.iBookData.saveBook(context, this.ePub);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (this.ePub.isUnziped() && !this.ePub.isTableed()) {
            /**
             * 没有配置目录
             * 配置目录操作
             */
            List<Content> contents = this.tableContents();
            if (contents == null) {
                ((EPub) this.ePub).setIsTableed(false);
                this.onEPubManageListener.onTableContentFail(this.ePub);
                return this;
            } else {
                /**
                 * 配置成功后保存目录
                 */
                this.iContentData.saveContents(context, contents);
                ((EPub) this.ePub).setIsTableed(true);
                /**
                 * 配置完成后保存图书
                 */
                try {
                    this.iBookData.saveBook(context, this.ePub);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        this.onEPubManageListener.onSuccess(this.ePub);
        Timer.configureEnd = System.currentTimeMillis();
        MyLog.print(this.getClass(),"图书配置结束：" + (Timer.configureEnd - Timer.configureStart));
        return this;
    }


    /**
     * 获取目录
     *
     * @return
     */
    public List<Content> getContent() {
        return iContentData.getContentsByBookId(this.context, this.ePub.getBookId());
    }

    /**
     * 获取目录
     *
     * @return
     */
    public List<Content> getContent(int page, int limit) {
        return iContentData.getContentsByBookId(this.context, this.ePub.getBookId(), page, limit);
    }

    /**
     * 解压到EPub同级目录下使用ID命名的文件夹下
     */
    private EPub unzip(EPub ePub) throws Exception {
        String targetDirPath = ePub.getBookPath().substring(0, ePub.getBookPath().lastIndexOf(File.separator)) + File.separator + ePub.getBookId();
        if (!new File(targetDirPath).exists()) {
            boolean mkdirs = new File(targetDirPath).mkdirs();
            if (!mkdirs) {
                throw new Exception("创建解压根目录错误");
            }
        }
        Timer.unzipStart = System.currentTimeMillis();
        FileUtils.unzip(ePub.getBookPath(), targetDirPath);
        Timer.unzipEnd = System.currentTimeMillis();
        MyLog.print(this.getClass(),this.getClass().getName() + "解压图书耗时：" + (Timer.unzipEnd - Timer.unzipStart));
        ePub.setBookDir(targetDirPath);
        ePub.setIsUnziped(true);
        return ePub;
    }

    /**
     * 配置目录
     *
     * @return 为null则标示出现异常
     */
    public List<Content> tableContents() {
        List<Content> contents;
        try {
            EPubParser ePubParser = new EPubParser(this.ePub.getBookDir() + File.separator);
            org.maxwe.epub.parser.impl.Content content = ePubParser.getContent();
            LinkedList<INavigation> navigation = content.getNavigation();
            contents = new LinkedList<>();
            for (INavigation iNavigation : navigation) {
                contents.add(new Content(this.ePub.getBookId(), iNavigation.getTitle(), iNavigation.getHref()));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {

        }
        return contents;
    }

    public EPub getEPub() {
        return (EPub) this.ePub;
    }

    public interface OnEPubManageListener {
        void onBookNotExists(IBook ePub);

        void onUnzipEPubError(IBook ePub, Exception exception);

        void onTableContentFail(IBook ePub);

        void onSuccess(IBook ePub);

    }
}
