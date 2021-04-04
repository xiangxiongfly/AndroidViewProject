package com.example.custom_view.pkg1;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.custom_view.R;

public class InvalidTextView extends androidx.appcompat.widget.AppCompatTextView {
    private static final float DEFAULT_LINE_WIDTH = 1F;
    private static final int DEFAULT_LINE_COLOR = Color.RED;

    private Paint mPaint;
    private float lineWidth;
    private int color;

    public InvalidTextView(@NonNull Context context) {
        this(context, null);
    }

    public InvalidTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public InvalidTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }


    private void init(@NonNull Context context, @Nullable AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.InvalidTextView);
            lineWidth = a.getDimension(R.styleable.InvalidTextView_line_width, DEFAULT_LINE_WIDTH);
            color = a.getColor(R.styleable.InvalidTextView_line_color, DEFAULT_LINE_COLOR);
            a.recycle();
        }

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(color);
        mPaint.setStrokeWidth(lineWidth);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int w = getWidth();
        int h = getHeight();
        canvas.drawLine(0, h / 2, w, h / 2, mPaint);
    }
}
