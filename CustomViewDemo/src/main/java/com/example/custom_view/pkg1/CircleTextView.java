package com.example.custom_view.pkg1;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.Gravity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.custom_view.R;

public class CircleTextView extends androidx.appcompat.widget.AppCompatTextView {
    private static final int DEFAULT_BORDER_WIDTH = 0;
    private static final int DEFAULT_BORDER_COLOR = Color.BLACK;
    private static final int DEFAULT_CIRCLE_COLOR = Color.RED;
    private int borderWidth;
    private int borderColor;
    private int circleColor;
    private Paint paint;
    private Paint borderPaint;

    public CircleTextView(@NonNull Context context) {
        this(context, null);
    }

    public CircleTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CircleTextView);
            borderWidth = a.getDimensionPixelOffset(R.styleable.CircleTextView_border_width, DEFAULT_BORDER_WIDTH);
            borderColor = a.getColor(R.styleable.CircleTextView_border_color, DEFAULT_BORDER_COLOR);
            circleColor = a.getColor(R.styleable.CircleTextView_circle_color, DEFAULT_CIRCLE_COLOR);
            a.recycle();
        }
        setGravity(Gravity.CENTER);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(circleColor);

        borderPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        borderPaint.setStyle(Paint.Style.STROKE);
        borderPaint.setColor(borderColor);
        borderPaint.setStrokeWidth(borderWidth);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int max = Math.max(measuredWidth, measuredHeight);
        setMeasuredDimension(max, max);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int radius = getMeasuredWidth() / 2;
        float cx = radius;
        float cy = radius;
        canvas.drawCircle(cx, cy, radius, paint);
        if (borderWidth > 0) {
            canvas.drawCircle(cx, cy, radius - borderWidth / 2, borderPaint);
        }
        super.onDraw(canvas);
    }
}
