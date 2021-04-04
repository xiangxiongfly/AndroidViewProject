package com.example.custom_view.pkg2;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.custom_view.R;

public class MyViewGroupActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view_group);
        context = this;

        TitleBar titleBar = findViewById(R.id.titleBar);
        titleBar.setOnLeftListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "左边", Toast.LENGTH_SHORT).show();
            }
        });
        titleBar.setOnRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "右边", Toast.LENGTH_SHORT).show();
            }
        });
    }
}