package com.example.myapplication.draw_text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CenterTextView extends View {

    public CenterTextView(Context context) {
        super(context);
    }

    public CenterTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CenterTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        //设置水平居中
        paint.setTextAlign(Paint.Align.CENTER);

        //绘制圆环
        float radius = 200;
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(10);
        canvas.drawCircle(getWidth() / 2F, getHeight() / 2F, radius, paint);

        //绘制文字并居中
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(30);
        String text = "100%";

        //方式一：适合静态文字
        Rect bounds = new Rect();
        paint.getTextBounds(text, 0, text.length(), bounds);
        canvas.drawText(text, getWidth() / 2, getHeight() / 2 - (bounds.bottom + bounds.top) / 2, paint);

        //方式二：适合动态文字
//        Paint.FontMetrics fontMetrics = new Paint.FontMetrics();
//        paint.getFontMetrics(fontMetrics);
//        canvas.drawText(text, getWidth() / 2F, getHeight() / 2F - (fontMetrics.descent + fontMetrics.ascent) / 2, paint);
    }
}
