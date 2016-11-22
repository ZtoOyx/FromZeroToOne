package com.example.pc.fromzerotoone.login.biz.ibiz;

/**
 * Created by pc on 2016/11/16.
 */
public interface ILoginResultListener {
    //成功
    void  onLoginSucessListener();
    //失败
    void onLoginFailueListenter(String errorMessage);
}
