package com.example.vieweventdemo.pkg4;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vieweventdemo.R;

public class NestedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nested);
    }
}