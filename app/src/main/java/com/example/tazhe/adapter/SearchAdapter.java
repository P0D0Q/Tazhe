package com.example.tazhe.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tazhe.R;
import com.example.tazhe.beans.VideoInfo;

import java.util.List;

public class SearchAdapter extends TestAdapter<VideoInfo> {
    public SearchAdapter(Context context, List<VideoInfo> data) {
        super(context, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HolderView holderView = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_search, null);
            holderView = new HolderView();
            holderView.name = (TextView) convertView.findViewById(R.id.searchtext);
            convertView.setTag(holderView);
        } else {
            holderView = (HolderView) convertView.getTag();
        }
        holderView.name.setText(mData.get(position).getVideo_name());
        return convertView;
    }

    private class HolderView {
        TextView name;
    }
}
