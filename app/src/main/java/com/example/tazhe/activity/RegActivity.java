package com.example.tazhe.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.text.TextUtils;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tazhe.R;
import com.example.tazhe.beans.UserInfo;
import com.example.tazhe.listener.RetrofitListener;
import com.example.tazhe.model.UserModel;
import com.example.tazhe.utils.MD5;

public class RegActivity extends AppCompatActivity implements RetrofitListener<UserInfo> {
    private EditText regname,regpass,reg2pass;
    private String Rgusername,Rgpassword,Rgpassword2;
    private Button btnreg2;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        initViews();
        initEvents();
    }

    private void initViews() {
        regname=findViewById(R.id.regname);
        regpass=findViewById(R.id.regpass);
        reg2pass=findViewById(R.id.reg2pass);
        btnreg2=findViewById(R.id.btnreg2);
    }

    private void getEditString(){
        Rgusername=regname.getText().toString().trim();
        Rgpassword=regpass.getText().toString().trim();
        Rgpassword2=reg2pass.getText().toString().trim();
    }


    private void initEvents() {
        btnreg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEditString();
                if(TextUtils.isEmpty(Rgusername)){
                    Toast.makeText(RegActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
                    return;
                }else if(TextUtils.isEmpty(Rgpassword)){
                    Toast.makeText(RegActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                }else if(TextUtils.isEmpty(Rgpassword2)){
                    Toast.makeText(RegActivity.this, "请再次输入密码", Toast.LENGTH_SHORT).show();
                    return;
                }else if(!Rgpassword.equals(Rgpassword2)) {
                    Toast.makeText(RegActivity.this, "输入两次的密码不一样", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    String md5Rgpassword = MD5.md5(Rgpassword);
                    UserModel userModel = new UserModel();
                    userModel.register(Rgusername, md5Rgpassword, RegActivity.this);

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
    public void onSuccess(UserInfo user,int flag) {
        if (user!=null&&user.getStatus()==0) {
            intent = new Intent();
            intent.putExtra("username", regname.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
            Toast.makeText(RegActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(RegActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onFail() {
        Toast.makeText(RegActivity.this, "网络错误", Toast.LENGTH_SHORT).show();
    }
}
