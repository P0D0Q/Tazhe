package com.example.tazhe.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tazhe.R;
import com.example.tazhe.activity.ui.home.HomeViewModel;
import com.example.tazhe.adapter.VideoAdapter;
import com.example.tazhe.beans.VideoInfo;
import com.example.tazhe.listener.RetrofitListener;
import com.example.tazhe.model.VideoModel;

import java.util.List;

public class HomeFragment extends BaseFragment implements RetrofitListener<VideoInfo> {

    private RecyclerView recyclerView;
    private VideoAdapter adapter;



    private View view = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        initViews();
        initData();
        return view;
    }

    void initViews() {
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    @Override
    void initEvents() {

    }

    void initData() {
        VideoModel videoModel = new VideoModel();
        videoModel.allVideo(this);

    }

    @Override
    public void onSuccess(VideoInfo video, int flag) {
        adapter =  new VideoAdapter(context,video.getData());
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onFail() {
        showToast("网络错误");
    }
}