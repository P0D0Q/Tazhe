package com.example.tazhe.adapter;

import android.content.Context;
import android.widget.BaseAdapter;

import java.util.List;

public abstract class TestAdapter<T> extends BaseAdapter {

    protected List<T> mData;
    protected Context mContext;

    public TestAdapter(Context context, List<T> data) {
        this.mContext = context;
        this.mData = data;
    }

    public void refreshData(List<T> data) {
        if (mData != null) {
            mData.clear();
            mData.addAll(data);
        }
        this.notifyDataSetChanged();
    }
    public void refreshDataNull(List<T> data) {
        if (mData != null) {
            mData.clear();
            mData.addAll(data);
        }else {
            mData.clear();
            mData.addAll(data);
        }
        this.notifyDataSetChanged();
    }
    public void addData(List<T> data) {
        if (mData != null) {
            mData.addAll(data);
        }
        this.notifyDataSetChanged();
    }

    public void clearAllData() {
        if (mData != null) {
            mData.clear();
        }
        this.notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData == null ? 0 : mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public List<T> getData() {
        return mData;
    }

    public void setData(List<T> data) {
        this.mData = data;
    }
}
