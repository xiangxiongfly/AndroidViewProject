package com.example.myapplication.draw_text;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class StaticLayoutView extends View {
    public StaticLayoutView(Context context) {
        super(context);
    }

    public StaticLayoutView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public StaticLayoutView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(30);

        String text1 = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";
        StaticLayout staticLayout1 = new StaticLayout(text1, textPaint, 600, Layout.Alignment.ALIGN_NORMAL, 1, 0, true);
        String text2 = "a\nbc\ndefghi\njklm\nnopqrst\nuvwx\nyz";
        StaticLayout staticLayout2 = new StaticLayout(text2, textPaint, 600, Layout.Alignment.ALIGN_NORMAL, 1, 0, true);

        canvas.save();
        canvas.translate(50, 50);
        staticLayout1.draw(canvas);
        canvas.translate(0, 200);
        staticLayout2.draw(canvas);
        canvas.restore();

    }
}
