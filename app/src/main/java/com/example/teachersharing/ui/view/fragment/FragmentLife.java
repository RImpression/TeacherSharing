package com.example.teachersharing.ui.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.teachersharing.R;
import com.example.teachersharing.ui.entity.NewsEntity;
import com.example.teachersharing.ui.http.MyRequest;
import com.example.teachersharing.ui.interfaces.HttpListener;
import com.example.teachersharing.ui.util.Api;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class FragmentLife extends Fragment {
    private View view;
    private List<NewsEntity> newsList;
    private NewsEntity newsEntity;


    public static FragmentLife newInstance(String param1) {
        FragmentLife fragment = new FragmentLife();
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
            view = inflater.inflate(R.layout.fragment_life,container,false);
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        requestNews();
        initViews();
    }

    private void requestNews() {
        MyRequest.getRequest(getActivity().getApplicationContext(), Api.NEWS_URL, new HttpListener() {
            @Override
            public void onSuccess(String result) {
                newsList = parse2Json(result);
            }

            @Override
            public void onError(VolleyError volleyError) {
                Toast.makeText(getActivity().getApplicationContext(),"数据请求失败...",Toast.LENGTH_LONG).show();
            }
        });
    }

    private List<NewsEntity> parse2Json(String result) {
        try {
            List<NewsEntity> entityList = new ArrayList<>();
            NewsEntity entity = new NewsEntity();
            JSONObject object = new JSONObject(result.substring(result.indexOf("{"), result.lastIndexOf("}") + 1));
            JSONArray entityArray = object.getJSONArray("szbList");
            for (int i=0;i<entityArray.length();i++) {
                JSONObject news = entityArray.getJSONObject(i);
                entity.setTitle(news.getString("title"));
                entity.setContnet(news.getString("content"));
                entity.setDocpuburl(news.getString("docpuburl"));
                entity.setAuthor(news.getString("author"));
                entity.setSource(news.getString("source"));
                entity.setWcmnid(news.getInt("wcmnid"));
                entity.setWcmcid(news.getInt("wcmcid"));
                entityList.add(entity);
            }
            return entityList;

        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private void initViews() {


    }
}
