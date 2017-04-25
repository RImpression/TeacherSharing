package com.example.teachersharing.ui.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.teachersharing.R;

/**
 * 发布问题
 */

public class CreateQuestionActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_question);
        initToolbar("发布问题",true);
    }
}
