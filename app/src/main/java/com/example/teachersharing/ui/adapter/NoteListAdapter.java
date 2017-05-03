package com.example.teachersharing.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.teachersharing.R;
import com.example.teachersharing.ui.entity.NoteEntity;
import com.example.teachersharing.ui.util.PreferencesUtils;
import com.example.teachersharing.ui.view.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 笔记列表适配器
 */
public class NoteListAdapter extends BaseAdapter{
    private LayoutInflater mInflater;
    private List<NoteEntity> noteList = new ArrayList<>();
    private Context mContext;

    public NoteListAdapter(Context context,List<NoteEntity> list) {
        this.mContext = context;
        this.noteList = list;
        this.mInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return noteList.size();
    }

    @Override
    public Object getItem(int position) {
        return noteList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NoteEntity entity = noteList.get(position);
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
        Log.i("note",entity.getTitle());
        holder.tvTitle.setText(entity.getTitle());
        holder.tvAuthor.setText(PreferencesUtils.getString(mContext,"username"));
        holder.tvDate.setText(entity.getCreateDate());

        return convertView;
    }

    static class ViewHolder {
        private TextView tvTitle,tvAuthor,tvDate;
    }
}
