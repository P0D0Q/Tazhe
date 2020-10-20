package com.example.tazhe.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tazhe.R;
import com.example.tazhe.adapter.CommentAdapter;
import com.example.tazhe.adapter.VideoAdapter;
import com.example.tazhe.beans.CommentsInfo;
import com.example.tazhe.beans.VideoInfo;
import com.example.tazhe.beans.VideoInfo2;
import com.example.tazhe.fragments.BaseFragment;
import com.example.tazhe.listener.RetrofitListener;
import com.example.tazhe.model.VideoModel;

import java.util.List;


public class CommentsList extends AppCompatActivity implements RetrofitListener<List<CommentsInfo>> {

    private RecyclerView recyclerView;
    private CommentAdapter adapter;

    private View view = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_info);
        initViews();
        initData();
    }

    void initViews() {
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    void initData() {
        VideoModel videoModel = new VideoModel();
        videoModel.allVideo(this);

    }


    @Override
    public void onSuccess(List<CommentsInfo> commentsInfos, int flag) {

        adapter =  new CommentAdapter(CommentsList.this,commentsInfos);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onFail() {
        Toast.makeText(CommentsList.this, "网络错误", Toast.LENGTH_SHORT).show();
    }
}
