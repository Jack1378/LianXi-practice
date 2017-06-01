package com.example.mylianxi.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.mylianxi.R;
import com.example.mylianxi.mondel.bean.Bean;
import com.example.mylianxi.present.HomePresent;
import com.example.mylianxi.view.adapter.FragBasAdapter;
import com.example.mylianxi.view.iview.IhomeView;
import com.limxing.xlistview.view.XListView;

import java.util.List;



public class FragMent extends Fragment implements IhomeView<Bean> {

    private List<Bean.DataBean.ComicsBean> list;
    private XListView xListView;
    private HomePresent homePresent;
    private FragBasAdapter adapter;

    public FragMent(List<Bean.DataBean.ComicsBean> comics) {
        this.list = comics;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
    }

    private void initView() {
        xListView = (XListView) getView().findViewById(R.id.xlist_view);
        homePresent = new HomePresent();
        homePresent.attachView(this);
        homePresent.getDataFromServer(Bean.class);

    }

    @Override
    public void callBackHH(Bean bean) {
        adapter = new FragBasAdapter(bean.getData().getComics(), getActivity());
        adapter.setHomePresent(homePresent);
        xListView.setAdapter(adapter);
        adapter.setDataBean(list);
        adapter.notifyDataSetChanged();
    }
}
