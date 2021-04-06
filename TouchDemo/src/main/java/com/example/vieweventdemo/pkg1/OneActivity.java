package com.example.vieweventdemo.pkg1;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.vieweventdemo.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class OneActivity extends AppCompatActivity {

    private Context context;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    private String[] titles = {"One", "Two", "Three"};
    private int[] imgs = {R.drawable.a2, R.drawable.a3, R.drawable.a4};
    private ArrayList<ImageFragment> fragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        context = this;
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        for (int i = 0; i < imgs.length; i++) {
            fragments.add(ImageFragment.newInstance(titles[i], imgs[i]));
        }

        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), fragments, titles));

    }

    class MyPagerAdapter extends FragmentPagerAdapter {
        private ArrayList<ImageFragment> fragments;
        private String[] titles;

        public MyPagerAdapter(@NonNull FragmentManager fm, ArrayList<ImageFragment> fragments, String[] titles) {
            super(fm);
            this.fragments = fragments;
            this.titles = titles;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }

}