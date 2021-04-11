package com.example.myapplication.draw_text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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
        Paint.FontMetrics fontMetrics = new Paint.FontMetrics();
        paint.getFontMetrics(fontMetrics);
        canvas.drawText("100%", getWidth() / 2F, getHeight() / 2F - (fontMetrics.ascent + fontMetrics.descent) / 2, paint);

    }
}
