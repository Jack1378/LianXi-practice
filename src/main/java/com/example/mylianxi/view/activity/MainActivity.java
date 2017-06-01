package com.example.mylianxi.view.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.mylianxi.R;
import com.example.mylianxi.mondel.bean.Bean;
import com.example.mylianxi.present.HomePresent;
import com.example.mylianxi.view.adapter.HomePagerAdapter;
import com.example.mylianxi.view.fragment.FragMent;
import com.example.mylianxi.view.iview.IhomeView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IhomeView<Bean> {

    private TabLayout tabLayout;
    private HomePagerAdapter adapter;
    private List<Fragment> fragments = new ArrayList<>();
    private FragmentManager fm;
    private HomePresent homePresent;
    private ViewPager viewPager;
    private String[] ss = {"周一", "周二", "周三", "周四", "周五", "周六", "周日"};
    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

    }

    private void initData() {
        tabLayout = (TabLayout) findViewById(R.id.tablelayouts);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        fm = getSupportFragmentManager();
        homePresent = new HomePresent();
        homePresent.attachView(this);

        tabLayout.setupWithViewPager(viewPager);
        homePresent.getDataFromServer(Bean.class);

    }

    @Override
    public void callBackHH(Bean bean) {
        adapter = new HomePagerAdapter(fm, fragments, MainActivity.this, list);
        adapter.setHomePresent(homePresent);
        viewPager.setAdapter(adapter);
        for (int i = 0; i < 7; i++) {
            list.add(ss[i]);
            FragMent fragMent = new FragMent(bean.getData().getComics());
            fragments.add(fragMent);
        }

        adapter.setDataBean(list);
        adapter.notifyDataSetChanged();
    }
}

