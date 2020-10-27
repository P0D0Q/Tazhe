package com.example.tazhe.model;

import com.example.tazhe.constants.Constants;
import com.example.tazhe.fragments.HomeFragment;
import com.example.tazhe.listener.RetrofitListener;
import com.example.tazhe.service.VideoService;

import retrofit2.Call;

public class VideoModel extends RetrofitBaseModel {
    private VideoService videoService;


    public VideoModel() {
        this.videoService = retrofit.create(VideoService.class);
    }
    public void allVideo( final RetrofitListener listener) {
        Call call = videoService.allVideo();
        bindCallback(call, listener, Constants.GETALLVIDEO);
    }

    public void VideoDetails( int video_id,final RetrofitListener listener) {
        Call call = videoService.VideoDetails(video_id);
        bindCallback(call, listener, Constants.GETVIDEOINFO);
    }

    public void Comments(   int video_id,final RetrofitListener listener) {
        Call call = videoService.Comments(video_id);
        bindCallback(call, listener, Constants.GETCOMMENTBYID);
    }

    public void AddComments(   int user_id,String comment,int video_id,final RetrofitListener listener) {
        Call call = videoService.AddComments(user_id,comment,video_id);
        bindCallback(call, listener, Constants.ADDCOMMENTS);
    }

    public void VideoType(   int type_id,final RetrofitListener listener) {
        Call call = videoService.VideoType(type_id);
        bindCallback(call, listener, Constants.VIDEOTYPE);
    }

    public void FindVideo(   String video_name,final RetrofitListener listener) {
        Call call = videoService.FindVideo(video_name);
        bindCallback(call, listener, Constants.SEARCHVIDEO);
    }

    public void UploadVideo( final RetrofitListener listener) {
        Call call = videoService.UploadVideo();
        bindCallback(call, listener, Constants.SEARCHVIDEO);
    }


}