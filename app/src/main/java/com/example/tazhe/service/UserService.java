package com.example.tazhe.service;

import com.example.tazhe.beans.CollectListByUser;
import com.example.tazhe.beans.CollectResult;
import com.example.tazhe.beans.CollectStatus;
import com.example.tazhe.beans.FollowListByUser;
import com.example.tazhe.beans.FollowResult;
import com.example.tazhe.beans.FollowStatus;
import com.example.tazhe.beans.FramerDetails;
import com.example.tazhe.beans.SearchFramer;
import com.example.tazhe.beans.SearchUser;
import com.example.tazhe.beans.SearchVideo;
import com.example.tazhe.beans.UnCollect;
import com.example.tazhe.beans.UnFollow;
import com.example.tazhe.beans.UserDetails;
import com.example.tazhe.beans.UserInfo;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserService {

    @POST("api/user/login")
    Call<UserInfo>login(@Query("username") String username,
                        @Query("password") String password);
    @POST("api/user/register")
    Call<UserInfo>register(@Query("username") String username,
                          @Query("password") String password);
    @POST("api/user/updateById")
    Call<UserInfo>UpDatebyid(@Query("user_id") String user_id,
                             @Query("password") String password,
                             @Query("username") String username,
                             @Query("phonenumber") String phonenumber,
                             @Query("idcard") String idcard);
    @GET("api/framer/findFramer")
    Call<List<SearchFramer>> FindFramer(@Query("framername") String framername);

    @GET("api/user/findUser")
    Call<List<SearchUser>> FindUser(@Query("username") String username);

    @GET("user/collect")
    Call<CollectResult> Collect(@Query("user_id") int user_id,
                                @Query("video_id") int video_id);

    @GET("user/follow")
    Call<FollowResult> Follow(@Query("user_id") int user_id,
                               @Query("framer_id") int framer_id);

    @GET("user/iscollect")
    Call<CollectStatus> IsCollected(@Query("user_id") int user_id,
                                @Query("video_id") int video_id);

    @GET("user/isfollow")
    Call<FollowStatus> IsFollowed(@Query("user_id") int user_id,
                                   @Query("framer_id") int framer_id);

    @GET("user/collect/delete")
    Call<UnCollect> DeleteCollected(@Query("user_id") int user_id,
                                    @Query("video_id") int video_id);

    @GET("user/follow/delete")
    Call<UnFollow> DeleteFollowed(@Query("user_id") int user_id,
                                   @Query("framer_id") int framer_id);

    @GET("user/findCollect")
    Call<List<CollectListByUser>> CollectList(@Query("user_id") int user_id);

    @GET("user/findFollowFramer")
    Call<List<FollowListByUser>> FollowList(@Query("user_id") int user_id);

    @GET("api/user/userDetails")
    Call<UserDetails> UserDetails(@Query("user_id") int user_id);

    @GET("api/framer/framerDetails")
    Call<FramerDetails> FramerDetails(@Query("framer_id") int framer_id);


}
