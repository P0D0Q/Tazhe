package com.example.tazhe.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.tazhe.R;
import com.example.tazhe.beans.VideoInfo;
import com.example.tazhe.constants.Constants;
import com.example.tazhe.listener.RetrofitListener;
import com.example.tazhe.model.VideoModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VideoInfoActivity extends AppCompatActivity implements RetrofitListener {

    private TextView videoname,videoframer,videotype,videoinfo,specialarea;
    private ImageView videopic,playvideo;
    private List<VideoInfo.DataBean> list;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_info);
        initViews();
        initEvents();
    }

    private void VideoInfo(int video_id) {
        VideoModel videoModel=new VideoModel();
        videoModel.VideoInfo(video_id,this);
    }
    //获取菜谱的评论列表
    private void Comments(int video_id){
        VideoModel videoModel=new VideoModel();
        videoModel.Comments(video_id,this);
    }

    private void initViews() {
        videoname=findViewById(R.id.videoname);
        videoframer=findViewById(R.id.videoframer);
        videotype=findViewById(R.id.videotype);
        videoinfo=findViewById(R.id.videoinfo);
        specialarea=findViewById(R.id.specialarea);
        videopic=findViewById(R.id.videopic);
        playvideo=findViewById(R.id.playvideo);

        Intent intent = getIntent();
        int videoid = intent.getIntExtra("id",0);
    }


    private void initEvents() {
        //播放事件待写
        //返回待写
    }

    private void initData() {

        Intent intent = getIntent();
        final int video_id = intent.getIntExtra("id",0);
        VideoInfo(video_id);
        Comments(video_id);


    }


    @Override
    public void onSuccess(Object o, int flag) {

        switch (flag) {
            case Constants.GETVIDEOINFO:
                final VideoInfo.DataBean videoInfo = list.get(flag);
                if (!videoInfo.getVideo_id() .equals("")) {
                    Picasso.with(context).load(Constants.BASE_URL + videoInfo.getVideo_picture() ).into(videopic);
                }
                videoname.setText("视频名："+videoInfo.getVideo_name());
                videoframer.setText("创作者：" + videoInfo.getVideo_framer());
                videotype.setText("视频类型：" + videoInfo.getVideo_type());
                specialarea.setText("视频时长：" + videoInfo.getVideo_time());
                //videoinfo.setText("简介：" + videoInfo.getVideo_info() );



                break;
            //case Constants.GETCOMMENTBYID:
            //评论待写
        }

    }

    @Override
    public void onFail() {Toast.makeText(VideoInfoActivity.this, "网络错误", Toast.LENGTH_SHORT).show();

    }
}