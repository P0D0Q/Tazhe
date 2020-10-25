package com.example.tazhe.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tazhe.R;
import com.example.tazhe.activity.UserActivity;
import com.example.tazhe.activity.VideoInfoActivity;
import com.example.tazhe.beans.CollectListByUser;
import com.example.tazhe.beans.FollowListByUser;
import com.example.tazhe.constants.Constants;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FollowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<FollowListByUser> list;
    private Context context;
    private LayoutInflater layoutInflater;

    public FollowAdapter (Context context,List<FollowListByUser> list) {
        this.context = context;
        this.list=list;
        layoutInflater=LayoutInflater.from(context);
    }

    public void setList(List<FollowListByUser> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= layoutInflater.inflate(R.layout.item_film,parent,false);
        return new FollowAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final FollowListByUser followListByUser = list.get(position);
        if (followListByUser == null)
            return;

        ViewHolder viewHolder = (ViewHolder)holder;
//

        //setText里是String，id是int
        viewHolder.videoname.setText(followListByUser.getFramername());
        viewHolder.videotype.setText("生日："+followListByUser.getBirthday());
        viewHolder.videotime.setText("关注时间："+followListByUser.getFollow_time());

        Picasso.with(context).load(Constants.BASE_URL+followListByUser.getFramer_picture()).into(viewHolder.image);

        //按钮响应事件；点击按钮，跳转页面，显示店铺详情
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), UserActivity.class);
                intent.putExtra("framerid",followListByUser.getFramer_id());
                view.getContext().startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {

        if(list==null)
            return 0;
        else return list.size();
    }


    public  class ViewHolder extends RecyclerView.ViewHolder {
        TextView videoname, videotime,videotype;
        ImageView image;
        public ViewHolder(View view) {
            super(view);
            image = (ImageView) view.findViewById(R.id.film_thumb);
            videoname = (TextView) view.findViewById(R.id.video_name);
            videotype = (TextView) view.findViewById(R.id.video_type);
            videotime = (TextView) view.findViewById(R.id.video_time);

        }
    }
}
