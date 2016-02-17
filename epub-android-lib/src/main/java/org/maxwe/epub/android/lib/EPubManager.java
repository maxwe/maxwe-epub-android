package org.maxwe.epub.android.lib;

import android.content.Context;

import org.maxwe.epub.android.lib.core.data.IBookData;
import org.maxwe.epub.android.lib.core.data.IContentData;
import org.maxwe.epub.android.lib.core.model.IBook;
import org.maxwe.epub.android.lib.data.ContentData;
import org.maxwe.epub.android.lib.data.EPubData;
import org.maxwe.epub.android.lib.model.Content;
import org.maxwe.epub.android.lib.model.EPub;

import java.io.File;
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

    public EPubManager(Context context, EPub ePub) {
        this.context = context;
        this.ePub = this.iBookData.findBookById(context, ePub.getBookId());
        if (this.ePub == null) {
            /**
             * 新书
             * 数据库中没有这本书的信息
             */
            this.ePub = this.iBookData.saveBook(context, ePub);
        }

        if (!this.ePub.isUnziped() || !new File(this.ePub.getBookDir()).exists()) {
            /**
             * 没有解压或者解压后的文件被删除了
             * 解压操作
             */

        }

        if (!this.ePub.isTableed()){
            /**
             * 没有配置目录
             * 配置目录操作
             */
        }
    }

    /**
     * 获取目录
     * @return
     */
    public List<Content> getContent(){
        return iContentData.getContentsByBookId(this.context,this.ePub.getBookId());
    }

    /**
     * 获取目录
     * @return
     */
    public List<Content> getContent(int page,int limit){
        return iContentData.getContentsByBookId(this.context,this.ePub.getBookId(),page,limit);
    }
}
