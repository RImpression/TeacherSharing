package com.example.teachersharing.ui.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.example.teachersharing.R;
import com.example.teachersharing.ui.adapter.ResourceListAdapter;
import com.example.teachersharing.ui.entity.SourceEntity;
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
 * 我的资源
 */
public class MyResourcesActivity extends BaseActivity {
    private ListView listView;
    private String SOURCE_URL;
    private String id,token;
    private List<SourceEntity> sourceList;
    private ResourceListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_resources);
        initToolbar("我的资源",true);
        id = PreferencesUtils.getString(this,"id");
        token = PreferencesUtils.getString(this,"token");
        SOURCE_URL = Api.SOURCE_GET+id+"?token="+token;

        requestSoruceList(SOURCE_URL);
        listView = (ListView) findViewById(R.id.listSource);
    }

    private void requestSoruceList(final String source_url) {
        MyRequest.getRequest(this, source_url, new HttpListener() {
            @Override
            public void onSuccess(String result) {
                Log.i("result",result);
                sourceList = parse2Json(result);
                setListView();
            }

            @Override
            public void onError(VolleyError volleyError) {
                ShowToast("网络请求失败...");
            }
        });
    }

    private void setListView() {
        adapter = new ResourceListAdapter(this,sourceList);
        listView.setAdapter(adapter);
    }

    private List<SourceEntity> parse2Json(String result) {
        List<SourceEntity> list;
        try {
            list = new ArrayList<>();
            JSONObject jsonObject = new JSONObject(result);
            JSONObject dataObject = jsonObject.getJSONObject("data");
            JSONArray resources = dataObject.getJSONArray("resources");
            for (int i=0;i<resources.length();i++) {
                SourceEntity entity = new SourceEntity();
                JSONObject sourcesObject = resources.getJSONObject(i);
                entity.setId(sourcesObject.getString("id"));
                entity.setUserId(sourcesObject.getString("userId"));
                entity.setName(sourcesObject.getString("name"));
                entity.setDescription(sourcesObject.getString("description"));
                entity.setType(sourcesObject.getString("type"));
                entity.setUserId(sourcesObject.getString("url"));
                entity.setCreateDate(sourcesObject.getString("createDate"));
                entity.setParise(sourcesObject.getString("praise"));
                entity.setPublicity(sourcesObject.getBoolean("publicity"));
                list.add(entity);
                Log.i("result",entity.getName());
            }
            return list;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
