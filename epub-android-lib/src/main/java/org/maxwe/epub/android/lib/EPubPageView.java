package org.maxwe.epub.android.lib;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.FrameLayout;

import org.maxwe.epub.android.lib.view.drawer.PageDrawer;
import org.maxwe.epub.typesetter.impl.Page;

/**
 * Created by Pengwei Ding on 2016-01-05 17:29.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class EPubPageView extends FrameLayout {
    private int pageIndex;
    private String pageName;
    private Paint paint = new Paint();

    public EPubPageView(Context context, String pageName) {
        super(context);
        this.pageName = pageName;
        this.setWillNotDraw(false);
        this.paint.setTextSize(24);
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public EPubPageView setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
        return this;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText("第" + this.pageIndex + "页 ", 50, 50, paint);
    }

    public void drawPage(Page page) {
        this.removeAllViews();
        this.addView(new PageDrawer(this.getContext(), page));
    }
}
