package com.example.app;

import android.os.Bundle;
import android.view.View;

import com.example.app.attrs.MyAttrsActivity;
import com.example.app.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_attrs:
                MyAttrsActivity.actionStart(context);
                break;
        }

    }
}