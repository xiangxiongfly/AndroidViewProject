package com.example.app.attrs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.app.R;
import com.example.app.base.BaseActivity;

public class MyAttrsActivity extends BaseActivity {

    public static void actionStart(Context context) {
        context.startActivity(new Intent(context, MyAttrsActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_attrs);
    }
}