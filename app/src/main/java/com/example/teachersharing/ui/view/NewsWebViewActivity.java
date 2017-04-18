package com.example.teachersharing.ui.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.teachersharing.R;

public class NewsWebViewActivity extends BaseActivity {

    private WebView webView;
    private String webUrl;
    private String title,content;
    private TextView tvTitle,tvContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_webview);

        webUrl = getIntent().getStringExtra("weburl");
        title = getIntent().getStringExtra("title");
        content = getIntent().getStringExtra("content");
        initToolbar("新闻详情",true);
        initViews();
    }

    private void initViews() {
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvContent = (TextView) findViewById(R.id.tvContent);
        tvTitle.setText(title);
        tvContent.setText(content);
    }
}
