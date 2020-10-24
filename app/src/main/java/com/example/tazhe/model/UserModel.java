package com.example.tazhe.model;



import com.example.tazhe.activity.LoginActivity;
import com.example.tazhe.beans.UserInfo;
import com.example.tazhe.constants.Constants;
import com.example.tazhe.activity.RegActivity;
import com.example.tazhe.listener.RetrofitListener;
import com.example.tazhe.service.UserService;
import com.example.tazhe.activity.UserInfoActivity;

import retrofit2.Call;

public class UserModel extends RetrofitBaseModel {
    private UserService userService;


    public UserModel() {
        this.userService = retrofit.create(UserService.class);
    }
    public void userLogin(String username, String password, final LoginActivity listener)  {
        Call call=userService.login(username, password);
        bindCallback(call,listener, Constants.USERLOGIN);
    }
    public void register(String username, String password,  final RegActivity listener) {
        Call call = userService.register(username, password);
        bindCallback(call,listener, Constants.USEREGISTER);
    }
    public void UpDatebyid(String user_id,String password,String username,String phonenumber,String idcard ,final UserInfoActivity listener) {
        Call call = userService.UpDatebyid(user_id,password,username,phonenumber,idcard);
        bindCallback(call,listener, Constants.USERINFO);
    }
    public void FindUser(String username,  final RetrofitListener listener)  {
        Call call=userService.FindUser(username);
        bindCallback(call,listener, Constants.SEARCHUSER);
    }

    public void CollectResult( int user_id, int video_id,final RetrofitListener listener)  {
        Call call=userService.Collect(user_id,video_id);
        bindCallback(call,listener, Constants.COLLECTVIDEO);
    }

    public void CollectList(int user_id,final RetrofitListener listener)  {
        Call call=userService.CollectList(user_id);
        bindCallback(call,listener, Constants.COLLECTLIST);
    }

    public void UserDetails(int user_id, final RetrofitListener listener)  {
        Call call=userService.UserDetails(user_id);
        bindCallback(call,listener, Constants.USERDETAILS);
    }

}

