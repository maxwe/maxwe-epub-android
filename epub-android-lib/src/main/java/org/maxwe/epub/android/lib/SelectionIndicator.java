package org.maxwe.epub.android.lib;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;

/**
 * Created by Pengwei Ding on 2016-01-05 17:31.
 * Email: www.dingpengwei@foxmail.com www.dingpegnwei@gmail.com
 * Description: @TODO
 */
public class SelectionIndicator extends ImageView {
    private float rawX, rawY;
    private OnDragSelectionIndicator onDragSelectionIndicator = new OnDragSelectionIndicator() {
        @Override
        public void onDragSelectionIndicator(SelectionIndicator selectionIndicator,float x, float y) {
            System.out.println("当你看到这行log的时候表示你没有设置恰当的编码方式");
        }
    };
    private FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);

    public SelectionIndicator(Context context) {
        super(context);
        this.setClickable(true);
        this.setLayoutParams(this.layoutParams);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.rawX = event.getRawX();
        this.rawY = event.getRawY();
        this.onDragSelectionIndicator.onDragSelectionIndicator(this,this.rawX, this.rawY);
        this.dragTo(this.rawX, this.rawY);
        return super.onTouchEvent(event);
    }


    public void showAsDrawable(int drawableId) {
        this.setImageResource(drawableId);
    }

    public float getRawX() {
        return rawX;
    }

    public float getRawY() {
        return rawY;
    }

    public void dragTo(float x, float y) {
        this.layoutParams.leftMargin = (int) x;
        this.layoutParams.topMargin = (int) y;
        this.setLayoutParams(this.layoutParams);
    }

    public void setOnDragSelectionIndicator(OnDragSelectionIndicator onDragSelectionIndicator) {
        this.onDragSelectionIndicator = onDragSelectionIndicator;
    }

    public interface OnDragSelectionIndicator {
        void onDragSelectionIndicator(SelectionIndicator selectionIndicator,float x, float y);
    }
}
