package com.example.tazhe.adapter;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tazhe.R;
import com.example.tazhe.activity.VideoInfoActivity;
import com.example.tazhe.beans.CommentsInfo;
import com.example.tazhe.beans.VideoInfo;
import com.example.tazhe.constants.Constants;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Comment;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<CommentsInfo.DataBean> list;
    private Context context;
    private LayoutInflater layoutInflater;

    public CommentAdapter (Context context,List<CommentsInfo.DataBean> list) {
        this.context = context;
        this.list=list;
        layoutInflater=LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= layoutInflater.inflate(R.layout.item_comment,parent,false);
        return new CommentAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final CommentsInfo.DataBean comment = list.get(position);
        if (comment == null)
            return;
        ViewHolder viewHolder = (ViewHolder)holder;
//

        //setText里是String，id是int
        viewHolder.comment_username.setText(comment.getUsername());
        viewHolder.comment_info.setText(comment.getComment());
        viewHolder.comment_time.setText(comment.getComment_time());
        Picasso.with(context).load(Constants.BASE_URL+comment.getUser_picture()).into(viewHolder.user_pic);

        //按钮响应事件

    }

    @Override
    public int getItemCount() {
        if(list==null)
            return 0;
        else return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView comment_username,comment_info,comment_time;
        ImageView user_pic;
        Button good,special;

        public ViewHolder(View view) {
            super(view);
            user_pic = (ImageView) view.findViewById(R.id.user_pic);
            comment_username = (TextView) view.findViewById(R.id.comment_username);
            comment_info = (TextView) view.findViewById(R.id.comment_info);
            comment_time = (TextView) view.findViewById(R.id.comment_time);

        }
    }
}
