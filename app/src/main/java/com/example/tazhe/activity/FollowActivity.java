package com.example.tazhe.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.tazhe.R;
import com.example.tazhe.adapter.CollectAdapter;
import com.example.tazhe.adapter.FollowAdapter;
import com.example.tazhe.beans.FollowListByUser;
import com.example.tazhe.listener.RetrofitListener;
import com.example.tazhe.model.UserModel;

import java.util.List;

public class FollowActivity extends AppCompatActivity implements RetrofitListener<List<FollowListByUser>> {

    private RecyclerView recyclerView;
    private FollowAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow);
        initViews();
        initData();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.followlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initData() {
        SharedPreferences sp = getSharedPreferences("UserInfo",
                MODE_PRIVATE);
        String user_id = sp.getString("user_id", "");
        int followint = Integer.parseInt(user_id);

        UserModel userModel = new UserModel();
        userModel.FollowList(followint,FollowActivity.this);
    }

    @Override
    public void onSuccess(List<FollowListByUser> followListByUsers, int flag) {
        adapter = new FollowAdapter(FollowActivity.this, followListByUsers);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onFail() {
        Toast.makeText(FollowActivity.this, "网络错误", Toast.LENGTH_SHORT).show();

    }
}