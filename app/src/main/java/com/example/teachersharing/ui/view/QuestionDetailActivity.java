package com.example.teachersharing.ui.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.example.teachersharing.R;
import com.example.teachersharing.ui.adapter.AnswerAdapter;
import com.example.teachersharing.ui.entity.AnswerEntity;
import com.example.teachersharing.ui.entity.UserInfoEntity;
import com.example.teachersharing.ui.http.MyRequest;
import com.example.teachersharing.ui.interfaces.HttpListener;
import com.example.teachersharing.ui.util.Api;
import com.example.teachersharing.ui.util.PreferencesUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RImpression on 2017/4/22 0022.
 */
public class QuestionDetailActivity extends BaseActivity {
    private String title,content;
    private TextView tvTitle,tvContent;
    private String id,token,userId;
    private String ANSWER_URL,USERINFO_URL;
    private List<AnswerEntity> answerList;
    private List<UserInfoEntity> userInfoList;
    private ListView listView;
    private AnswerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_detail);
        initToolbar("问题详情",true);
        id = PreferencesUtils.getString(this,"id");
        token = PreferencesUtils.getString(this,"token");
        USERINFO_URL = Api.USERINFO_URL+id+"?token="+token;
        userId = getIntent().getStringExtra("userId");
        title = getIntent().getStringExtra("title");
        content = getIntent().getStringExtra("content");
        ANSWER_URL = Api.ANSWER_GET+userId+"?token="+token;

        requestAnswer(ANSWER_URL);
        initViews();
    }

    private void requestAnswer(String answer_url) {
        MyRequest.getRequest(this, answer_url, new HttpListener() {
            @Override
            public void onSuccess(String result) {
                Log.i("result",result);
                answerList = parse2Json(result);
                setListView();
            }

            @Override
            public void onError(VolleyError volleyError) {
                ShowToast("网络请求失败...");
            }
        });
    }

    private void setListView() {
        tvTitle.setText(title);
        tvContent.setText(content);
        adapter = new AnswerAdapter(this,answerList);
        listView.setAdapter(adapter);

    }

    private List<AnswerEntity> parse2Json(String result) {
        List<AnswerEntity> list = null;
        try {
            list = new ArrayList<>();
            JSONObject jsonObject = new JSONObject(result);
            JSONObject dataObject = jsonObject.getJSONObject("data");
            JSONArray answers = dataObject.getJSONArray("notes");
            for (int i=0;i<answers.length();i++) {
                AnswerEntity entity = new AnswerEntity();
                JSONObject answerObject = answers.getJSONObject(i);
                entity.setId(answerObject.getString("id"));
                entity.setUserId(answerObject.getString("userId"));
                entity.setQuestionId(answerObject.getString("questionId"));
                entity.setContent(answerObject.getString("content"));
                entity.setCreateDate(answerObject.getString("createDate"));
                entity.setPraise(answerObject.getString("praise"));
                list.add(entity);
            }
            return list;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void initViews() {

        tvTitle = (TextView) findViewById(R.id.questionTitle);
        tvContent = (TextView) findViewById(R.id.questionContent);
        listView = (ListView) findViewById(R.id.listAnswer);
    }
}
