package com.example.teachersharing.ui.view;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.example.teachersharing.R;

/**
 * 我的笔记
 * Created by user on 2017/4/11.
 */

public class MyNoteActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mynote);
        initToolbar("笔记",true);
        initViews();
    }

    private void initViews() {

    }
}
