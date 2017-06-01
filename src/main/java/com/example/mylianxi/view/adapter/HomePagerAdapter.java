package com.example.mylianxi.view.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.example.mylianxi.present.HomePresent;

import java.util.List;

/**
 * 类用途 :
 * 作者 : 郁文涛
 * 时间 : 2017/5/30 19:41
 */

public class HomePagerAdapter extends FragmentPagerAdapter {
    private HomePresent mpresenter;
    private List<Fragment> fragments;
    private List<String> mlist;
//    private List<Bean.DataBean.ComicsBean> mlist;
    private Context mcontext;

    public HomePagerAdapter(FragmentManager fm, List<Fragment> fragment, Context context, List<String> list) {
        super(fm);
        this.fragments = fragment;
        this.mcontext = context;
        this.mlist = list;
    }


    @Override
    public int getCount() {

        return fragments.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {

        return mlist.get(position);
    }

    public void setHomePresent(HomePresent presenter) {
        this.mpresenter = presenter;
    }

    public void setDataBean(List<String> date) {
        if (date != null) {
            this.mlist.addAll(date);
        }
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);

    }
}
