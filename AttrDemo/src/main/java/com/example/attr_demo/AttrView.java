package com.example.attr_demo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

public class AttrView extends View {

    public AttrView(Context context) {
        //在Java代码中实例化会调用
        super(context);
    }

    public AttrView(Context context, @Nullable AttributeSet attrs) {
        //在XML布局中定义时会调用
        super(context, attrs);
        init(context, attrs);
    }

    public AttrView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AttrView);

            //获取color
            int color = a.getColor(R.styleable.AttrView_custom_color, Color.WHITE);
            Log.e("TAG", "color: " + color);

            //获取string
            String str = a.getString(R.styleable.AttrView_custom_string);
            Log.e("TAG", "string: " + str);

            //获取dimension
            float dimension = a.getDimension(R.styleable.AttrView_custom_dimension, 0);
            Log.e("TAG", "dimension: " + dimension);
            //取整
            int dimensionPixelOffset = a.getDimensionPixelOffset(R.styleable.AttrView_custom_dimension, 0);
            Log.e("TAG", "dimensionPixelOffset: " + dimensionPixelOffset);
            //四舍五入
            int dimensionPixelSize = a.getDimensionPixelSize(R.styleable.AttrView_custom_dimension, 0);
            Log.e("TAG", "dimensionPixelSize: " + dimensionPixelSize);

            //获取boolean
            boolean aBoolean = a.getBoolean(R.styleable.AttrView_custom_boolean, false);
            Log.e("TAG", "aBoolean: " + aBoolean);

            //获取integer
            int anInt = a.getInt(R.styleable.AttrView_custom_integer, 0);
            Log.e("TAG", "anInt: " + anInt);
            int integer = a.getInteger(R.styleable.AttrView_custom_integer, 0);
            Log.e("TAG", "integer: " + integer);

            //获取float
            float aFloat = a.getFloat(R.styleable.AttrView_custom_float, 1.1f);
            Log.e("TAG", "aFloat: " + aFloat);


            //获取fraction，属性值为% 则乘以base，属性值为%p 则乘以pbase
            float fraction = a.getFraction(R.styleable.AttrView_custom_fraction, 10, 100, 0);
            Log.e("TAG", "fraction: " + fraction);

            //获取reference
            int resourceId = a.getResourceId(R.styleable.AttrView_custom_resid, 0);
            Log.e("TAG", "resourceId: " + resourceId);
            //属性值为drawalbe类型
            Drawable drawable = a.getDrawable(R.styleable.AttrView_custom_resid);
            Log.e("TAG", "ddd: " + drawable);

            //获取enum
            int anEnum = a.getInt(R.styleable.AttrView_custom_enum, 0);
            Log.e("TAG", "anEnum: " + anEnum);

            //获取falgs
            int falgs = a.getInteger(R.styleable.AttrView_custom_flags, 0);
            Log.e("TAG", "falgs: " + falgs);

            a.recycle();
        }
    }
}
