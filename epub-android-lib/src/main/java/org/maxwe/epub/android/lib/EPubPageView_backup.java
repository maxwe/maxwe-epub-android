package org.maxwe.epub.android.lib;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import org.maxwe.epub.android.lib.view.drawer.PageDrawer;
import org.maxwe.epub.typesetter.impl.Page;

/**
 * Created by Pengwei Ding on 2016-01-05 17:29.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class EPubPageView_backup extends FrameLayout implements View.OnClickListener, View.OnLongClickListener, SelectionIndicator.OnDragSelectionIndicator {
    private String pageName;
    private boolean isSelectMode = false;
    private int startX, startY, endX, endY;
    private SelectionIndicator selectionIndicatorStart;
    private SelectionIndicator selectionIndicatorEnd;

    private Paint paint = new Paint();

    public EPubPageView_backup(Context context, String pageName) {
        super(context);
        this.pageName = pageName;
        this.setClickable(true);
        this.setWillNotDraw(false);
        this.setOnClickListener(this);
        this.setOnLongClickListener(this);
        this.paint.setTextSize(24);

        this.selectionIndicatorStart = new SelectionIndicator(context);
        this.selectionIndicatorStart.setId(R.id.maxwe_id_selection_indicator_start);
        this.selectionIndicatorStart.setOnDragSelectionIndicator(this);

        this.selectionIndicatorEnd = new SelectionIndicator(context);
        this.selectionIndicatorEnd.setId(R.id.maxwe_id_selection_indicator_end);

        this.selectionIndicatorEnd.setOnDragSelectionIndicator(this);
    }

    private int pageIndex;

    public int getPageIndex() {
        return pageIndex;
    }

    public EPubPageView_backup setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
        return this;
    }

    public EPubPageView_backup reset() {
        this.startX = 0;
        this.startY = 0;
        this.endX = 0;
        this.endY = 0;
        this.invalidate();
        return this;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText("第" + this.pageIndex + "页 ", 50, 50, paint);
//        this.drawBackGroundColor(canvas, this.startX, this.startY, this.endX, this.endY);
    }

    public String getPageName() {
        return pageName;
    }

    public void drawPage(Page page) {
        this.removeAllViews();
        this.addView(new PageDrawer(this.getContext(),page));
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        boolean result = super.onTouchEvent(ev);
        if (this.isSelectMode) {
            int action = ev.getAction();
            switch (action) {
                case MotionEvent.ACTION_MOVE:
                    this.endX = (int) ev.getRawX();
                    this.endY = (int) ev.getRawY();
                    this.invalidate();
                    break;
                case MotionEvent.ACTION_UP:
                    this.endX = (int) ev.getRawX();
                    this.endY = (int) ev.getRawY();
                    invalidate();
                    break;
            }
            return true;
        } else {
            if (ev.getAction() == MotionEvent.ACTION_DOWN) {
                this.startX = (int) ev.getRawX();
                this.startY = (int) ev.getRawY();
            }
            return result;
        }
    }

    @Override
    public void onClick(View v) {
        this.reset();
        this.isSelectMode = false;
        this.removeView(this.selectionIndicatorStart);
        this.removeView(this.selectionIndicatorEnd);
    }

    @Override
    public boolean onLongClick(View v) {
        if (this.isSelectMode) {
            /**
             * 处于选中状态不响应长按事件，相应点击事件
             */
            return false;
        } else {
            /**
             * 处于非选中状态相应长按事件，不响应点击事件
             */
            this.isSelectMode = true;
            this.drawSelectionIndicator(this.startX, this.startY);
            return true;
        }
    }

    /**
     * 模拟背景色
     *
     * @param canvas
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     */
    private void drawBackGroundColor(Canvas canvas, int startX, int startY, int endX, int endY) {
        RectF rectF = new RectF();
        if (startX < endX && startY < endY) {
            //向下，向右
            rectF.set(startX, startY, endX, endY);
        } else if (startX >= endX && startY < endY) {
            //向上，向右
            rectF.set(endX, startY, startX, endY);
        } else if (startX < endX && startY >= endY) {
            //向下，向左
            rectF.set(startX, endY, endX, startY);
        } else if (startX >= endX && startY >= endY) {
            //向上，向左
            rectF.set(endX, endY, startX, startY);
        }
        canvas.drawRect(rectF, this.paint);
    }


    /**
     * 定义选择器属性以及回调方法
     */
    private int startXOfSelectionIndicatorStart, startYOfSelectionIndicatorStart, startXOfSelectionIndicatorEnd, startYOfSelectionIndicatorEnd;

    @Override
    public void onDragSelectionIndicator(SelectionIndicator selectionIndicator, float x, float y) {
        float rawX = selectionIndicator.getRawX();
        float rawY = selectionIndicator.getRawY();
        if (R.id.maxwe_id_selection_indicator_start == selectionIndicator.getId()) {
            this.startXOfSelectionIndicatorStart = (int) rawX;
            this.startYOfSelectionIndicatorStart = (int) rawY;
        } else if (R.id.maxwe_id_selection_indicator_end == selectionIndicator.getId()) {
            this.startXOfSelectionIndicatorEnd = (int) rawX;
            this.startYOfSelectionIndicatorEnd = (int) rawY;
        }
        if (this.startXOfSelectionIndicatorStart < this.startXOfSelectionIndicatorEnd && this.startYOfSelectionIndicatorStart < this.startYOfSelectionIndicatorEnd) {
            //开始点在结束点的左上方
            this.selectionIndicatorStart.showAsDrawable(R.drawable.maxwe_selection_indicator_start);
            this.selectionIndicatorEnd.showAsDrawable(R.drawable.maxwe_selection_indicator_end);
        } else if (this.startXOfSelectionIndicatorStart >= this.startXOfSelectionIndicatorEnd && this.startYOfSelectionIndicatorStart < this.startYOfSelectionIndicatorEnd) {
            //开始点在结束点的右上方
            this.selectionIndicatorStart.showAsDrawable(R.drawable.maxwe_selection_indicator_start);
            this.selectionIndicatorEnd.showAsDrawable(R.drawable.maxwe_selection_indicator_end);
        } else if (this.startXOfSelectionIndicatorStart < this.startXOfSelectionIndicatorEnd && this.startYOfSelectionIndicatorStart >= this.startYOfSelectionIndicatorEnd) {
            //开始点在结束点的左下方
            this.selectionIndicatorStart.showAsDrawable(R.drawable.maxwe_selection_indicator_end);
            this.selectionIndicatorEnd.showAsDrawable(R.drawable.maxwe_selection_indicator_start);
        } else if (this.startXOfSelectionIndicatorStart >= this.startXOfSelectionIndicatorEnd && this.startYOfSelectionIndicatorStart >= this.startYOfSelectionIndicatorEnd) {
            //开始点在结束点的右下方
            this.selectionIndicatorStart.showAsDrawable(R.drawable.maxwe_selection_indicator_end);
            this.selectionIndicatorEnd.showAsDrawable(R.drawable.maxwe_selection_indicator_start);
        }
    }

    private void drawSelectionIndicator(float x, float y) {
        this.selectionIndicatorStart.showAsDrawable(R.drawable.maxwe_selection_indicator_start);
        this.selectionIndicatorEnd.showAsDrawable(R.drawable.maxwe_selection_indicator_end);

        this.addView(this.selectionIndicatorStart);
        this.addView(this.selectionIndicatorEnd);

        this.startXOfSelectionIndicatorStart = this.startXOfSelectionIndicatorEnd = (int) x;
        this.startYOfSelectionIndicatorStart = this.startYOfSelectionIndicatorEnd = (int) y;

        this.selectionIndicatorStart.dragTo(x, y);
        this.selectionIndicatorEnd.dragTo(x, y);
    }
}
