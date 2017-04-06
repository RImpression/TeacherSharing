package com.example.teachersharing.ui.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.teachersharing.R;

/**
 * 用户信息
 */
public class UserInformation extends BaseActivity {

    private ImageView imgAvatar;
    private TextView tvNice,tvUserName,tvSex,tvBirthday,tvAddress,tvSubject,tvSchool,tvInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);
        initToolbar("个人信息",true);

        initViews();
    }

    private void initViews() {
        imgAvatar = (ImageView) findViewById(R.id.info_avatar);
        tvNice = (TextView) findViewById(R.id.info_nick);
        tvUserName = (TextView) findViewById(R.id.info_username);
        tvSex = (TextView) findViewById(R.id.info_sex);
        tvBirthday = (TextView) findViewById(R.id.info_birthday);
        tvAddress = (TextView) findViewById(R.id.info_address);
        tvSubject = (TextView) findViewById(R.id.info_subject);
        tvSchool = (TextView) findViewById(R.id.info_school);
        tvInfo = (TextView) findViewById(R.id.info_style);
    }
}
