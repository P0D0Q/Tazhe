package com.example.tazhe.service;

import com.example.tazhe.beans.AddComments;
import com.example.tazhe.beans.CommentsInfo;
import com.example.tazhe.beans.VideoDetails;
import com.example.tazhe.beans.VideoInfo;
import com.example.tazhe.beans.VideoInfo2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface VideoService {

    @GET("api/video/allVideo")
    Call<List<VideoInfo>> allVideo();

    @GET("api/video/videoDetails")
    Call<VideoDetails> VideoDetails(@Query("video_id") int video_id);

    @GET("api/comment/allComment")
    Call<List<CommentsInfo>> Comments(@Query("video_id") int video_id);

    @GET("api/comment/addcomment")
    Call<AddComments> AddComments(@Query("user_id") int user_id,
                                  @Query("comment") String comment,
                                  @Query("video_id") int video_id);


}
