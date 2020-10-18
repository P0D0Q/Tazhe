package com.example.tazhe.service;

import com.example.tazhe.beans.CommentsInfo;
import com.example.tazhe.beans.VideoInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface VideoService {

    @GET("api/video/allVideo")
    Call<VideoInfo> allVideo();

    @GET("api/video/allVideo")
    Call<VideoInfo> VideoInfo(@Query("video_id") int video_id);

    @GET("api/video/allVideo")
    Call<CommentsInfo> Comments(@Query("video_id") int video_id);


}
