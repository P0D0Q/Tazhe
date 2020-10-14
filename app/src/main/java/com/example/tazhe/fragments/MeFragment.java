package com.example.tazhe.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.tazhe.R;
import com.example.tazhe.activity.UserInfoActivity;
import com.example.tazhe.activity.ui.me.MeViewModel;
import com.example.tazhe.beans.UserInfo;

public class MeFragment extends BaseFragment {

    private ImageView account,message,collected,chart;

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
        message = (ImageView) view.findViewById(R.id.message);
        collected = (ImageView) view.findViewById(R.id.collected);
        chart = (ImageView) view.findViewById(R.id.chart);

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

    }

    @Override
    void initData() {

    }


}