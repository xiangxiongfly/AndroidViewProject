package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    private ArrayList<PageModel> pageModels = new ArrayList<>();
    private FragmentPagerAdapter pagerAdapter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        initData();
        initViews();
    }

    private void initData() {
        pageModels.add(new PageModel("drawColor()", DrawColorView.class));
        pageModels.add(new PageModel("drawCircle()", DrawCircleView.class));
        pageModels.add(new PageModel("drawRect()", DrawRectView.class));
        pageModels.add(new PageModel("drawRoundRect()", DrawRoundRectView.class));
        pageModels.add(new PageModel("drawPoint()", DrawPointView.class));
        pageModels.add(new PageModel("drawPoints()", DrawPointsView.class));
        pageModels.add(new PageModel("drawOval()", DrawOvalView.class));
        pageModels.add(new PageModel("drawLine()", DrawLineView.class));
        pageModels.add(new PageModel("drawLines()", DrawLinesView.class));
        pageModels.add(new PageModel("drawArc()", DrawArcView.class));
        pageModels.add(new PageModel("drawBitmap()", DrawBitmapView.class));
        pageModels.add(new PageModel("drawText()", DrawTextView.class));

    }

    private void initViews() {
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
        pagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                PageModel pageModel = pageModels.get(position);
                return MyFragment.newInstance(pageModel.title, pageModel.clz);
            }

            @Override
            public int getCount() {
                return pageModels.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                PageModel pageModel = pageModels.get(position);
                return pageModel.title;
            }
        };
        viewPager.setAdapter(pagerAdapter);

    }

    class PageModel {
        String title;
        Class clz;

        public PageModel(String title, Class clz) {
            this.title = title;
            this.clz = clz;
        }
    }
}