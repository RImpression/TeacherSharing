package com.example.teachersharing.ui.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.teachersharing.R;

/**
 * 教学问题发布
 */
public class TeachingQuestion extends BaseActivity {
    private EditText edtTitle,edtContent;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teaching_question);
        initToolbar("教学问题",true);
        initView();
    }

    private void initView() {
        edtTitle = (EditText) findViewById(R.id.edtTitle);
        edtContent = (EditText) findViewById(R.id.edtContent);
        btnSave = (Button) findViewById(R.id.btnSave);

    }
}
