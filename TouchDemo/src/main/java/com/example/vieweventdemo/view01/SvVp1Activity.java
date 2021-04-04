package com.example.vieweventdemo.view01;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.vieweventdemo.R;

/**
 * ScrollView+ViewPager: 外部拦截法
 */
public class SvVp1Activity extends AppCompatActivity {

    private MyScrollView scrollView;
    private ViewPager viewPager;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sv_vp);
        initViews();
        mContext = this;
    }

    private void initViews() {
        scrollView = findViewById(R.id.scrollView);
        viewPager = findViewById(R.id.viewPager);

        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return 5;
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                ImageView imageView = new ImageView(mContext);
                imageView.setImageResource(R.mipmap.ic_launcher_round);
                container.addView(imageView);
                return imageView;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView((ImageView) object);
            }
        });
    }
}