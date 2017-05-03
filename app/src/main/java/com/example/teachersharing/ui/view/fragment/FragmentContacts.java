package com.example.teachersharing.ui.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.teachersharing.R;
import com.example.teachersharing.ui.adapter.QuestionListAdapter;
import com.example.teachersharing.ui.entity.QuestionEntity;
import com.example.teachersharing.ui.http.MyRequest;
import com.example.teachersharing.ui.interfaces.HttpListener;
import com.example.teachersharing.ui.util.Api;
import com.example.teachersharing.ui.util.PreferencesUtils;
import com.example.teachersharing.ui.view.LoginActivity;
import com.example.teachersharing.ui.view.QuestionDetailActivity;
import com.example.teachersharing.ui.view.RegisteredActivity;
import com.example.teachersharing.ui.view.SearchSourcesActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RImpression on 2016/9/24 0024.
 */
public class FragmentContacts extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {
    private View view;
    private String token;
    private String QUESTION_URL;
    private ListView listView;
    private QuestionListAdapter adapter;
    private List<QuestionEntity> questionList;



    public static FragmentContacts newInstance(String param1) {
        FragmentContacts fragment = new FragmentContacts();
        Bundle args = new Bundle();
        args.putString("args1",param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_contacts,container,false);
        }
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        token = PreferencesUtils.getString(getActivity().getApplicationContext(),"token");
        QUESTION_URL = Api.QUESTION_GET+token;
        requestQuestionList(QUESTION_URL);
        initView();
    }

    private void requestQuestionList(String question_url) {
        MyRequest.getRequest(getActivity().getApplicationContext(), question_url, new HttpListener() {
            @Override
            public void onSuccess(String result) {
                Log.i("question",result);
                questionList = parse2Json(result);
                setListView();

            }

            @Override
            public void onError(VolleyError volleyError) {
                Toast.makeText(getActivity().getApplicationContext(),"网络请求失败...",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setListView() {
        adapter = new QuestionListAdapter(getActivity().getApplicationContext(),questionList);
        listView.setAdapter(adapter);
    }

    private List<QuestionEntity> parse2Json(String result) {
        List<QuestionEntity> list;
        try {
            list = new ArrayList<>();
            JSONObject jsonObject = new JSONObject(result);
            JSONObject dataObject = jsonObject.getJSONObject("data");
            JSONArray questions = dataObject.getJSONArray("notes");
            for (int i=0;i<questions.length();i++) {
                QuestionEntity entity = new QuestionEntity();
                JSONObject questionObject = questions.getJSONObject(i);
                entity.setId(questionObject.getString("id"));
                entity.setUserId(questionObject.getString("userId"));
                entity.setTitle(questionObject.getString("title"));
                entity.setContent(questionObject.getString("content"));
                entity.setLabel(questionObject.getString("label"));
                entity.setCreateDate(questionObject.getString("createDate"));
                entity.setPraise(questionObject.getString("praise"));
                list.add(entity);
            }
            return list;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void initView() {
        listView = (ListView) getView().findViewById(R.id.listQuestion);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        QuestionEntity entity = questionList.get(position);
        String title = entity.getTitle();
        String content = entity.getContent();
        String userId = entity.getUserId();
        Intent intent = new Intent();
        intent.putExtra("title",title);
        intent.putExtra("content",content);
        intent.putExtra("userId",userId);
        intent.setClass(getActivity(), QuestionDetailActivity.class);
        startActivity(intent);
    }
}
