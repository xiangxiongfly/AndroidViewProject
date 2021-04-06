package com.example.vieweventdemo.pkg2;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vieweventdemo.R;

import java.util.ArrayList;

public class TwoActivity extends AppCompatActivity {
    private ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        ListView listView = findViewById(R.id.listView);


        for (int i = 0; i < 15; i++) {
            list.add(String.valueOf(i));
        }
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list));
    }
}