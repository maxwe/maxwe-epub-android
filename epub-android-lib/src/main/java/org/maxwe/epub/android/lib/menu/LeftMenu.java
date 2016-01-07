package org.maxwe.epub.android.lib.menu;

import android.content.Context;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import org.maxwe.epub.android.lib.R;

/**
 * Created by Pengwei Ding on 2016-01-07 09:57.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: 做菜单容器
 */
public class LeftMenu extends FrameLayout {
    public static final String FRAGMENT_TAG = "fragment";


    public LeftMenu(Context context) {
        super(context);
        this.setId(R.id.maxwe_epub_ids_left_menu_id);

        Toolbar toolbar = new Toolbar(context);
        toolbar.setId(R.id.maxwe_epub_ids_left_menu_tool_bar);

        this.addView(toolbar);




    }
}
