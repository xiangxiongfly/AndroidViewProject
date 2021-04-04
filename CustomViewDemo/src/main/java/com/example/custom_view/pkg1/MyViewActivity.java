package com.example.custom_view.pkg1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.custom_view.R;

public class MyViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view);
    }
}