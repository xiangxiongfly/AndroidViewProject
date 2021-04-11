package com.example.vieweventdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vieweventdemo.pkg1.OneActivity;
import com.example.vieweventdemo.pkg2.TwoActivity;
import com.example.vieweventdemo.pkg3.ThreeActivity;
import com.example.vieweventdemo.pkg4.NestedActivity;

public class MainActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
    }

    public void click1(View view) {
        startActivity(new Intent(context, OneActivity.class));
    }

    public void click2(View view) {
        startActivity(new Intent(context, TwoActivity.class));
    }

    public void click3(View view) {
        startActivity(new Intent(context, ThreeActivity.class));
    }

    public void click4(View view) {
        startActivity(new Intent(context, NestedActivity.class));
    }
}
