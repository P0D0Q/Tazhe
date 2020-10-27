package com.example.tazhe.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.tazhe.R;
import com.example.tazhe.activity.CollectActivity;
import com.example.tazhe.activity.FollowActivity;
import com.example.tazhe.activity.UploadActivity;
import com.example.tazhe.activity.UserInfoActivity;
import com.example.tazhe.activity.ui.me.MeViewModel;
import com.example.tazhe.beans.UserInfo;
import com.example.tazhe.constants.Constants;
import com.squareup.picasso.Picasso;

public class MeFragment extends BaseFragment {

    private ImageView account,follow,collected,upload1;
    private ImageView avator;
    private Button account1,collected1,follow1,uploadvideo1;
    private TextView username,place,sex;

    private Context context;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        setLayout_file(R.layout.fragment_me);
        context = getActivity();
        return super.onCreateView(inflater, container, savedInstanceState);


    }

    @Override
    void initViews() {
        account = (ImageView) view.findViewById(R.id.account);
        follow = (ImageView) view.findViewById(R.id.follow);
        collected = (ImageView) view.findViewById(R.id.collected);
        upload1 = (ImageView) view.findViewById(R.id.upload1);

        account1 = (Button) view.findViewById(R.id.account1);
        collected1 = (Button) view.findViewById(R.id.collected1);
        follow1 = (Button) view.findViewById(R.id.follow1);
        uploadvideo1 = (Button) view.findViewById(R.id.uploadvideo1);

        username = (TextView) view.findViewById(R.id.username);
        place = (TextView) view.findViewById(R.id.place);
        sex = (TextView) view.findViewById(R.id.sex);
        avator = (ImageView) view.findViewById(R.id.useravator);

    }

    @Override
    void initEvents() {
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UserInfoActivity.class);
                context.startActivity(intent);
            }
        });

        collected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CollectActivity.class);
                context.startActivity(intent);
            }
        });

        account1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UserInfoActivity.class);
                context.startActivity(intent);
            }
        });

        collected1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CollectActivity.class);
                context.startActivity(intent);
            }
        });

        follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FollowActivity.class);
                context.startActivity(intent);
            }
        });

        follow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FollowActivity.class);
                context.startActivity(intent);
            }
        });

        upload1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UploadActivity.class);
                context.startActivity(intent);
            }
        });

        uploadvideo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), UploadActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    void initData() {
        username.setText(getUsername());
        place.setText(getPlace());
        sex.setText(getSex());
        Picasso.with(context).load(Constants.BASE_URL+getUseravator()).into(avator);

    }


}