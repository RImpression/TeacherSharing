package com.example.teachersharing.ui.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.teachersharing.R;
import com.example.teachersharing.ui.entity.AnswerEntity;

import java.util.ArrayList;
import java.util.List;

public class AnswerAdapter extends BaseAdapter{
    private LayoutInflater mInflater;
    private List<AnswerEntity> answerList = new ArrayList<>();
    private Context mContext;

    public AnswerAdapter(Context context,List<AnswerEntity> list) {
        this.mContext = context;
        this.answerList = list;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return answerList.size();
    }

    @Override
    public Object getItem(int position) {
        return answerList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AnswerEntity entity = answerList.get(position);
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_answer_detail,null);
            holder.tvDate = (TextView) convertView.findViewById(R.id.tvDate);
            holder.tvContent = (TextView) convertView.findViewById(R.id.tvContent);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvDate.setText(entity.getCreateDate());
        holder.tvContent.setText(entity.getContent());
        return convertView;
    }

    static class ViewHolder {
        private TextView tvDate,tvContent;
    }
}
