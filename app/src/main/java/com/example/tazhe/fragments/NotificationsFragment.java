package com.example.tazhe.fragments;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.tazhe.R;
import com.example.tazhe.activity.ui.notifications.NotificationsViewModel;
import com.example.tazhe.adapter.SearchAdapter;
import com.example.tazhe.beans.VideoInfo;
import com.example.tazhe.listener.RetrofitListener;
import com.example.tazhe.model.VideoModel;

import java.util.List;

public class NotificationsFragment extends BaseFragment implements RetrofitListener<List<VideoInfo>> {

    //private NotificationsViewModel notificationsViewModel;
    private EditText mEditText;//搜索栏
    private ListView mListView;//显示模糊查找返回的数据
    private Context mContext;
    private SearchAdapter mSearchAdapter;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        setLayout_file(R.layout.fragment_notifications);
        mContext = getActivity();
        return super.onCreateView(inflater, container, savedInstanceState);


    }

    @Override
    void initViews() {
        mEditText =  view.findViewById(R.id.et_search);
        mListView =  view.findViewById(R.id.lv);

    }

    @Override
    void initEvents() {
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    @Override
    void initData() {
        VideoModel videoModel = new VideoModel();
        videoModel.allVideo(this);

    }


    @Override
    public void onSuccess(List<VideoInfo> videoInfos, int flag) {

    }

    @Override
    public void onFail() {

    }
}