package com.example.teachersharing.ui.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.teachersharing.R;

/**
 * 资源上传
 * Created by user on 2017/4/11.
 */

public class SourceUploadActivity extends BaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source_upload);
        initToolbar("资源上传",true);
        initViews();

    }

    private void initViews() {

    }
}
