package com.example.teachersharing.ui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.teachersharing.R;
import com.example.teachersharing.ui.entity.UserInfoEntity;
import com.example.teachersharing.ui.http.MyRequest;
import com.example.teachersharing.ui.http.MyStringRequest;
import com.example.teachersharing.ui.interfaces.HttpListener;
import com.example.teachersharing.ui.util.Api;
import com.example.teachersharing.ui.util.PreferencesUtils;

import org.json.JSONException;
import org.json.JSONObject;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity implements OnClickListener {


    // UI references.
    private EditText edtAccount,edtPassword;
    private Button btnSignIn;
    private ProgressBar mProgressView;
    private String[] paramKey,paramValue;
    private UserInfoEntity userInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initToolbar("登录",true);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.action_register) {
                    Intent intent = new Intent();
                    intent.setClass(LoginActivity.this,RegisteredActivity.class);
                    startActivity(intent);
                }
                return true;
            }
        });


        initViews();

    }

    private void initViews() {
        edtAccount = (EditText) findViewById(R.id.account);
        edtPassword = (EditText) findViewById(R.id.password);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        mProgressView = (ProgressBar) findViewById(R.id.login_progress);
        btnSignIn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSignIn) {
            signIn();
        }
    }

    private void signIn() {
        final String account = edtAccount.getText().toString();
        final String password = edtPassword.getText().toString();
        paramKey = new String[]{"username","password"};
        paramValue = new String[]{account,password};
//        MyRequest.postRequest(this, Api.LOGIN_URL, paramKey, paramValue, new HttpListener() {
//            @Override
//            public void onSuccess(String result) {
//                Log.i("success",result);
//            }
//
//            @Override
//            public void onError(VolleyError volleyError) {
//                Log.i("error",volleyError.toString());
//            }
//        });

        RequestQueue queue = new Volley().newRequestQueue(this);
        MyStringRequest request = new MyStringRequest(Request.Method.POST, Api.LOGIN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                ShowToast("登录成功");
                userInfo = parse2Json(response);
                PreferencesUtils.putString(LoginActivity.this,"id",userInfo.getId());
                PreferencesUtils.putString(LoginActivity.this,"username",userInfo.getUsername());
                PreferencesUtils.putString(LoginActivity.this,"token",userInfo.getToken());
                PreferencesUtils.putString(LoginActivity.this,"imageUrl",userInfo.getImageUrl());
                finish();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                ShowToast(error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();
                map.put("password",password);
                return map;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> param = new HashMap<>();
                param.put("Accept","application/json;charset=UTF-8");
                param.put("username",account);
                return param;
            }
        };
        queue.add(request);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_register, menu);
        return true;
    }

    private UserInfoEntity parse2Json(String response) {
        UserInfoEntity entity = new UserInfoEntity();
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONObject dataObject = jsonObject.getJSONObject("data");
            entity.setToken(dataObject.getString("token"));
            JSONObject userObject = dataObject.getJSONObject("user");
            entity.setId(userObject.getString("id"));
            entity.setUsername(userObject.getString("username"));
            entity.setPhone(userObject.getString("phone"));
            entity.setBirth(userObject.getString("birth"));
            entity.setLocation(userObject.getString("location"));
            entity.setSchool(userObject.getString("school"));
            entity.setMajor(userObject.getString("major"));
            entity.setIntro(userObject.getString("intro"));
            entity.setImageUrl(userObject.getString("imageUrl"));
            entity.setGender(userObject.getBoolean("gender"));
            entity.setLocked(userObject.getBoolean("locked"));
            return entity;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}

