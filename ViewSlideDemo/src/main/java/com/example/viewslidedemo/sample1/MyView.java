package com.example.viewslidedemo.sample1;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

import androidx.annotation.Nullable;

public class MyView extends View {
    private int lastX;
    private int lastY;
    private Scroller mScroller;
    private int maxRight;
    private ViewGroup parent;
    private int maxBottom;

    public MyView(Context context) {
        this(context, null);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mScroller = new Scroller(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                parent = (ViewGroup) getParent();
//                maxRight = parent.getRight();
//                maxBottom = parent.getBottom();
                maxRight = parent.getMeasuredWidth();
                maxBottom = parent.getMeasuredHeight();
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - lastX;
                int offsetY = y - lastY;

                //移动方式一
                int left = getLeft() + offsetX;
                int top = getTop() + offsetY;
                int right = getRight() + offsetX;
                int bottom = getBottom() + offsetY;
                if (left < 0) {
                    right -= left;
                    left = 0;
                }
                if (right > maxRight) {
                    left -= right - maxRight;
                    right = maxRight;
                }
                if (top < 0) {
                    bottom -= top;
                    top = 0;
                }
                if (bottom > maxBottom) {
                    top -= bottom - maxBottom;
                    bottom = maxBottom;
                }
                Log.e("TAG", "top: " + top);
                Log.e("TAG", "bottom: " + bottom);
                layout(left, top, right, bottom);

                //移动方式二
//                offsetLeftAndRight(offsetX);
//                offsetTopAndBottom(offsetY);

                //移动方式三
//                ((View) getParent()).scrollBy(-offsetX, -offsetY);

                //移动方式四
//                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) getLayoutParams();
//                params.leftMargin = getLeft() + offsetX;
//                params.topMargin = getTop() + offsetY;
//                setLayoutParams(params);
                break;
        }
        return true;
    }

    /**
     * @param dx       x轴移动距离
     * @param dy       y轴移动距离
     * @param duration 持续时间
     */
    public void smoothScrollTo(int dx, int dy, int duration) {
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        mScroller.startScroll(scrollX, scrollY, dx, dy, duration);
        invalidate();
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()) {
            ((View) getParent()).scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            invalidate();
        }
    }
}
