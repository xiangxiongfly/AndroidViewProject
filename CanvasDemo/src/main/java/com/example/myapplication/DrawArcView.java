package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawArcView extends View {

    private Paint paint;

    public DrawArcView(Context context) {
        super(context);
        init();
    }

    public DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        RectF rectF = new RectF(100F, 100F, 400F, 300F);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(rectF, -100, 100, true, paint);
        canvas.drawArc(rectF, 30, 90, false, paint);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(rectF, 130, 50, false, paint);
    }
}
