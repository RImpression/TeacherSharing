package com.example.teachersharing.ui.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.teachersharing.R;

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
    }
}
