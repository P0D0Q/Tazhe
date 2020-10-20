package com.example.tazhe.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.tazhe.R;
import com.example.tazhe.adapter.CommentAdapter;
import com.example.tazhe.adapter.VideoAdapter;
import com.example.tazhe.beans.CommentsInfo;
import com.example.tazhe.beans.VideoDetails;
import com.example.tazhe.beans.VideoInfo;
import com.example.tazhe.beans.VideoInfo2;
import com.example.tazhe.constants.Constants;
import com.example.tazhe.listener.RetrofitListener;
import com.example.tazhe.model.VideoModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VideoInfoActivity extends AppCompatActivity implements RetrofitListener {

    private TextView videoname,videoframer,videotype,videoinfo,specialarea;
    private VideoView videoView;
    private ImageButton back;
    private EditText comment;//评论视频
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_info);
        initViews();
        initEvents();
        initData();
    }

    private void initViews() {
        videoname=findViewById(R.id.videoname);
        videoframer=findViewById(R.id.videoframer);
        videotype=findViewById(R.id.videotype);
        videoinfo=findViewById(R.id.videoinfo);
        specialarea=findViewById(R.id.specialarea);
        videoView=findViewById(R.id.videoView);
        back=findViewById(R.id.back);

    }


    private void initEvents() {
        //播放事件待写
        //返回待写
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initData() {

        Intent intent = getIntent();
        int videoid = intent.getIntExtra("videoid",0);
        VideoModel videoModel=new VideoModel();
        videoModel.VideoDetails(videoid,this);


    }


    @Override
    public void onSuccess(Object o, int flag) {
        switch (flag) {
            case Constants.GETVIDEOINFO:
            VideoDetails videoDetails=(VideoDetails) o;
            if (videoDetails != null && videoDetails.getVideo_id() != 0) {
                videoname.setText("视频名：" + videoDetails.getVideo_name());
                videoframer.setText("创作者：" + videoDetails.getVideo_framer());
                videotype.setText("视频类型：" + videoDetails.getVideo_type());
                specialarea.setText("视频时长：" + videoDetails.getVideo_time());
                videoinfo.setText("简介：" + videoDetails.getVideo_introduce());
            } else {
                Toast.makeText(VideoInfoActivity.this, "网络错误2", Toast.LENGTH_SHORT).show();
            }
            break;
        }
    }


    @Override
    public void onFail() {Toast.makeText(VideoInfoActivity.this, "网络错误", Toast.LENGTH_SHORT).show();

    }
}