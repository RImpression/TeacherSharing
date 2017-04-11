package com.example.teachersharing.ui.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.teachersharing.R;

/**
 * Created by user on 2017/4/11.
 */

public class SourceDownloadActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source_download);
        initToolbar("资源下载",true);
        initViews();
    }

    private void initViews() {

    }
}
