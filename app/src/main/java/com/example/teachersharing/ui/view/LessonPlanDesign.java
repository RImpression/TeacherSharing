package com.example.teachersharing.ui.view;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.teachersharing.R;
import com.example.teachersharing.ui.adapter.TeachingPlanAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 教案设计
 */
public class LessonPlanDesign extends BaseActivity {

    private EditText edtPlanTitle,edtPlanType,edtPlanTime;
    private ListView listPlan;
    private TeachingPlanAdapter adapter;
    private FloatingActionButton floatingButton;

    private static final List<String> data = new ArrayList<>();

    private static final String[] args = new String[]{
            "教学目的",
            "教学重点",
            "教学难点",
            "教学方法",
            "教学过程",
            "作业布置",
            "板书设计",
            "教具准备",
            "教学反思"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_plan_design);
        initToolbar("教案设计",true);
        data.add("教学目的");
        data.add("教学重点");
        data.add("教学难点");
        data.add("教学方法");
        data.add("教学过程");
        data.add("作业布置");
        data.add("板书设计");
        data.add("教具准备");
        data.add("教学反思");

        initViews();
    }

    private void initViews() {
        edtPlanTitle = (EditText) findViewById(R.id.edtPlanTitle);
        edtPlanType = (EditText) findViewById(R.id.edtPlanType);
        edtPlanTime = (EditText) findViewById(R.id.edtPlanTime);
        listPlan = (ListView) findViewById(R.id.listPlan);
        adapter = new TeachingPlanAdapter(this,data);
        listPlan.setAdapter(adapter);
    }
}
