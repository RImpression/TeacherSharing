package com.example.teachersharing.ui.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.teachersharing.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RImpression on 2016/9/24 0024.
 */
public class FragmentContacts extends Fragment implements View.OnClickListener {
    private View view;
    private LinearLayout btnAttention;
    private ListView lvContacts;


    public static FragmentContacts newInstance(String param1) {
        FragmentContacts fragment = new FragmentContacts();
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
            view = inflater.inflate(R.layout.fragment_contacts,container,false);
        }
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();
    }

    private void initView() {
        btnAttention = (LinearLayout) getView().findViewById(R.id.btnAttention);
        lvContacts = (ListView) getView().findViewById(R.id.lvContacts);
        btnAttention.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAttention){
            //跳转至关注界面
            Intent intent = new Intent();
        }
    }
}
