package com.example.vieweventdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vieweventdemo.view01.SvVp1Activity;
import com.example.vieweventdemo.view02.SvVp2Activity;

public class MainActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, SvVp1Activity.class));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, SvVp2Activity.class));
            }
        });
    }
}
//
//class MyViewGroup extends ViewGroup {
//
//    public MyViewGroup(Context context) {
//        super(context);
//    }
//
//    public MyViewGroup(Context context, AttributeSet attrs) {
//        super(context, attrs);
//    }
//
//    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//    }
//
//    @Override
//    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//
//    }
//
//    int lastInterceptX;
//    int lastInterceptY;
//
//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        boolean intercepted = false;
//        int x = (int) ev.getX();
//        int y = (int) ev.getY();
//        switch (ev.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                intercepted = false;
//                break;
//            case MotionEvent.ACTION_MOVE:
//                if (父容器需要拦截此事件) {
//                    intercepted = true;
//                } else {
//                    intercepted = false;
//                }
//                break;
//            case MotionEvent.ACTION_UP:
//                intercepted = false;
//                break;
//        }
//
//
//        lastInterceptX = x;
//        lastInterceptY = y;
//        return intercepted;
//    }
//}

//class MyView extends View {
//
//    private ViewGroup parent;
//
//    public MyView(Context context) {
//        super(context);
//        init();
//    }
//
//    public MyView(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
//        init();
//    }
//
//    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        init();
//    }
//
//    private void init() {
//        parent = (ViewGroup) getParent();
//    }
//
//    int lastX;
//    int lastY;
//
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent event) {
//        int x = (int) event.getX();
//        int y = (int) event.getY();
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN:
//                parent.requestDisallowInterceptTouchEvent(true);
//                break;
//            case MotionEvent.ACTION_MOVE:
//                int dx = x - lastX;
//                int dy = y - lastY;
//                if (/*父容器需要此事件*/) {
//                    parent.requestDisallowInterceptTouchEvent(false);
//                } else {
//                    parent.requestDisallowInterceptTouchEvent(true);
//                }
//                break;
//            case MotionEvent.ACTION_UP:
//                break;
//        }
//
//        lastX = x;
//        lastY = y;
//        return super.dispatchTouchEvent(event);
//    }
//}


//class MyViewGroup extends ViewGroup {
//
//    public MyViewGroup(Context context) {
//        super(context);
//    }
//
//    public MyViewGroup(Context context, AttributeSet attrs) {
//        super(context, attrs);
//    }
//
//    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//    }
//
//    @Override
//    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//
//    }
//
//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
//            return false;
//        } else {
//            return true;
//        }
//    }
//}
