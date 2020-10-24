package com.example.tazhe.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tazhe.R;
import com.example.tazhe.beans.UserDetails;
import com.example.tazhe.constants.Constants;
import com.example.tazhe.listener.RetrofitListener;
import com.example.tazhe.model.UserModel;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class UserActivity extends AppCompatActivity implements RetrofitListener {

    private ImageView avator;
    private TextView username,usersex,userbirthday,userplace;
    private Button follow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        initViews();
        initEvents();
        initData();
    }

    private void initViews() {
        avator=findViewById(R.id.useravator2);
        username=findViewById(R.id.username2);
        usersex=findViewById(R.id.usersex2);
        userbirthday=findViewById(R.id.userbirthday2);
        userplace=findViewById(R.id.userplace2);
        follow=findViewById(R.id.follow);
    }

    private void initEvents() {
        follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void initData() {

        Intent intent = getIntent();
        int userdetails = intent.getIntExtra("userid", 0);

        UserModel userModel = new UserModel();
        userModel.UserDetails(userdetails,UserActivity.this);
    }

    @Override
    public void onSuccess(Object o, int flag) {
        switch (flag){
            case Constants.USERDETAILS:
                UserDetails details = (UserDetails) o;
                if (details != null && details.getUser_id() != 0) {
                    username.setText("用户名：" + details.getUsername());
                    usersex.setText("性别：" + details.getSex());
                    userbirthday.setText("生日：" + details.getBirthday());
                    userplace.setText("所在地：" + details.getBornplace());

                    Picasso.with(UserActivity.this).load(Constants.BASE_URL+details.getUser_picture()).into(avator);
                }
                else{
                    Toast.makeText(UserActivity.this, "网络错误2", Toast.LENGTH_SHORT).show();
                }
                break;

        }

    }

    @Override
    public void onFail() {

    }
}