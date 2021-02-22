package com.example.app;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class MyViewGroupActivity extends AppCompatActivity {

    private ListView listView2;
    private ListView listView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view_group);


        listView1 = (ListView) this.findViewById(R.id.listView1);
        listView2 = (ListView) this.findViewById(R.id.listView2);

        String[] strs1 = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, strs1);
        listView1.setAdapter(adapter1);

        String[] strs2 = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, strs2);
        listView2.setAdapter(adapter2);
    }
}