package com.example.tazhe.service;

import com.example.tazhe.beans.UserInfo;


import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserService {

    @POST("api/user/login")
    Call<UserInfo>login(@Query("username") String username,
                        @Query("password") String password);
    @POST("api/user/register")
    Call<UserInfo>register(@Query("username") String username,
                          @Query("password") String password);
    @POST("api/user/UpDatebyid")
    Call<UserInfo>UpDatebyid(@Query("password") String password);

}
