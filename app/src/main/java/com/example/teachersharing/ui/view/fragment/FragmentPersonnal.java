package com.example.teachersharing.ui.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.teachersharing.R;
import com.example.teachersharing.ui.view.CreateNoteActivity;
import com.example.teachersharing.ui.view.CreateQuestionActivity;
import com.example.teachersharing.ui.view.MyNoteActivity;
import com.example.teachersharing.ui.view.MyResourcesActivity;
import com.example.teachersharing.ui.view.SearchSourcesActivity;
import com.example.teachersharing.ui.view.SourceUploadActivity;
import com.example.teachersharing.ui.view.UserInformation;

/**
 * Created by RImpression on 2016/9/24 0024.
 */
public class FragmentPersonnal extends Fragment implements View.OnClickListener {

    private View view;
    private LinearLayout lySearch,lyUpload,lySourceList,lyQuestion,lyAddNote,lyNoteList,lyAuthor;


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
        lyUpload = (LinearLayout) getView().findViewById(R.id.layoutUpload);
        lySearch = (LinearLayout) getView().findViewById(R.id.layoutSearch);
        lySourceList = (LinearLayout) getView().findViewById(R.id.layoutSourceList);
        lyQuestion = (LinearLayout) getView().findViewById(R.id.layoutQuestion);
        lyAddNote = (LinearLayout) getView().findViewById(R.id.layoutAddNote);
        lyNoteList = (LinearLayout) getView().findViewById(R.id.layoutNoteList);
        lyUpload.setOnClickListener(this);
        lySearch.setOnClickListener(this);
        lySourceList.setOnClickListener(this);
        lyQuestion.setOnClickListener(this);
        lyAddNote.setOnClickListener(this);
        lyNoteList.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.layoutAuthor:
                intent.setClass(getActivity().getApplicationContext(), UserInformation.class);
                startActivity(intent);
                break;

            case R.id.layoutUpload:
                intent.setClass(getActivity().getApplicationContext(), SourceUploadActivity.class);
                startActivity(intent);
                break;

            case R.id.layoutSearch:
                intent.setClass(getActivity().getApplicationContext(), SearchSourcesActivity.class);
                startActivity(intent);
                break;

            case R.id.layoutSourceList:
                intent.setClass(getActivity().getApplicationContext(), MyResourcesActivity.class);
                startActivity(intent);
                break;

            case R.id.layoutQuestion:
                intent.setClass(getActivity().getApplicationContext(), CreateQuestionActivity.class);
                startActivity(intent);
                break;

            case R.id.layoutAddNote:
                intent.setClass(getActivity().getApplicationContext(),CreateNoteActivity.class);
                startActivity(intent);
                break;

            case R.id.layoutNoteList:
                intent.setClass(getActivity().getApplicationContext(), MyNoteActivity.class);
                startActivity(intent);
                break;


        }
    }
}
