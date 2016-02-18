package org.maxwe.epub.android.lib;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.maxwe.android.utils.views.tablist.Container;
import org.maxwe.epub.android.lib.core.model.IBook;
import org.maxwe.epub.android.lib.core.view.IEPubContainer;
import org.maxwe.epub.android.lib.menu.left.ContentView;
import org.maxwe.epub.android.lib.model.Content;
import org.maxwe.epub.android.lib.model.EPub;

import java.util.List;

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

    private EPubManager ePubManager;

    public EPubContainer(final Context context,final EPub ePub) {
        super(context);
        new Thread(new Runnable() {
            @Override
            public void run() {
                ePubManager = new EPubManager(context, ePub, new EPubManager.OnEPubManageListener() {
                    @Override
                    public void onBookNotExists(IBook ePub) {
                        Message message = new Message();
                        message.what = HANDLER_KEY_EPUB_MANAGER_FAIL;
                        handler.sendMessage(message);
                    }

                    @Override
                    public void onMakeEPubDirFail(IBook ePub) {
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
                });
            }
        }).start();
    }

    private void initView(){
        List<Content> content = this.ePubManager.getContent();
        System.out.println();

        LayoutInflater inflater = LayoutInflater.from(this.getContext());
        Container inflate1 = (Container)inflater.inflate(R.layout.org_maxwe_epub_lib_left_menu, null);
        ContentView inflate = (ContentView)inflate1.getChildAt(1);
        inflate.init(content);
        this.addView(inflate1);

    }
}
