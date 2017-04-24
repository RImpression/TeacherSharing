package com.example.teachersharing.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.teachersharing.R;
import com.example.teachersharing.ui.entity.NewsEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 添加教案适配器
 */
public class TeachingPlanAdapter extends BaseAdapter{

    private LayoutInflater mInflater;
    private List<String> planList = new ArrayList<>();
    private Context mContext;

    public TeachingPlanAdapter(Context context,List<String> list) {
        this.planList = list;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return planList.size();
    }

    @Override
    public Object getItem(int position) {
        return planList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String label = planList.get(position);
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_teaching_plan,null);
            holder.tvLabel = (TextView) convertView.findViewById(R.id.tvLabel);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvLabel.setText(label);

        return convertView;
    }

    static class ViewHolder {
        private TextView tvLabel;
    }
}
