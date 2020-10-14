package com.example.tazhe.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.tazhe.R;

import static android.widget.Toast.LENGTH_SHORT;


public abstract class BaseFragment extends Fragment {
    protected int layout_file=0;
    private SharedPreferences sp;
    protected FragmentManager childManager;
    private FragmentTransaction transaction;
    protected Context context;
    private Toast toast;
    protected View view = null;

    abstract void initViews();

    abstract void initEvents();

    abstract void initData();


    void setLayout_file(int layout_file)
    {
        this.layout_file=layout_file;
    }
    int getLayout_file()
    {
        return this.layout_file;
    }
    public BaseFragment() {
        context = getActivity();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        view = inflater.inflate(getLayout_file(), container, false);
        initViews();
        initEvents();
        initData();
        return view;
    }
    public String getUser_id()
    {
        SharedPreferences sp;
        sp =getActivity().getSharedPreferences("UserInfo", Context.MODE_PRIVATE);
        return sp.getString("user_id", "");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        childManager = getChildFragmentManager();
        this.context = getActivity();

        //this.toast = Toast.makeText();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }
    public void showToast(String Info)
    {
        Toast.makeText(context,Info, LENGTH_SHORT).show();
    }


}
