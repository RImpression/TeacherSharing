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
    private static final String[] args = new String[]{"课题1","课题2","课题3","课题4","课题5","课题6","课题7","课题8","课题9","课题10","课题11",
            "课题12","课题13","课题14","课题15","课题16","课题17"};

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

        listView.setAdapter(new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1,args));
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
