package com.example.myapplication.draw_text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawTextView extends View {
    public DrawTextView(Context context) {
        super(context);
    }

    public DrawTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        String text = "hello world";

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextSize(30);

        canvas.drawText(text, 100, 100, paint);
    }
}
