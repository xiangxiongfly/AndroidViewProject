package com.example.custom_view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;

public class HorizontalView extends ViewGroup {
    int currentIndex = 0; //当前子元素
    int childWidth = 0;
    private Scroller mScroller;
    private VelocityTracker tracker;

    public HorizontalView(Context context) {
        this(context, null);
    }

    public HorizontalView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HorizontalView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mScroller = new Scroller(context);
        tracker = VelocityTracker.obtain();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        //测量所有子元素
        measureChildren(widthMeasureSpec, heightMeasureSpec);

        if (getChildCount() == 0) {
            //如果没有子元素，宽高都设为0
            setMeasuredDimension(0, 0);
        } else if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
            //如果该View都宽高都是AT_MOST，则将宽设为所有子元素的宽度总和，高度设为第一个子元素的高度
            View child = getChildAt(0);
            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();
            setMeasuredDimension(childWidth * getChildCount(), childHeight);
        } else if (widthMode == MeasureSpec.AT_MOST) {
            int childWidth = getChildAt(0).getMeasuredWidth();
            setMeasuredDimension(childWidth * getChildCount(), heightSize);
        } else if (heightMode == MeasureSpec.AT_MOST) {
            int childHeight = getChildAt(0).getMeasuredHeight();
            setMeasuredDimension(widthMeasureSpec, childHeight);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        int left = 0;
        View childView;
        for (int i = 0; i < childCount; i++) {
            childView = getChildAt(i);
            if (childView.getVisibility() != GONE) {
                int width = childView.getMeasuredWidth();
                childWidth = width;
                childView.layout(left, 0, left + width, childView.getMeasuredHeight());
                left += width;
            }
        }
    }


    private int lastX;
    private int lastY;
    private int lastInterceptX;
    private int lastInterceptY;

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean intercepted = false;
        int eventX = (int) ev.getX();
        int eventY = (int) ev.getY();

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                intercepted = false;
                break;
            case MotionEvent.ACTION_MOVE:
                if (Math.abs(eventX - lastInterceptX) > Math.abs(eventY - lastInterceptY)) {
                    intercepted = true;
                } else {
                    intercepted = false;
                }
                break;
            case MotionEvent.ACTION_UP:
                intercepted = false;
                break;
        }

        //onTouchEvent()中不能获取down事件，记录lastX、lastY
        lastX = eventX;
        lastY = eventY;
        lastInterceptX = eventX;
        lastInterceptY = eventY;
        return intercepted;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        tracker.addMovement(event);
        int eventX = (int) event.getX();
        int eventY = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("TAG", "down");
                //如果动画还没有执行完，则中断
                if (!mScroller.isFinished()) {
                    mScroller.abortAnimation();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                int dx = eventX - lastX;
                int dy = eventY - lastY;
                scrollBy(-dx, 0);
                break;
            case MotionEvent.ACTION_UP:
                //向左滑动为正，将要进入下一个页面；向右滑动为负，将要进入上一个页面
                int distance = getScrollX() - currentIndex * childWidth;

                //移动距离必须大于一半才会切换页面
                if (Math.abs(distance) > childWidth / 2) {
                    if (distance > 0) {
                        currentIndex++;
                    } else {
                        currentIndex--;
                    }
                } else {
                    //计算快速的滑动的平均数独
                    tracker.computeCurrentVelocity(1000);
                    float xV = tracker.getXVelocity();
                    //大于50说明快速滑动
                    if (Math.abs(xV) > 50) {
                        if (xV > 0) {
                            currentIndex--;
                        } else {
                            currentIndex++;
                        }
                    }
                }
                if (currentIndex < 0) {
                    currentIndex = 0;
                } else if (currentIndex > getChildCount() - 1) {
                    currentIndex = getChildCount() - 1;
                }
                smoothScrollTo(currentIndex * childWidth, 0);
                tracker.clear();
                break;
        }

        lastX = eventX;
        lastY = eventY;
        return true;
    }

    /*
    View中如果有线程或动画，需要及时停止
     */
    @Override
    protected void onDetachedFromWindow() {
        tracker.recycle();
        super.onDetachedFromWindow();
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
    }

    private void smoothScrollTo(int destX, int destY) {
        mScroller.startScroll(getScrollX(), getScrollY(), destX - getScrollX(), destY - getScrollY(), 1000);
        invalidate();
    }
}
