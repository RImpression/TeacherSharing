package com.example.teachersharing.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.teachersharing.R;
import com.example.teachersharing.ui.entity.SourceEntity;
import com.example.teachersharing.ui.view.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ResourceListAdapter extends BaseAdapter{
    private LayoutInflater mInflater;
    private List<SourceEntity> sourceList = new ArrayList<>();
    private Context mContext;

    public ResourceListAdapter(Context context,List<SourceEntity> list) {
        this.sourceList = list;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return sourceList.size();
    }

    @Override
    public Object getItem(int position) {
        return sourceList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        SourceEntity entity = sourceList.get(position);
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_resource_list,null);
            holder.tvLabel = (TextView) convertView.findViewById(R.id.tvText);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvLabel.setText(entity.getName());

        return convertView;
    }

    static class ViewHolder {
        private TextView tvLabel;
    }
}
