package com.example.teachersharing.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.teachersharing.R;
import com.example.teachersharing.ui.entity.NewsEntity;

import java.util.ArrayList;
import java.util.List;


public class NewsAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<NewsEntity> newsList = new ArrayList<>();
    private Context mContext;

    public NewsAdapter(Context content,List<NewsEntity> entities) {
        this.newsList = entities;
        this.mContext = content;
        this.mInflater = LayoutInflater.from(content);
    }

    @Override
    public int getCount() {
        return newsList.size();
    }

    @Override
    public Object getItem(int position) {
        return newsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NewsEntity entity = newsList.get(position);
        ViewHolder hodler;
        if (convertView == null) {
            hodler = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_news,null);
            hodler.tvNewsTitle = (TextView) convertView.findViewById(R.id.tvNewsTitle);
            hodler.tvNewsDate = (TextView) convertView.findViewById(R.id.tvNewsDate);
            hodler.tvNewSource = (TextView) convertView.findViewById(R.id.tvNewsSource);
            convertView.setTag(hodler);

        } else {
            hodler = (ViewHolder) convertView.getTag();
        }
        hodler.tvNewsTitle.setText(entity.getTitle());
        hodler.tvNewsDate.setText(entity.getPubtime());
        hodler.tvNewSource.setText(entity.getSource());

        return convertView;
    }

    static class ViewHolder {
        private TextView tvNewsTitle,tvNewsDate,tvNewSource;
    }
}
