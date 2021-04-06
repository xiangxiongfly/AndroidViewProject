package com.example.vieweventdemo.pkg2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

public class MyListview extends ListView {
    public MyListview(Context context) {
        super(context);
    }

    public MyListview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyListview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    int lastX;
    int lastY;

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                getParent().getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                int dx = x - lastX;
                int dy = y - lastY;
                if (dy < 0) {
                    if (!canScrollList(1)) {
                        //当不能向上滑动
                        getParent().getParent().requestDisallowInterceptTouchEvent(false);
                        return false;
                    }
                } else if (dy > 0) {
                    if (!canScrollList(-1)) {
                        //当不能向下滑动
                        getParent().getParent().requestDisallowInterceptTouchEvent(false);
                        return false;
                    }
                }
                break;
        }

        lastX = x;
        lastY = y;
        return super.dispatchTouchEvent(event);
    }
}
