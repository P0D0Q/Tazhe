package com.example.tazhe.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.tazhe.R;
import com.example.tazhe.adapter.CollectAdapter;
import com.example.tazhe.adapter.CommentAdapter;
import com.example.tazhe.adapter.VideoAdapter;
import com.example.tazhe.beans.CollectListByUser;
import com.example.tazhe.listener.RetrofitListener;
import com.example.tazhe.model.UserModel;

import java.util.List;

public class CollectActivity extends AppCompatActivity implements RetrofitListener<List<CollectListByUser>> {

    private RecyclerView recyclerView;
    private CollectAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);
        initViews();
        initData();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.collectlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initData() {
        SharedPreferences sp = getSharedPreferences("UserInfo",
                MODE_PRIVATE);
        String user_id = sp.getString("user_id", "");
        int collectint = Integer.parseInt(user_id);

        UserModel userModel = new UserModel();
        userModel.CollectList(collectint,CollectActivity.this);

    }




    @Override
    public void onSuccess(List<CollectListByUser> collectListByUsers, int flag) {
        adapter = new CollectAdapter(CollectActivity.this, collectListByUsers);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onFail() {
        Toast.makeText(CollectActivity.this, "网络错误", Toast.LENGTH_SHORT).show();

    }
}