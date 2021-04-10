package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.canvas.CanvasActivity;
import com.example.myapplication.paint.PaintActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void clickCanvas(View view){
        startActivity(new Intent(MainActivity.this, CanvasActivity.class));
    }

    public void clickPaint(View view){
        startActivity(new Intent(MainActivity.this, PaintActivity.class));
    }
}