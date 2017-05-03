package com.example.teachersharing.ui.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.teachersharing.R;
import com.example.teachersharing.ui.http.MyStringRequest;
import com.example.teachersharing.ui.util.Api;
import com.example.teachersharing.ui.util.PreferencesUtils;

import java.util.HashMap;
import java.util.Map;

public class RegisteredActivity extends BaseActivity implements View.OnClickListener {
    private Button btnRegistered;
    private EditText edtAccount,edtPassword,edtSurePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);
        initToolbar("注册",true);

        initViews();
    }

    private void initViews() {
        edtAccount = (EditText) findViewById(R.id.newAccount);
        edtPassword = (EditText) findViewById(R.id.newPassword);
        edtSurePassword = (EditText) findViewById(R.id.surePassword);
        btnRegistered = (Button) findViewById(R.id.btnRegistered);
        btnRegistered.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnRegistered) {
            accountRegistered();
        }
    }

    private void accountRegistered() {
        String account = edtAccount.getText().toString();
        String password = edtPassword.getText().toString();
        String surePassword = edtSurePassword.getText().toString();
        if (password.equals(surePassword)) {
            requestMethod(account,password);
        }
    }

    private void requestMethod(final String account, final String password) {
        RequestQueue queue = new Volley().newRequestQueue(this);
        MyStringRequest request = new MyStringRequest(Request.Method.POST, Api.LOGIN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("success","success");
                ShowToast("注册成功");
                finish();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("success",error.toString());
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

}
