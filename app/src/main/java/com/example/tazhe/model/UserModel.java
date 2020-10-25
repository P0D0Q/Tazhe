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

    public void FindFramer(String framername,  final RetrofitListener listener)  {
        Call call=userService.FindFramer(framername);
        bindCallback(call,listener, Constants.SEARCHFRAMER);
    }

    public void CollectResult( int user_id, int video_id,final RetrofitListener listener)  {
        Call call=userService.Collect(user_id,video_id);
        bindCallback(call,listener, Constants.COLLECTVIDEO);
    }

    public void FollowResult( int user_id, int framer_id,final RetrofitListener listener)  {
        Call call=userService.Follow(user_id,framer_id);
        bindCallback(call,listener, Constants.FOLLOWFRAMER);
    }

    public void CollectStatus( int user_id, int video_id,final RetrofitListener listener)  {
        Call call=userService.IsCollected(user_id,video_id);
        bindCallback(call,listener, Constants.ISCOLLECTED);
    }

    public void FollowStatus( int user_id, int framer_id,final RetrofitListener listener)  {
        Call call=userService.IsFollowed(user_id,framer_id);
        bindCallback(call,listener, Constants.ISFOLLOWED);
    }

    public void UnCollect( int user_id, int video_id,final RetrofitListener listener)  {
        Call call=userService.DeleteCollected(user_id,video_id);
        bindCallback(call,listener, Constants.UNCOLLECT);
    }

    public void UnFollow( int user_id, int framer_id,final RetrofitListener listener)  {
        Call call=userService.DeleteFollowed(user_id,framer_id);
        bindCallback(call,listener, Constants.UNFOLLOW);
    }

    public void CollectList(int user_id,final RetrofitListener listener)  {
        Call call=userService.CollectList(user_id);
        bindCallback(call,listener, Constants.COLLECTLIST);
    }

    public void FollowList(int user_id,final RetrofitListener listener)  {
        Call call=userService.FollowList(user_id);
        bindCallback(call,listener, Constants.FOLLOWLIST);
    }

    public void UserDetails(int user_id, final RetrofitListener listener)  {
        Call call=userService.UserDetails(user_id);
        bindCallback(call,listener, Constants.USERDETAILS);
    }

    public void FramerDetails(int framer_id, final RetrofitListener listener)  {
        Call call=userService.FramerDetails(framer_id);
        bindCallback(call,listener, Constants.FRAMERDETAILS);
    }

}

