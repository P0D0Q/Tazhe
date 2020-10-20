package com.example.tazhe.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tazhe.R;
import com.example.tazhe.activity.VideoInfoActivity;
import com.example.tazhe.beans.VideoInfo;
import com.example.tazhe.constants.Constants;
import com.squareup.picasso.Picasso;

import java.util.List;


public class VideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<VideoInfo> list;
    private Context context;
    private LayoutInflater layoutInflater;

    public VideoAdapter (Context context,List<VideoInfo> list) {
        this.context = context;
        this.list=list;
        layoutInflater=LayoutInflater.from(context);
    }

    public void setList(List<VideoInfo> list) {
        this.list = list;
        notifyDataSetChanged();
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= layoutInflater.inflate(R.layout.item_film,parent,false);
        return new ViewHolder(view);
    }

@Override
public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
    final VideoInfo video = list.get(position);
    if (video == null)
        return;

    ViewHolder viewHolder = (ViewHolder)holder;
//

    //setText里是String，id是int
    viewHolder.videoname.setText(video.getVideo_name());
    viewHolder.videotype.setText("类型："+video.getVideo_type());
    viewHolder.videotime.setText(video.getVideo_time());

    Picasso.with(context).load(Constants.BASE_URL+video.getVideo_picture()).into(viewHolder.image);

    //按钮响应事件；点击按钮，跳转页面，显示店铺详情
    viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), VideoInfoActivity.class);
            intent.putExtra("videoid",video.getVideo_id());
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



