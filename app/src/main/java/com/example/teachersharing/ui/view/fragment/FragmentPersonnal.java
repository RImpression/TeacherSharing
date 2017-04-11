package com.example.teachersharing.ui.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.teachersharing.R;
import com.example.teachersharing.ui.view.CourseManagement;
import com.example.teachersharing.ui.view.LoginActivity;
import com.example.teachersharing.ui.view.MyResources;
import com.example.teachersharing.ui.view.RegisteredActivity;
import com.example.teachersharing.ui.view.TeachingQuestion;
import com.example.teachersharing.ui.view.UserInformation;

/**
 * Created by RImpression on 2016/9/24 0024.
 */
public class FragmentPersonnal extends Fragment implements View.OnClickListener {

    private View view;
    private LinearLayout lyCourse,lyQuestion,lyUpload,lyDownload,lyMyCourse,lyNote,lyAuthor;


    public static FragmentPersonnal newInstance(String param1) {
        FragmentPersonnal fragment = new FragmentPersonnal();
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
            view = inflater.inflate(R.layout.fragment_personal,container,false);
        }
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initViews();
    }


    private void initViews() {
        lyAuthor = (LinearLayout) getView().findViewById(R.id.layoutAuthor);
        lyCourse = (LinearLayout) getView().findViewById(R.id.layoutCourse);
        lyQuestion = (LinearLayout) getView().findViewById(R.id.layoutQuestion);
        lyUpload = (LinearLayout) getView().findViewById(R.id.layoutUpload);
        lyDownload = (LinearLayout) getView().findViewById(R.id.layoutDownload);
        lyMyCourse = (LinearLayout) getView().findViewById(R.id.layoutMyCourse);
        lyNote = (LinearLayout) getView().findViewById(R.id.layoutNote);
        lyAuthor.setOnClickListener(this);
        lyCourse.setOnClickListener(this);
        lyQuestion.setOnClickListener(this);
        lyUpload.setOnClickListener(this);
        lyDownload.setOnClickListener(this);
        lyMyCourse.setOnClickListener(this);
        lyNote.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.layoutAuthor:
                intent.setClass(getActivity().getApplicationContext(), UserInformation.class);
                startActivity(intent);
                break;
            case R.id.layoutCourse:
                intent.setClass(getActivity().getApplicationContext(), CourseManagement.class);
                startActivity(intent);
                break;
            case R.id.layoutQuestion:
                intent.setClass(getActivity().getApplicationContext(),TeachingQuestion.class);
                startActivity(intent);
                break;
            case R.id.layoutUpload:

                break;
            case R.id.layoutDownload:

                break;
            case R.id.layoutMyCourse:
                intent.setClass(getActivity().getApplicationContext(), MyResources.class);
                startActivity(intent);
                break;
            case R.id.layoutNote:

                break;
        }
    }
}
