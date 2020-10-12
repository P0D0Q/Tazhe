package com.example.tazhe.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tazhe.R;


public abstract class BaseActivity extends AppCompatActivity {
    protected int layout_file= R.layout.activity_main;
    abstract void initViews();
    abstract void initEvents();
    abstract void initData();
    void setLayout(int layout_file)
    {
        setContentView(layout_file);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout(layout_file);
        initViews();
        initData();
        initEvents();



    }
    public String getUser_id()
    {
        SharedPreferences sp;
        sp =getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        return sp.getString("user_id", "");
    }
    public String getUser_password()
    {
        SharedPreferences sp;
        sp =getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        return sp.getString("password", "");
    }
    public void showToast(String content)
    {
        Toast.makeText(this,content, Toast.LENGTH_LONG).show();
    }
}
