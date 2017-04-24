package com.example.teachersharing.ui.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.teachersharing.R;

/**
 * 查找资源
 */
public class SearchSourcesActivity extends BaseActivity{
    private Toolbar toolbar;
    private EditText edtSearch;
    private ListView listSource;
    private static final String[] args = new String[]{
            "《登岳阳楼》教学教案设计（人教版高一选修）",
            "《登岳阳楼》教案设计（人教版高二选修）",
            "《登岳阳楼》教案教学设计",
            "登岳阳楼教案（语文版必修2）",
            "《登岳阳楼》陈与义",

    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_sources);
        toolbar = (Toolbar) findViewById(R.id.searchToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//显示返回按键
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initViews();
    }

    private void initViews() {
        edtSearch = (EditText) findViewById(R.id.edtSerach);
        listSource = (ListView) findViewById(R.id.listSource);
        listSource.setAdapter(new ArrayAdapter<String>(this,R.layout.item_teaching_list,args));
    }
}
