package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class StyleCapView extends View {

    private Paint paint;

    public StyleCapView(Context context) {
        super(context);
        init();
    }

    public StyleCapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public StyleCapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setStrokeWidth(20);

        paint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawLine(50, 50, 300, 50, paint);

        paint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(50, 100, 300, 100, paint);

        paint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawLine(50, 150, 300, 150, paint);
    }
}
