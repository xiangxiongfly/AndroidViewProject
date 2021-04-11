package com.example.myapplication.draw_text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawTextOnPathView extends View {
    public DrawTextOnPathView(Context context) {
        super(context);
    }

    public DrawTextOnPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawTextOnPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        String text = "hello world java android kotlin html css javascript";

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextSize(26);

        Path path = new Path();
        path.moveTo(100, 100);
        path.lineTo(200, 100);
        path.lineTo(200, 300);
        path.lineTo(400, 300);
        path.lineTo(400, 400);

        canvas.drawTextOnPath(text, path, 0, 0, paint);
    }
}
