package org.maxwe.epub.android.lib.menu.left;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import org.maxwe.android.utils.views.tablist.ITitle;
import org.maxwe.epub.android.lib.R;

/**
 * Created by Pengwei Ding on 2016-02-18 17:05.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class TitleView extends RelativeLayout implements ITitle{
    public TitleView(Context context) {
        super(context);
        this.init();
    }

    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }

    public TitleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.init();
    }

    private void init(){
        ImageView imageView = new ImageView(this.getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        layoutParams.addRule(CENTER_IN_PARENT);
        imageView.setLayoutParams(layoutParams);
        imageView.setImageResource(R.drawable.org_maxwe_epub_lib_test);
        this.addView(imageView);
    }
}
