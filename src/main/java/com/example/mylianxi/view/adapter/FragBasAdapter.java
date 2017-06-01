package com.example.mylianxi.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mylianxi.R;
import com.example.mylianxi.mondel.bean.Bean;
import com.example.mylianxi.present.HomePresent;
import com.example.mylianxi.view.activity.SecondActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 类用途 :
 * 作者 : 郁文涛
 * 时间 : 2017/5/30 19:58
 */

public class FragBasAdapter extends BaseAdapter {
    private List<Bean.DataBean.ComicsBean> list;
    private Context context;
    private HomePresent homePresent;
    private ArrayList<String> stringList = new ArrayList<>();

    public FragBasAdapter(List<Bean.DataBean.ComicsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {

        return list.size();
    }

    @Override
    public Object getItem(int position) {

        return list.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_fragment, null);
            holder = new ViewHolder();
            holder.textView1 = (TextView) convertView.findViewById(R.id.item_text1);
            holder.textView2 = (TextView) convertView.findViewById(R.id.item_text2);
            holder.textView3 = (TextView) convertView.findViewById(R.id.item_text3);
            holder.textView4 = (TextView) convertView.findViewById(R.id.item_text4);
            holder.imageView = (ImageView) convertView.findViewById(R.id.item_image);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView1.setText(list.get(position).getLabel_text());
        holder.textView2.setText(list.get(position).getTopic().getUser().getNickname());
        holder.textView4.setText(list.get(position).getTitle());
        homePresent.getImage(holder.imageView, list.get(position).getCover_image_url());

        holder.textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putStringArrayListExtra("name", stringList);
                context.startActivity(intent);
            }
        });
        return convertView;


    }

    public void setDataBean(List<Bean.DataBean.ComicsBean> datas) {
        if (datas != null) {
            list.addAll(datas);
            for (int i = 0; i < datas.size(); i++) {
                stringList.add(datas.get(i).getLabel_text());
            }

        }
    }

    public void setHomePresent(HomePresent homePresent) {
        this.homePresent = homePresent;
    }

    static class ViewHolder {
        TextView textView1;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        ImageView imageView;
    }
}
