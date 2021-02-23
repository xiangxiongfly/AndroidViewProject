package com.example.app;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        TitleBar tilebar = findViewById(R.id.tilebar);
        tilebar.setOnLeftListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "左边", Toast.LENGTH_SHORT).show();
            }
        });
        tilebar.setOnRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "右边", Toast.LENGTH_SHORT).show();
            }
        });


//        FrameLayout fl = findViewById(R.id.fl);
//        fl.post(new Runnable() {
//            @Override
//            public void run() {
//                int width = fl.getWidth();
//                int height = fl.getHeight();
//                Log.e("TAG", width + "-" + height);
//                int paddingLeft = fl.getPaddingLeft();
//                int paddingTop = fl.getPaddingTop();
//                Log.e("TAG", paddingLeft + "-" + paddingTop);
//            }
//        });
    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("TAG", "Activity dispatchTouchEvent:" + Utils.getEvent(ev));
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("TAG", "Activity onTouchEvent:" + Utils.getEvent(event));
        return super.onTouchEvent(event);
    }
}