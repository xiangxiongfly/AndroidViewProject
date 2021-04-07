package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawColorView extends View {
    public DrawColorView(Context context) {
        super(context);
    }

    public DrawColorView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawColorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawColor(Color.GREEN);
//        canvas.drawColor(Color.parseColor("#88880000"));
        canvas.drawRGB(100, 200, 100);
//        canvas.drawARGB(100, 100, 200, 100);
    }
}
