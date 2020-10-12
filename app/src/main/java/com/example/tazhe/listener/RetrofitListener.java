package com.example.tazhe.listener;

public interface RetrofitListener<T> {

    void onSuccess(T t, int flag);

    void onFail();


}

