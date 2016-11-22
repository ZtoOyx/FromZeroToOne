package com.example.pc.fromzerotoone.login.biz.ibiz;

import com.example.pc.fromzerotoone.login.bean.UserBean;

/**
 * Created by pc on 2016/11/16.
 */
public interface ILoginBiz {
    //登录验证
    void login(ILoginResultListener loginResultListener, UserBean userBean);

}
