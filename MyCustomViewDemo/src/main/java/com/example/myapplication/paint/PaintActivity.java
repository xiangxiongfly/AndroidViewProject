package com.example.myapplication.paint;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.MyFragment;
import com.example.myapplication.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class PaintActivity extends AppCompatActivity {

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
        pageModels.add(new PageModel("setColor setARGB", MyView.class));
        pageModels.add(new PageModel("setStyle", StyleView.class));
        pageModels.add(new PageModel("setStyle", StyleCapView.class));
        pageModels.add(new PageModel("setStyle", ShadowLayerView.class));
        pageModels.add(new PageModel("setShader()", ShaderView.class));
        pageModels.add(new PageModel("setColorFilter()", ColorFilterView.class));
        pageModels.add(new PageModel("setXfermode()", XfermodeView.class));
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