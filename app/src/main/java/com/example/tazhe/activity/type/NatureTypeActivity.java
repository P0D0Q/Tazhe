package com.example.tazhe.activity.type;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.tazhe.R;
import com.example.tazhe.adapter.VideoTypeAdapter;
import com.example.tazhe.beans.VideoType;
import com.example.tazhe.listener.RetrofitListener;
import com.example.tazhe.model.VideoModel;

import java.util.List;

public class NatureTypeActivity extends AppCompatActivity implements RetrofitListener<List<VideoType>> {

    private RecyclerView recyclerView;
    private VideoTypeAdapter videoTypeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nature_type);

        initViews();
        initData();
    }
    private void initViews() {
        recyclerView = findViewById(R.id.naturetypeview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initData() {
        VideoModel videoModel=new VideoModel();
        videoModel.VideoType(5,this);
    }


    @Override
    public void onSuccess(List<VideoType> type, int flag) {
        videoTypeAdapter = new VideoTypeAdapter(NatureTypeActivity.this, type);
        recyclerView.setAdapter(videoTypeAdapter);

    }

    @Override
    public void onFail() {
        Toast.makeText(NatureTypeActivity.this, "网络错误", Toast.LENGTH_SHORT).show();

    }
}