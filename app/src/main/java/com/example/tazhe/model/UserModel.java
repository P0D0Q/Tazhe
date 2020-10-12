package com.example.tazhe.model;



import com.example.tazhe.activity.LoginActivity;
import com.example.tazhe.beans.UserInfo;
import com.example.tazhe.constants.Constants;
import com.example.tazhe.activity.RegActivity;
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
    public void UpDatebyid(String password, final UserInfoActivity listener) {
        Call call = userService.UpDatebyid(password);
        bindCallback(call,listener, Constants.USERINFO);
    }

}

