package com.example.teachersharing.ui.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.teachersharing.R;

/**
 * Created by RImpression on 2017/4/22 0022.
 */
public class QuestionDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_detail);
        initToolbar("问题详情",true);
        initViews();
    }

    private void initViews() {

    }
}
