package com.example.tazhe.service;

import com.example.tazhe.beans.VideoInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface VideoService {

    @GET("api/video/allVideo")
    Call<VideoInfo> allVideo();


}
