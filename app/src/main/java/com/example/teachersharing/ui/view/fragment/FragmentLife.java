package com.example.teachersharing.ui.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.teachersharing.R;
import com.example.teachersharing.ui.adapter.NewsAdapter;
import com.example.teachersharing.ui.entity.NewsEntity;
import com.example.teachersharing.ui.http.MyRequest;
import com.example.teachersharing.ui.interfaces.HttpListener;
import com.example.teachersharing.ui.util.Api;
import com.example.teachersharing.ui.view.NewsWebViewActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class FragmentLife extends Fragment {
    private View view;
    private List<NewsEntity> newsList = new ArrayList<>();
    private NewsEntity newsEntity;
    private NewsAdapter adapter = null;
    private ListView listView;


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
                setListView(newsList);
            }

            @Override
            public void onError(VolleyError volleyError) {
                Toast.makeText(getActivity().getApplicationContext(),"数据请求失败...",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setListView(List<NewsEntity> data) {
        adapter = new NewsAdapter(getActivity().getApplicationContext(),data);
        listView.setAdapter(adapter);
    }

    private List<NewsEntity> parse2Json(String result) {
        List<NewsEntity> entityList = null;
        try {
            entityList = new ArrayList<>();
            JSONObject object = new JSONObject(result.substring(result.indexOf("{"), result.lastIndexOf("}") + 1));
            JSONArray entityArray = object.getJSONArray("szbList");
            for (int i=0;i<entityArray.length();i++) {
                NewsEntity entity = new NewsEntity();
                JSONObject news = entityArray.getJSONObject(i);
                entity.setTitle(news.getString("title"));
                entity.setContnet(news.getString("content"));
                entity.setDocpuburl(news.getString("docpuburl"));
                entity.setSource(news.getString("source"));
                entity.setPubtime(news.getString("pubtime"));
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
        listView = (ListView) getView().findViewById(R.id.newsList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.putExtra("content",newsList.get(position).getContnet());
                intent.putExtra("title",newsList.get(position).getTitle());
                intent.putExtra("weburl",newsList.get(position).getDocpuburl());
                intent.setClass(getActivity().getApplicationContext(), NewsWebViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
