package com.example.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TitleBar extends RelativeLayout {
    private ImageView titlebar_back;
    private ImageView titlebar_right;
    private TextView titlebar_title;
    private RelativeLayout titlebar_root;

    private int mBgColor = Color.BLUE;
    private int mTextColor = Color.WHITE;
    private String mTitle;

    public TitleBar(Context context) {
        this(context, null);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TitleBar);
            mBgColor = a.getColor(R.styleable.TitleBar_title_bg, Color.BLUE);
            mTextColor = a.getColor(R.styleable.TitleBar_title_text_color, Color.WHITE);
            mTitle = a.getString(R.styleable.TitleBar_title);
            a.recycle();
        }

        LayoutInflater.from(context).inflate(R.layout.view_titlebar, this, true);
        titlebar_root = findViewById(R.id.titlebar_root);
        titlebar_back = findViewById(R.id.titlebar_back);
        titlebar_right = findViewById(R.id.titlebar_right);
        titlebar_title = findViewById(R.id.titlebar_tittle);
        titlebar_root.setBackgroundColor(mBgColor);
        titlebar_title.setTextColor(mTextColor);
        setTitle(mTitle);
    }

    public void setTitle(String mTitle) {
        if (!TextUtils.isEmpty(mTitle)) {
            titlebar_title.setText(mTitle);
        }
    }

    public void setOnLeftListener(OnClickListener onClickListener) {
        titlebar_back.setOnClickListener(onClickListener);
    }

    public void setOnRightListener(OnClickListener onClickListener) {
        titlebar_right.setOnClickListener(onClickListener);
    }
}
