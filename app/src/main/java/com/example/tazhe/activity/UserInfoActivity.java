package com.example.tazhe.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tazhe.R;
import com.example.tazhe.beans.UserInfo;
import com.example.tazhe.listener.RetrofitListener;
import com.example.tazhe.model.UserModel;
import com.example.tazhe.utils.MD5;

public class UserInfoActivity extends AppCompatActivity implements RetrofitListener<UserInfo> {

    private EditText newpass,oldpass,new2pass,newusername,newphonenum,newidcard;
    private String Newpassword,Oldpassword,New2password,Newusername,Newphonenum,Newidcard,User_id;
    private Button btnnew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        initViews();
        initEvents();
    }

    private void initViews() {
        newpass=findViewById(R.id.newpass);
        oldpass=findViewById(R.id.oldpass);
        new2pass=findViewById(R.id.new2pass);
        newusername=findViewById(R.id.newusername);
        newphonenum=findViewById(R.id.newphonenum);
        newidcard=findViewById(R.id.newidcard);
        btnnew=findViewById(R.id.btnnew);
    }

    private void getEditString(){
        Newpassword=newpass.getText().toString().trim();
        Oldpassword=oldpass.getText().toString().trim();
        New2password=new2pass.getText().toString().trim();
        Newusername=newusername.getText().toString().trim();
        Newphonenum=newphonenum.getText().toString().trim();
        Newidcard=newidcard.getText().toString().trim();

    }

    private void initEvents() {
        btnnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEditString();
                if(TextUtils.isEmpty(Oldpassword)){
                    Toast.makeText(UserInfoActivity.this, "请输入旧密码", Toast.LENGTH_SHORT).show();
                    return;
                }else if(TextUtils.isEmpty(Newpassword)){
                    Toast.makeText(UserInfoActivity.this, "请输入新密码", Toast.LENGTH_SHORT).show();
                    return;
                }else if(TextUtils.isEmpty(New2password)){
                    Toast.makeText(UserInfoActivity.this, "请再次输入新密码", Toast.LENGTH_SHORT).show();
                    return;
                }else if(!Newpassword.equals(New2password)) {
                    Toast.makeText(UserInfoActivity.this, "输入两次的密码不一样", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    String md5password = MD5.md5(Newpassword);
                    SharedPreferences sp= getSharedPreferences("UserInfo",
                            MODE_PRIVATE);
                    String User_id =sp.getString("user_id", "");
                    UserModel userModel = new UserModel();
                    userModel.UpDatebyid(User_id,
                            md5password,
                            Newusername,
                            Newphonenum,
                            Newidcard,
                            UserInfoActivity.this);

                }

                /*if (regpass.getText().toString().equals(reg2pass.getText().toString())) {
                    UserModel userModel = new UserModel();
                    userModel.register(regname.getText().toString().trim(), regpass.getText().toString().trim(), RegActivity.this);
                } else {
                    Toast.makeText(RegActivity.this, "两次密码输入不一样", Toast.LENGTH_SHORT).show();
                }*/
            }
        });
    }


    @Override
    public void onSuccess(UserInfo user, int flag) {
        if (user!=null&&user.getStatus()==0) {
            Intent intent = new Intent(UserInfoActivity.this, NavigationActivity.class);
            startActivity(intent);
            Toast.makeText(UserInfoActivity.this, "更新成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(UserInfoActivity.this, "更新失败", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onFail() {
        Toast.makeText(UserInfoActivity.this, "网络错误", Toast.LENGTH_SHORT).show();

    }
}