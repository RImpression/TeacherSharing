package com.example.teachersharing.ui.view.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.teachersharing.R;

/**
 * Created by RImpression on 2016/9/24 0024.
 */
public class FragmentTeaching extends Fragment {

    private View view;

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
}
