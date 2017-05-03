package com.example.teachersharing.ui.view;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.example.teachersharing.R;
import com.example.teachersharing.ui.adapter.NoteListAdapter;
import com.example.teachersharing.ui.entity.NoteEntity;
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
 * 我的笔记列表
 */

public class MyNoteActivity extends BaseActivity {

    private String id,token;
    private String NOTE_URL;
    private ListView listView;
    private NoteEntity noteEntity;
    private List<NoteEntity> noteList;
    private NoteListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mynote);
        initToolbar("笔记",true);

        id = PreferencesUtils.getString(this,"id");
        token = PreferencesUtils.getString(this,"token");
        NOTE_URL = Api.USER_NOTE_GET+id+"?token="+token;
        requestNoteList(NOTE_URL);
        initViews();
    }

    private void requestNoteList(String note_url) {
        MyRequest.getRequest(this, note_url, new HttpListener() {
            @Override
            public void onSuccess(String result) {
                Log.i("note",result);
                noteList = parse2Json(result);
                setNoteListView(noteList);
            }

            @Override
            public void onError(VolleyError volleyError) {
                ShowToast("网络请求失败...");
            }
        });
    }

    private void setNoteListView(List<NoteEntity> noteList) {
        adapter = new NoteListAdapter(this,noteList);
        listView.setAdapter(adapter);
    }

    private List<NoteEntity> parse2Json(String result) {
        List<NoteEntity> list = null;
        try {
            list = new ArrayList<>();
            JSONObject jsonObject = new JSONObject(result);
            JSONObject dataObject = jsonObject.getJSONObject("data");
            JSONArray notes = dataObject.getJSONArray("notes");
            for (int i=0;i<notes.length();i++) {
                NoteEntity entity = new NoteEntity();
                JSONObject noteObject = notes.getJSONObject(i);
                entity.setId(noteObject.getString("id"));
                entity.setUserId(noteObject.getString("userId"));
                entity.setNoteSortId(noteObject.getString("noteSortId"));
                entity.setTitle(noteObject.getString("title"));
                entity.setContent(noteObject.getString("content"));
                entity.setCreateDate(noteObject.getString("createDate"));
                entity.setClick(noteObject.getString("click"));
                entity.setPublicity(noteObject.getBoolean("publicity"));
                entity.setUp(noteObject.getBoolean("up"));
                list.add(entity);
                Log.i("note",entity.getTitle());
            }
            return list;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    private void initViews() {
        listView = (ListView) findViewById(R.id.listNote);
    }
}
