package com.example.tazhe.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tazhe.R;
import com.example.tazhe.activity.LoginActivity;
import com.example.tazhe.activity.RegActivity;
import com.example.tazhe.activity.UserInfoActivity;
import com.example.tazhe.activity.type.ArtTypeActivity;
import com.example.tazhe.activity.type.FictionTypeActivity;
import com.example.tazhe.activity.type.FoodTypeActivity;
import com.example.tazhe.activity.type.NatureTypeActivity;
import com.example.tazhe.activity.type.TechTypeActivity;
import com.example.tazhe.activity.ui.dashboard.DashboardViewModel;

public class DashboardFragment extends BaseFragment {

    private ImageView foodtype,techtype,fictiontype,arttype,naturetype;
    private RecyclerView recyclerView;

    private Context context;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        setLayout_file(R.layout.fragment_dashboard);
        context = getActivity();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    void initViews() {
        foodtype = view.findViewById(R.id.foodtype);
        techtype = view.findViewById(R.id.techtype);
        fictiontype = view.findViewById(R.id.fictiontype);
        arttype = view.findViewById(R.id.arttype);
        naturetype = view.findViewById(R.id.naturetype);

        recyclerView = view.findViewById(R.id.videorecommendlist);
    }

    @Override
    void initEvents () {
        foodtype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FoodTypeActivity.class);
                context.startActivity(intent);
            }
        });

        techtype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TechTypeActivity.class);
                context.startActivity(intent);
            }
        });

        fictiontype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FictionTypeActivity.class);
                context.startActivity(intent);
            }
        });

        arttype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ArtTypeActivity.class);
                context.startActivity(intent);
            }
        });

        naturetype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NatureTypeActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    void initData() {

    }




}