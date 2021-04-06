package com.example.vieweventdemo.pkg3;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vieweventdemo.R;

public class ThreeActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        editText = findViewById(R.id.editText);
        editText.setText("asdfo    ajwhefop1uy234   啊；时代峰峻    啊事件阿莱克斯的肌肤；爱   上大声点激   发；脸上的肌肤了；啊   事件的发生开了家理发师简单父阿斯顿发门口了；阿斯顿发史蒂夫案例；上课的肌肤啊事件地方i筽片区危旧房拉上课；点击发送的放假啊了；事件的法律；是的肌肤；拉开始减肥啦快；事件地方；啊的发生发的；老师剪短发；爱丽丝就081234-10purjo;askldmflnlzxncvnz1221232yfjhgvwqewrwqrewtweryrttuyiyiuopohinkjln,nbmvcfgfddrtsasdfsdfgfdhgjjghjkh1323432423534255435436775889yigfhflkj卡；上课地方啊平时看到发上课地方啊；三闾大夫卡；'上岛咖啡啊；上课地方怕我可否；阿市领导，父；拉上课地方'奥克兰；受到法律的");


//        editText.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if ((v.getId() == editText.getId() && canVerticalScroll(editText))) {
//                    v.getParent().requestDisallowInterceptTouchEvent(true);
//                    if (event.getAction() == MotionEvent.ACTION_UP) {
//                        v.getParent().requestDisallowInterceptTouchEvent(false);
//                    }
//                }
//                return false;
//            }
//        });
    }

//    private boolean canVerticalScroll(EditText editText) {
//        //滚动的距离
//        int scrollY = editText.getScrollY();
//        //控件内容的总高度
//        int scrollRange = editText.getLayout().getHeight();
//        //控件实际显示的高度
//        int scrollExtent = editText.getHeight() - editText.getCompoundPaddingTop() - editText.getCompoundPaddingBottom();
//
//        //控件内容总高度与实际显示高度的差值
//        int scrollDifference = scrollRange - scrollExtent;
//        if (scrollDifference == 0) {
//            return false;
//        }
//        return (scrollY > 0) || (scrollY < scrollDifference - 1);
//    }

}