package org.maxwe.epub.android.lib;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
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
public class EPubContainer extends RelativeLayout implements IEPubContainer {

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == HANDLER_KEY_EPUB_MANAGER_FAIL) {
                Toast.makeText(EPubContainer.this.getContext(),"错误",Toast.LENGTH_SHORT).show();
            } else if (msg.what == HANDLER_KEY_EPUB_MANAGER_SUCCESS) {
                initView();
            }
        }
    };

    private EPubManager.OnEPubManageListener ePubManageListener = new EPubManager.OnEPubManageListener(){
        @Override
        public void onBookNotExists(IBook ePub) {
            Message message = new Message();
            message.what = HANDLER_KEY_EPUB_MANAGER_FAIL;
            handler.sendMessage(message);
        }

        @Override
        public void onUnzipEPubError(IBook ePub, Exception exception) {
            Message message = new Message();
            message.what = HANDLER_KEY_EPUB_MANAGER_FAIL;
            handler.sendMessage(message);
        }

        @Override
        public void onTableContentFail(IBook ePub) {
            Message message = new Message();
            message.what = HANDLER_KEY_EPUB_MANAGER_FAIL;
            handler.sendMessage(message);
        }

        @Override
        public void onSuccess(IBook ePub) {
            Message message = new Message();
            message.what = HANDLER_KEY_EPUB_MANAGER_SUCCESS;
            handler.sendMessage(message);
        }
    };

    private EPubManager ePubManager;

    public EPubContainer(final Context context,final EPub ePub) {
        super(context);
        MyLog.addLogAccess(this.getClass());
        Timer.initEPubContainerStart = System.currentTimeMillis();
        new Thread(new Runnable() {
            @Override
            public void run() {
                ePubManager = new EPubManager(context, ePub, ePubManageListener).manage();
            }
        }).start();
    }

    private void initView(){
       this.addView(new EPubRender(this.getContext(),this.ePubManager.getEPub(),null));
        Timer.initEPubContainerEnd = System.currentTimeMillis();
        MyLog.print(this.getClass(),this.getClass().getName() + "初始化完成" + (Timer.initEPubContainerEnd - Timer.initEPubContainerStart));
    }
}
