package com.example.app;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
//        TitleBar tilebar = findViewById(R.id.tilebar);
//        tilebar.setOnLeftListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "左边", Toast.LENGTH_SHORT).show();
//            }
//        });
//        tilebar.setOnRightListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "右边", Toast.LENGTH_SHORT).show();
//            }
//        });


    }
}