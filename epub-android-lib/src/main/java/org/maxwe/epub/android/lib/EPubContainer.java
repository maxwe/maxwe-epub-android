package org.maxwe.epub.android.lib;

import android.content.Context;
import android.widget.RelativeLayout;

/**
 * Created by Pengwei Ding on 2016-01-05 16:17.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: EPub容器
 */
public class EPubContainer extends RelativeLayout {

    public EPubContainer(Context context) {
        super(context);
        this.addView(new EPubRender(context));
    }
}
