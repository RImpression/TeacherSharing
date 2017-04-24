package com.example.teachersharing.ui.view.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.teachersharing.R;
import com.example.teachersharing.ui.view.LessonPlanDesign;

/**
 * Created by RImpression on 2016/9/24 0024.
 */
public class FragmentTeaching extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    private View view;
    private ListView listView;
    private FloatingActionButton floatingActionButton;
    private static final String[] args = new String[]{
            "《登岳阳楼》教案教学设计",
            "《背影》教案教学设计",
            "《三角函数》教案教学设计",
            "《测试教案》教案教学设计",
            "《贝加尔湖畔》教案教学设计",
            "《古诗三首》教案教学设计",
            "《写作技巧》教案教学设计",
            "《沁园春雪》教案教学设计",
            "《九月九日登高望远》教案教学设计",
            "《醉翁亭记》教案教学设计",
            "《春晓》教案教学设计",
            "《早》教案教学设计",
            "《梵高的艺术》教案教学设计",
            "《明月几时有》教案教学设计",
            "《现代古诗词解析》教案教学设计",
            "《这是一个教案》教案教学设计",
    };

    public static FragmentTeaching newInstance(String param1) {
        FragmentTeaching fragment = new FragmentTeaching();
        Bundle args = new Bundle();
        args.putString("args1",param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_teaching,container,false);
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();

        listView.setAdapter(new ArrayAdapter<String>(getActivity().getApplicationContext(),R.layout.item_teaching_list,args));
    }

    private void initView() {
        listView = (ListView) getView().findViewById(R.id.listview);
        floatingActionButton = (FloatingActionButton) getView().findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(this);
        listView.setOnItemClickListener(this);

    }



    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.floatingActionButton) {
            //跳转至添加教案界面
            Intent intent = new Intent();
            intent.setClass(getActivity().getApplicationContext(), LessonPlanDesign.class);
            startActivity(intent);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
