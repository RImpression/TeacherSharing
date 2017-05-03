package com.example.teachersharing.ui.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.example.teachersharing.R;
import com.example.teachersharing.ui.entity.UserInfoEntity;
import com.example.teachersharing.ui.http.MyRequest;
import com.example.teachersharing.ui.interfaces.HttpListener;
import com.example.teachersharing.ui.util.Api;
import com.example.teachersharing.ui.util.PreferencesUtils;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 用户信息
 */
public class UserInformation extends BaseActivity {

    private ImageView imgAvatar;
    private TextView tvNice,tvUserName,tvSex,tvBirthday,tvAddress,tvSubject,tvSchool,tvInfo;
    private String id,token;
    private String INFO_URL;
    private UserInfoEntity userInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);
        initToolbar("个人信息",true);
        id = PreferencesUtils.getString(this,"id");
        token = PreferencesUtils.getString(this,"token");
        Log.i("userinfo",id+" token="+token);
        INFO_URL = Api.USERINFO_URL+id+"?token="+token;

        requestUserInfo();
        initViews();
    }

    private void requestUserInfo() {
        MyRequest.getRequest(this, INFO_URL, new HttpListener() {
            @Override
            public void onSuccess(String result) {
                userInfo = parse2Json(result);
                setUserView(userInfo);
            }

            @Override
            public void onError(VolleyError volleyError) {
                ShowToast("网络请求失败...");
            }
        });
    }

    private void setUserView(UserInfoEntity userInfo) {
        Picasso.with(this).load(userInfo.getImageUrl()).fit().centerCrop().into(imgAvatar);
        tvNice.setText(userInfo.getUsername());
        tvUserName.setText(userInfo.getUsername());
        tvSex.setText("男");
        tvBirthday.setText(userInfo.getBirth());
        tvAddress.setText(userInfo.getLocation());
        tvSubject.setText(userInfo.getMajor());
        tvSchool.setText(userInfo.getSchool());
        tvInfo.setText(userInfo.getIntro());

    }

    private UserInfoEntity parse2Json(String result) {
        UserInfoEntity entity = new UserInfoEntity();
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONObject dataObject = jsonObject.getJSONObject("data");
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
