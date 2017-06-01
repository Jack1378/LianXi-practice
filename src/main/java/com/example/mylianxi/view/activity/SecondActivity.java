package com.example.mylianxi.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.example.mylianxi.R;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends Activity {

    private GridView grid_view_me;
    private GridView grid_view_more;
    private ArrayList<String> list;
    private GridAdapter meAdapter;
    private GridAdapter moreAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        Intent intent = getIntent();
        list = intent.getStringArrayListExtra("name");

        initView();
        initData();
    }

    private void initView() {
        grid_view_me = (GridView) findViewById(R.id.grid_view_me);
        grid_view_more = (GridView) findViewById(R.id.grid_view_more);

    }

    private void initData() {
        meAdapter = new GridAdapter(0);
        moreAdapter = new GridAdapter(1);
        ArrayList<String> meList = new ArrayList<>();
        ArrayList<String> moreList = new ArrayList<>();
        for (int i = 0; i < list.size() / 2; i++) {
            meList.add(list.get(i));
        }
        for (int i = list.size() / 2; i < list.size(); i++) {
            moreList.add(list.get(i));
        }
        meAdapter.setList(meList);
        moreAdapter.setList(moreList);
        meAdapter.notifyDataSetChanged();
        moreAdapter.notifyDataSetChanged();
        grid_view_me.setAdapter(meAdapter);
        grid_view_more.setAdapter(moreAdapter);
    }

    class GridAdapter extends BaseAdapter {

        private List<String> ssss = new ArrayList<>();
        private int type;

        public GridAdapter(int type) {
            this.type = type;
        }

        public void addItem(String ss) {
            ssss.add(ss);
            notifyDataSetChanged();
        }

        public void deleteItem(int position) {
            ssss.remove(position);
            notifyDataSetChanged();
        }

        public String getItemss(int position) {
            String items = ssss.get(position);
            return items;
        }

        @Override
        public int getCount() {
            return ssss.size();
        }

        @Override
        public Object getItem(int position) {
            return ssss.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            GridHolder holder;
            if (convertView == null) {
                convertView = View.inflate(SecondActivity.this, R.layout.grid_item, null);
                holder = new GridHolder();
                holder.textView = (TextView) convertView.findViewById(R.id.grid_item_text);
                convertView.setTag(holder);
            } else {
                holder = (GridHolder) convertView.getTag();
            }
            holder.textView.setText(ssss.get(position));
            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (type == 0) {
                        String itemss = meAdapter.getItemss(position);
                        meAdapter.deleteItem(position);
                        moreAdapter.addItem(itemss);
                    } else if (type == 1) {
                        String itemss = moreAdapter.getItemss(position);
                        moreAdapter.deleteItem(position);
                        meAdapter.addItem(itemss);
                    }
                }
            });

            return convertView;
        }

        public void setList(ArrayList<String> datas) {
            if (datas != null) {
                ssss.addAll(datas);
            }
        }
    }

    static class GridHolder {
        TextView textView;
    }

}
