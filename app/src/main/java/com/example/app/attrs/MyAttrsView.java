package com.example.app.attrs;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.app.R;

public class MyAttrsView extends View {
    public static final int ENUM_NONE = -1;
    public static final int ENUM_LEFT = 0;
    public static final int ENUM_RIGHT = 1;
    public static final int ENUM_TOP = 2;
    public static final int ENUM_BOTTOM = 3;

    public static final int FLAG_ENGLISH = 1;
    public static final int FLAG_CHINESE = 2;
    public static final int FLAG_FRENCH = 4;
    public static final int FLAG_JAPANESE = 5;


    // View在代码中new时，会调用第一个构造函数
    public MyAttrsView(Context context) {
        this(context, null);
    }

    // View在XML布局中使用时，会调用第二个构造函数
    public MyAttrsView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    // 不会自动调用
    // View有style属性时，在第二个构造函数中主动调用
    public MyAttrsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MyAttrsView);
            ColorDrawable colorDrawable = (ColorDrawable) getBackground();
            int bgColor = colorDrawable.getColor();
            Log.e("TAG", "bgColor: " + bgColor); //bgColor: -65536

            // 获取color属性
            int color = a.getColor(R.styleable.MyAttrsView_custom_color, Color.WHITE);
            Log.e("TAG", "color: " + color); //color: -65536

            // 获取boolean属性
            boolean aBoolean = a.getBoolean(R.styleable.MyAttrsView_custom_boolean, false);
            Log.e("TAG", "boolean: " + aBoolean); //boolean: true

            // 获取String属性
            String str = a.getString(R.styleable.MyAttrsView_custom_string);
            Log.e("TAG", "string: " + str); //string: 小明

            // 获取dimension属性，dp转px
            // 获取px值
            float dimension = a.getDimension(R.styleable.MyAttrsView_custom_dimension, 0);
            // 获得px取整值
            int dimensionPixelOffset = a.getDimensionPixelOffset(R.styleable.MyAttrsView_custom_dimension, 0);
            // 获得px四舍五入值
            int dimensionPixelSize = a.getDimensionPixelSize(R.styleable.MyAttrsView_custom_dimension, 0);
            Log.e("TAG", "dimension: " + dimension); //dimension: 160.59998
            Log.e("TAG", "dimensionPixelOffset: " + dimensionPixelOffset); //dimensionPixelOffset: 160
            Log.e("TAG", "dimensionPixelSize: " + dimensionPixelSize); //dimensionPixelSize: 161

            // 获取integer属性
            int integer = a.getInteger(R.styleable.MyAttrsView_custom_integer, 0);
            Log.e("TAG", "integer: " + integer); //integer: 65

            // 获取float属性
            float aFloat = a.getFloat(R.styleable.MyAttrsView_custom_float, 0);
            Log.e("TAG", "float: " + aFloat); //float: 1.5

            // 获取fraction属性
            // 如果属性值为%，则乘以base；如果属性值为%p，则乘以pbase
            float fraction = a.getFraction(R.styleable.MyAttrsView_custom_fraction, 10, 100, 0);
            float fraction2 = a.getFraction(R.styleable.MyAttrsView_custom_fraction2, 10, 100, 0);
            Log.e("TAG", "fraction: " + fraction); //fraction: 6.0
            Log.e("TAG", "fraction2: " + fraction2); //fraction2: 60.000004

            // 获取reference属性
            int resourceId = a.getResourceId(R.styleable.MyAttrsView_custom_resid, -1);
            Drawable drawable = a.getDrawable(R.styleable.MyAttrsView_custom_resid);
            Log.e("TAG", "resourceId: " + resourceId); //resourceId: 2131165298
            Log.e("TAG", "drawable: " + drawable); //drawable: android.graphics.drawable.BitmapDrawable@58e483c

            // 获取enum属性
            int anEnum = a.getInt(R.styleable.MyAttrsView_custom_enum, -1);
            Log.e("TAG", "enum: " + anEnum); //enum: 2
            switch (anEnum) {
                case ENUM_NONE:
                    Log.e("TAG", "无");
                    break;
                case ENUM_LEFT:
                    Log.e("TAG", "左边");
                    break;
                case ENUM_RIGHT:
                    Log.e("TAG", "右边");
                    break;
                case ENUM_TOP:
                    Log.e("TAG", "上边");
                    break;
                case ENUM_BOTTOM:
                    Log.e("TAG", "下边");
                    break;
            }
            //上边

            // 获取flags属性
            int flags = a.getInt(R.styleable.MyAttrsView_custom_flags, -1);
            Log.e("TAG", "flags: " + flags); //flags: 3
            if ((flags & FLAG_ENGLISH) != 0) {
                Log.e("TAG", "英语");
                flags &= ~FLAG_ENGLISH;
            }
            if ((flags & FLAG_CHINESE) != 0) {
                Log.e("TAG", "中文");
                flags &= ~FLAG_CHINESE;
            }
            if ((flags & FLAG_FRENCH) != 0) {
                Log.e("TAG", "法语");
                flags &= ~FLAG_FRENCH;
            }
            if ((flags & FLAG_JAPANESE) != 0) {
                Log.e("TAG", "日语");
                flags &= ~FLAG_JAPANESE;
            }
            //英语
            //法语

            a.recycle();
        }
    }
}
