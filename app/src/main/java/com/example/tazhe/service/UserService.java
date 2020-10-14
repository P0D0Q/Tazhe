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
    @POST("api/user/updateById")
    Call<UserInfo>UpDatebyid(@Query("user_id") String user_id,
                             @Query("password") String password,
                             @Query("username") String username,
                             @Query("phonenumber") String phonenumber,
                             @Query("idcard") String idcard);

}
