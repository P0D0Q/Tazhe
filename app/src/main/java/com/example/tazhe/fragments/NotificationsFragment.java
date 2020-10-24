package com.example.tazhe.fragments;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tazhe.R;
import com.example.tazhe.activity.NavigationActivity;
import com.example.tazhe.activity.VideoInfoActivity;
import com.example.tazhe.activity.ui.notifications.NotificationsViewModel;
import com.example.tazhe.adapter.CommentAdapter;
import com.example.tazhe.adapter.SearchUserAdapter;
import com.example.tazhe.adapter.SearchVideoAdapter;
import com.example.tazhe.beans.CommentsInfo;
import com.example.tazhe.beans.SearchUser;
import com.example.tazhe.beans.SearchVideo;
import com.example.tazhe.beans.VideoInfo;
import com.example.tazhe.constants.Constants;
import com.example.tazhe.listener.RetrofitListener;
import com.example.tazhe.model.UserModel;
import com.example.tazhe.model.VideoModel;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends BaseFragment implements RetrofitListener {

    //private NotificationsViewModel notificationsViewModel;
    private EditText mEditText;//搜索栏
    private RecyclerView searchview;
    private Button search;//显示模糊查找返回的数据
    private Context mContext;

    private SearchVideoAdapter searchVideoAdapter;
    private SearchUserAdapter searchUserAdapter;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        setLayout_file(R.layout.fragment_notifications);
        mContext = getActivity();
        return super.onCreateView(inflater, container, savedInstanceState);


    }

    @Override
    void initViews() {
        mEditText =  view.findViewById(R.id.et_search);
        search = view.findViewById(R.id.btsearch);

        searchview = view.findViewById(R.id.searchview);
        searchview.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

    @Override
    void initEvents() {
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getVideo();
                getUser();
            }
        });
    }

    public void getVideo(){
        VideoModel videoModel = new VideoModel();
        videoModel.FindVideo(mEditText.getText().toString().trim(),this);

    }

    public void getUser(){
        UserModel userModel = new UserModel();
        userModel.FindUser(mEditText.getText().toString().trim(),this);

    }

    @Override
    void initData() {
        /*VideoModel videoModel = new VideoModel();
        videoModel.allVideo(this);*/

    }


    @Override
    public void onSuccess(Object o, int flag) {
        switch (flag) {
            case Constants.SEARCHVIDEO:
                List<SearchVideo> searchVideoList = (List<SearchVideo>) o;
                searchVideoAdapter = new SearchVideoAdapter(mContext, searchVideoList);
                searchview.setAdapter(searchVideoAdapter);
                Toast.makeText(mContext, "你发出去了", Toast.LENGTH_SHORT).show();
                break;

            case Constants.SEARCHUSER:
                List<SearchUser> searchUserList = (List<SearchUser>) o;
                searchUserAdapter = new SearchUserAdapter(mContext, searchUserList);
                searchview.setAdapter(searchUserAdapter);
                Toast.makeText(mContext, "你发出去了", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    @Override
    public void onFail() {
        Toast.makeText(mContext, "网络错误", Toast.LENGTH_SHORT).show();

    }
}