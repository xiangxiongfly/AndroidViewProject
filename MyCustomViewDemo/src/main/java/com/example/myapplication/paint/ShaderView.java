package com.example.myapplication.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.myapplication.R;

public class ShaderView extends View {

    private Paint paint;

    public ShaderView(Context context) {
        super(context);
        init();
    }

    public ShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    {
        setLayerType(LAYER_TYPE_SOFTWARE, null);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        int redColor = Color.RED;
//        int greenColor = Color.GREEN;

//        Shader shader = new LinearGradient(100, 100, 500, 500, redColor, greenColor, Shader.TileMode.CLAMP);
//        Shader shader = new RadialGradient(300, 300, 200, redColor, greenColor, Shader.TileMode.CLAMP);
//        Shader shader = new SweepGradient(300, 300, redColor, greenColor);

//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.a);
//        Shader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
//        paint.setShader(shader);
//        canvas.drawCircle(300, 300, 200, paint);


        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.a);
        Bitmap srcBitmap = Bitmap.createScaledBitmap(bitmap1, 400, 400, true);
        Shader shader1 = new BitmapShader(srcBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.b);
        Bitmap dstBitmap = Bitmap.createScaledBitmap(bitmap2, 400, 400, true);
        Shader shader2 = new BitmapShader(dstBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        ComposeShader shader = new ComposeShader(shader1, shader2, PorterDuff.Mode.DST_OUT);
        paint.setShader(shader);
        canvas.drawRect(0, 0, 400, 400, paint);
    }
}
