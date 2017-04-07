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

import com.example.teachersharing.R;
import com.example.teachersharing.ui.view.LoginActivity;
import com.example.teachersharing.ui.view.RegisteredActivity;
import com.example.teachersharing.ui.view.TeachingQuestion;

/**
 * Created by RImpression on 2016/9/24 0024.
 */
public class FragmentPersonnal extends Fragment implements View.OnClickListener {

    private View view;
    private Button btnLogin,btnRegistered,btnQuestion;


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
        btnLogin = (Button) getView().findViewById(R.id.btnLogin);
        btnRegistered = (Button) getView().findViewById(R.id.btnRegistered);
        btnQuestion = (Button) getView().findViewById(R.id.btnQuestion);
        btnLogin.setOnClickListener(this);
        btnRegistered.setOnClickListener(this);
        btnQuestion.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btnLogin:
                intent.setClass(getActivity().getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                break;

            case R.id.btnRegistered:
                intent.setClass(getActivity().getApplicationContext(), RegisteredActivity.class);
                startActivity(intent);
                break;

            case R.id.btnQuestion:
                intent.setClass(getActivity().getApplicationContext(), TeachingQuestion.class);
                startActivity(intent);
                break;
        }
    }
}
