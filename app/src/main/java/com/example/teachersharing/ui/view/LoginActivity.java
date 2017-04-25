package com.example.teachersharing.ui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
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
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
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
import java.util.List;

import com.android.volley.VolleyError;
import com.example.teachersharing.R;
import com.example.teachersharing.ui.http.MyRequest;
import com.example.teachersharing.ui.interfaces.HttpListener;
import com.example.teachersharing.ui.util.Api;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initToolbar("登录",true);

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
        String account = edtAccount.getText().toString();
        String password = edtPassword.getText().toString();
        paramKey = new String[]{"username","password"};
        paramValue = new String[]{account,password};
        MyRequest.postRequest(this, Api.LOGIN_URL, paramKey, paramValue, new HttpListener() {
            @Override
            public void onSuccess(String result) {
                Log.i("success",result);
            }

            @Override
            public void onError(VolleyError volleyError) {
                Log.i("error",volleyError.toString());
            }
        });

    }
}

