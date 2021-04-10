package com.example.myapplication.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class XfermodeView extends View {


    public XfermodeView(Context context) {
        super(context);
        init();
    }

    public XfermodeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public XfermodeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private Paint paint;
    private RectF bounds;
    private Bitmap circleBitmap;
    private Bitmap squareBitmap;

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        bounds = new RectF(0, 0, 300, 300);
        circleBitmap = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888);
        squareBitmap = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(circleBitmap);
        paint.setColor(Color.RED);
        canvas.drawCircle(100, 100, 100, paint);

        canvas.setBitmap(squareBitmap);
        paint.setColor(Color.BLUE);
        canvas.drawRect(100, 100, 300, 300, paint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //设置离屏缓冲
        //离屏缓冲比较消耗资源。可以设置bounds指定区域
        int saved = canvas.saveLayer(bounds, null);

        //绘制dst
        canvas.drawBitmap(circleBitmap, 0, 0, paint);//画圆形

        //绘制src
        Xfermode xfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        paint.setXfermode(xfermode);
        canvas.drawBitmap(squareBitmap, 0, 0, paint);//画矩形

        paint.setXfermode(null);//及时清理Xfermode
        //恢复
        canvas.restoreToCount(saved);

    }
}
