package com.example.myapplication.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class StyleView extends View {

    private Paint paint;

    public StyleView(Context context) {
        super(context);
        init();
    }

    public StyleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public StyleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(200,100,100,paint);

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(200,350,100,paint);

        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawCircle(200,600,100,paint);
    }
}
