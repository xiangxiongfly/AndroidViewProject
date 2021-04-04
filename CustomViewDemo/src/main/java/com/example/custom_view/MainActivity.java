package com.example.custom_view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.custom_view.pkg1.MyViewActivity;
import com.example.custom_view.pkg2.MyViewGroupActivity;
import com.example.custom_view.pkg3.MyViewGroup2Activity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickMyView(View view) {
        startActivity(new Intent(this, MyViewActivity.class));
    }

    public void clickMyViewGroup(View view) {
        startActivity(new Intent(this, MyViewGroupActivity.class));
    }
    public void clickMyViewGroup2(View view) {
        startActivity(new Intent(this, MyViewGroup2Activity.class));
    }
}