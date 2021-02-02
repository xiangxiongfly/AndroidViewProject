package com.example.viewslidedemo;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.viewslidedemo.sample1.MyView;

public class MainActivity extends AppCompatActivity {

    private Button btnAnim;
    private MyView myView;
    private Context context;
    private Button btnAnimator;
    private Button btnScroller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        initViews();
    }

    private void initViews() {
        btnAnim = findViewById(R.id.btnAnim);
        btnAnimator = findViewById(R.id.btnAnimator);
        myView = findViewById(R.id.myView);
        btnScroller = findViewById(R.id.btnScroller);

        btnAnim.setOnClickListener(v ->
                myView.startAnimation(AnimationUtils.loadAnimation(context, R.anim.anim_translate))
        );
        btnAnimator.setOnClickListener(v ->
                ObjectAnimator.ofFloat(myView, "translationX", 0, 300).setDuration(1000).start()
        );
        btnScroller.setOnClickListener(v ->
                myView.smoothScrollTo(-300, -300, 1000)
        );
    }

}