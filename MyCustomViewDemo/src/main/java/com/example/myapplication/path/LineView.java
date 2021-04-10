package com.example.myapplication.path;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class LineView extends View {
    public LineView(Context context) {
        super(context);
    }

    public LineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        Path path = new Path();

        paint.setStyle(Paint.Style.STROKE);

//        path.lineTo(100, 100);//从当前位置(0,0)向(100,100)画线
//        path.rLineTo(100, 0);//从当前位置(100,100)向右方100像素画线
//
//        path.moveTo(200,200);
//        path.lineTo(400,200);
//
//        path.arcTo(100, 300, 300, 500, -90, 90, true);

        path.addArc(100, 100, 300, 300, -90, 90);

        canvas.drawPath(path, paint);

    }
}
