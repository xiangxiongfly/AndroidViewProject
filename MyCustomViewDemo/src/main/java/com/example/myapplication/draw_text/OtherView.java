package com.example.myapplication.draw_text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class OtherView extends View {
    public OtherView(Context context) {
        super(context);
    }

    public OtherView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public OtherView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        String text = "hello world android";
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTextSize(40);

        //设置字体
//        paint.setTypeface(Typeface.DEFAULT);
//        canvas.drawText(text, 50, 50, paint);
//        paint.setTypeface(Typeface.DEFAULT_BOLD);
//        canvas.drawText(text, 100, 100, paint);
//        paint.setTypeface(Typeface.createFromAsset(getContext().getAssets(), "Satisfy-Regular.ttf"));
//        canvas.drawText(text, 150, 150, paint);

        //使用伪粗体
//        paint.setFakeBoldText(false);
//        canvas.drawText(text, 100, 100, paint);
//        paint.setFakeBoldText(true);
//        canvas.drawText(text, 100, 200, paint);

        //设置删除线
//        paint.setStrikeThruText(true);
//        canvas.drawText(text, 100, 100, paint);

        //设置下画线
//        paint.setUnderlineText(true);
//        canvas.drawText(text, 100, 100, paint);

        //设置横向缩放
//        paint.setTextScaleX(1);
//        canvas.drawText(text, 100, 100, paint);
//        paint.setTextScaleX(0.5F);
//        canvas.drawText(text, 100, 180, paint);
//        paint.setTextScaleX(1.5F);
//        canvas.drawText(text, 100, 260, paint);

        //设置字符间距
//        canvas.drawText(text, 100, 100, paint);
//        paint.setLetterSpacing(0.2f);
//        canvas.drawText(text, 100, 180, paint);

        //设置文字对齐方式
//        paint.setTextAlign(Paint.Align.LEFT);
//        canvas.drawText(text, 100, 100, paint);
//        paint.setTextAlign(Paint.Align.CENTER);
//        canvas.drawText(text, 100, 180, paint);
//        paint.setTextAlign(Paint.Align.RIGHT);
//        canvas.drawText(text, 100, 260, paint);

        //getFontSpacing() 获取行间距
//        String text1 = "hello world";
//        String text2 = "哈喽 世界";
//        canvas.drawText(text1, 100, 100, paint);
//        canvas.drawText(text2, 100, 100 + paint.getFontSpacing(), paint);

        //getTextBounds()获取文字的显示范围
//        int x = 100;
//        int y = 100;
//        canvas.drawText(text, x, y, paint);
//
//        Rect bounds = new Rect();
//        paint.getTextBounds(text, 0, text.length(), bounds);
//        bounds.left += x;
//        bounds.top += y;
//        bounds.right += x;
//        bounds.bottom += y;
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setColor(Color.RED);
//        canvas.drawRect(bounds, paint);

        //measureText()测量文字的宽度
//        int x = 100;
//        int y = 100;
//        canvas.drawText(text, x, y, paint);
//        float textWidth = paint.measureText(text);
//        paint.setColor(Color.RED);
//        canvas.drawLine(x, y, x + textWidth, y, paint);

        //getTextWidths()获取每个字符的宽度
//        float[] charWidths = new float[text.length()];
//        paint.getTextWidths(text, charWidths);
//        for (float i : charWidths)
//            Log.e("TAG", i+"");


        int measuredCoubnt;
        float[] measuredWidth = {0};
        measuredCoubnt = paint.breakText(text, 0, text.length(), true, 300, measuredWidth);
        canvas.drawText(text, 0, measuredCoubnt, 100, 100, paint);

    }
}
