package com.example.teachersharing.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.teachersharing.R;
import com.example.teachersharing.ui.entity.QuestionEntity;
import com.example.teachersharing.ui.util.PreferencesUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 问题列表适配器
 */

public class QuestionListAdapter extends BaseAdapter{
    private LayoutInflater mInflater;
    private List<QuestionEntity> questionList = new ArrayList<>();
    private Context mContext;

    public QuestionListAdapter(Context context,List<QuestionEntity> list) {
        this.mContext = context;
        this.questionList = list;
        this.mInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return questionList.size();
    }

    @Override
    public Object getItem(int position) {
        return questionList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        QuestionEntity entity = questionList.get(position);
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_question_list,null);
            holder.tvTitle = (TextView) convertView.findViewById(R.id.tvQuestionTitle);
            holder.tvAuthor = (TextView) convertView.findViewById(R.id.tvQuestionAuthor);
            holder.tvDate = (TextView) convertView.findViewById(R.id.tvQuestionDate);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvTitle.setText(entity.getTitle());
        holder.tvAuthor.setText(entity.getLabel());
        holder.tvDate.setText(entity.getCreateDate());

        return convertView;
    }

    static class ViewHolder {
        private TextView tvTitle,tvAuthor,tvDate;
    }
}
