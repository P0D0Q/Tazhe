package com.example.tazhe.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.tazhe.R;
import com.example.tazhe.adapter.CommentAdapter;
import com.example.tazhe.adapter.VideoAdapter;
import com.example.tazhe.beans.AddComments;
import com.example.tazhe.beans.CollectResult;
import com.example.tazhe.beans.CollectStatus;
import com.example.tazhe.beans.CommentsInfo;
import com.example.tazhe.beans.UnCollect;
import com.example.tazhe.beans.VideoDetails;
import com.example.tazhe.beans.VideoInfo;
import com.example.tazhe.beans.VideoInfo2;
import com.example.tazhe.constants.Constants;
import com.example.tazhe.listener.RetrofitListener;
import com.example.tazhe.model.UserModel;
import com.example.tazhe.model.VideoModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VideoInfoActivity extends AppCompatActivity implements RetrofitListener {

    private TextView videoname,videoframer,videotype,videoinfo,specialarea;
    private VideoView videoView;
    private ImageButton back;
    private Button sendcomment;
    private ImageView collect;
    private EditText comment;//评论视频
    private Context context;

    private RecyclerView recyclerView;
    private CommentAdapter commentAdapter;




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
        comment=findViewById(R.id.comment);
        sendcomment=findViewById(R.id.sendcomment);
        collect=findViewById(R.id.collectvideo);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void showVideoInfo(int video_id) {
        VideoModel videoModel=new VideoModel();
        videoModel.VideoDetails(video_id,this);
    }
    //添加评论
    private void addComments(int user_id,String comment,int video_id){
        VideoModel videoModel=new VideoModel();
        videoModel.AddComments(user_id,comment,video_id,VideoInfoActivity.this);
    }
    //评论列表
    private void commentsList(int video_id){
        VideoModel videoModel=new VideoModel();
        videoModel.Comments(video_id,this);
    }

    private void collectVideo(int user_id,int video_id){
        UserModel userModel=new UserModel();
        userModel.CollectResult(user_id,video_id,this);
    }

    private void isCollected(int user_id,int video_id){
        UserModel userModel=new UserModel();
        userModel.CollectStatus(user_id,video_id,VideoInfoActivity.this);
    }

    private void unCollect(int user_id,int video_id){
        UserModel userModel=new UserModel();
        userModel.UnCollect(user_id,video_id,this);
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

        sendcomment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(comment.getText().toString().trim().equals("")){
                    Toast.makeText(VideoInfoActivity.this, "搁那摁啥呢摁", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = getIntent();
                    int videoid = intent.getIntExtra("videoid", 0);

                    SharedPreferences sp = getSharedPreferences("UserInfo",
                            MODE_PRIVATE);
                    String user_id = sp.getString("user_id", "");
                    int typeint = Integer.parseInt(user_id);
                    addComments(typeint, comment.getText().toString(), videoid);
                }
            }
        });

        collect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp = getSharedPreferences("UserInfo",
                        MODE_PRIVATE);
                String user_id = sp.getString("user_id", "");
                int c_user = Integer.parseInt(user_id);

                Intent intent = getIntent();
                int c_video = intent.getIntExtra("videoid",0);

                Drawable.ConstantState image1 = collect.getDrawable().getConstantState();
                Drawable.ConstantState image2 = getResources().getDrawable(R.drawable.ic_collected_24).getConstantState();
                Drawable.ConstantState image3 = getResources().getDrawable(R.drawable.ic_uncollect_24).getConstantState();

                if(image1.equals(image2)){
                    unCollect(c_user,c_video);
                }else if(image1.equals(image3)){
                    collectVideo(c_user, c_video);
                }
            }
        });
    }

    //视频详情



    private void initData() {

        Intent intent = getIntent();
        int videoid = intent.getIntExtra("videoid",0);

        SharedPreferences sp = getSharedPreferences("UserInfo",
                MODE_PRIVATE);
        String user_id = sp.getString("user_id", "");
        int cuserid = Integer.parseInt(user_id);

        showVideoInfo(videoid);
        //addComments(typeint,comment.getText().toString(),videoid);
        commentsList(videoid);
        isCollected(cuserid,videoid);
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

                String videoUrl = Constants.BASE_URL+videoDetails.getVideo() ;

                Uri uri = Uri.parse( videoUrl );

                //设置视频控制器
                videoView.setMediaController(new MediaController(this));

                //播放完成回调
                //videoView.setOnCompletionListener( new MyPlayerOnCompletionListener());

                //设置视频路径
                videoView.setVideoURI(uri);

                //开始播放视频
                videoView.start();



            } else {
                Toast.makeText(VideoInfoActivity.this, "网络错误2", Toast.LENGTH_SHORT).show();
            }
            break;

            case Constants.ADDCOMMENTS:
                AddComments add = (AddComments) o;
                if(add.getMessage().equals("0")) {
                    Toast.makeText(VideoInfoActivity.this, "你摁出去了一条消息", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(VideoInfoActivity.this, "网络错误2", Toast.LENGTH_SHORT).show();
                }
                break;

            case Constants.GETCOMMENTBYID:
                    List<CommentsInfo> comment =(List<CommentsInfo>) o;
                commentAdapter = new CommentAdapter(VideoInfoActivity.this, comment);
                recyclerView.setAdapter(commentAdapter);
                break;

            case Constants.ISCOLLECTED:
                CollectStatus collectStatus = (CollectStatus) o;
                if(collectStatus.getSta().equals("0")){
                    collect.setImageResource(R.drawable.ic_collected_24);
                }else if(collectStatus.getSta().equals("1")){
                    collect.setImageResource(R.drawable.ic_uncollect_24);
                }
                break;

            case Constants.COLLECTVIDEO:
                CollectResult collectResult=(CollectResult) o;
                if(collectResult.getMessage().equals("0")){
                    collect.setImageResource(R.drawable.ic_collected_24);
                    Toast.makeText(VideoInfoActivity.this, "收藏成功", Toast.LENGTH_SHORT).show();
                }
                break;

            case Constants.UNCOLLECT:
                UnCollect unCollect = (UnCollect) o;
                if(unCollect.getMessage().equals("0")){
                    collect.setImageResource(R.drawable.ic_uncollect_24);
                    Toast.makeText(VideoInfoActivity.this, "取消收藏成功", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(VideoInfoActivity.this, "网络错误", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }


    @Override
    public void onFail() {Toast.makeText(VideoInfoActivity.this, "网络错误", Toast.LENGTH_SHORT).show();

    }
}