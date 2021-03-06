package org.maxwe.epub.android.lib;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.widget.FrameLayout;

import org.maxwe.epub.android.lib.view.drawer.PageDrawer;
import org.maxwe.epub.typesetter.impl.dev.Page;

/**
 * Created by Pengwei Ding on 2016-01-05 17:29.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class EPubPageView extends FrameLayout {
    private int pageIndex;
    private String pageName;
    private Paint paint = new Paint();
    private Page page;

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
        if(this.page == null){
            canvas.drawText("第" + this.pageIndex + "页 ", 50, 50, paint);
        }else{
            canvas.drawText("第" + this.pageIndex + "页，第" + this.page.getChapterIndex() + "章，" + this.page.getChapterName() , 50, 50, paint);
        }
    }

    public void drawPage(Page page) {
        this.page = page;
        this.removeAllViews();
        if (this.page != null){
            this.addView(new PageDrawer(this.getContext(), page));
        }
    }

    public Page getPage() {
        return page;
    }
}
