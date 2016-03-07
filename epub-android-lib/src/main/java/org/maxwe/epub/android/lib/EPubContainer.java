package org.maxwe.epub.android.lib;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.maxwe.epub.android.lib.core.model.IBook;
import org.maxwe.epub.android.lib.core.view.IEPubContainer;
import org.maxwe.epub.android.lib.model.EPub;
import org.maxwe.epub.android.lib.util.MyLog;
import org.maxwe.epub.android.lib.util.Timer;

/**
 * Created by Pengwei Ding on 2016-01-05 16:17.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: EPub容器
 */
public class EPubContainer extends RelativeLayout implements IEPubContainer ,EPubManager.OnEPubManageListener{

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == HANDLER_KEY_EPUB_MANAGER_FAIL) {
                Toast.makeText(EPubContainer.this.getContext(), "错误", Toast.LENGTH_SHORT).show();
            } else if (msg.what == HANDLER_KEY_EPUB_MANAGER_SUCCESS) {
                initView();
            }
        }
    };

    private String userId;
    private EPubManager ePubManager;
    private EPubRender ePubRender;

    public EPubContainer(final Context context,final String userId, final EPub ePub) {
        super(context);
        this.userId = userId;
        MyLog.addLogAccess(this.getClass());
        Timer.initEPubContainerStart = System.currentTimeMillis();
        new Thread(new Runnable() {
            @Override
            public void run() {
                ePubManager = new EPubManager(userId, ePub, EPubContainer.this);
                ePubManager.configure();
            }
        }).start();
    }

    private void initView() {
        this.ePubRender = new EPubRender(this.getContext(), this.ePubManager.getEPub(), this.ePubManager.getProgress());
        this.addView(ePubRender);
        Timer.initEPubContainerEnd = System.currentTimeMillis();
        MyLog.print(this.getClass(), this.getClass().getName() + "初始化完成" + (Timer.initEPubContainerEnd - Timer.initEPubContainerStart));
    }

    @Override
    public void onBookNotExists(IBook ePub) {
        Message message = new Message();
        message.what = HANDLER_KEY_EPUB_MANAGER_FAIL;
        this.handler.sendMessage(message);
    }

    @Override
    public void onUnzipEPubError(IBook ePub, Exception exception) {
        Message message = new Message();
        message.what = HANDLER_KEY_EPUB_MANAGER_FAIL;
        this.handler.sendMessage(message);
    }

    @Override
    public void onTableContentFail(IBook ePub) {
        Message message = new Message();
        message.what = HANDLER_KEY_EPUB_MANAGER_FAIL;
        this.handler.sendMessage(message);
    }

    @Override
    public void onSuccess(IBook ePub) {
        Message message = new Message();
        message.what = HANDLER_KEY_EPUB_MANAGER_SUCCESS;
        this.handler.sendMessage(message);
    }

    @Override
    public void onBackPressed() throws Exception {
//        Progress progress = (Progress)this.ePubManager.getProgress();
//        IPage page = this.ePubRender.getPage();
//        progress.setChapterOffset(page.getChapterIndex());
//        progress.setParagraphOffset(page.getStartParagraphIndexInChapter());
//        progress.setSectionOffset(page.getStartSectionIndexInParagraph());
//        progress.setMetaOffset(page.getStartMetaIndexInSection());
//        this.ePubManager.saveProgress(progress);
    }
}
