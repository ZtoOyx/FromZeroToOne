package com.example.pc.fromzerotoone.login.biz;

import android.support.annotation.NonNull;

import com.example.pc.fromzerotoone.login.bean.UserBean;
import com.example.pc.fromzerotoone.login.biz.ibiz.ILoginBiz;
import com.example.pc.fromzerotoone.login.biz.ibiz.ILoginResultListener;

/**
 * Created by pc on 2016/11/16.
 */
public class LoginBiz implements ILoginBiz {
    private String name;
    private String password;
    @Override
    public void login(ILoginResultListener loginResultListener, UserBean userBean) {
           loginFunc(loginResultListener,userBean);
    }


    //==========
    public void loginFunc(final ILoginResultListener loginResultListener, UserBean userBean ){
        name=userBean.getUsername();
        password=userBean.getPassword();
        if (name.equals("")||password.equals("")){
            if (loginResultListener!=null){
                loginResultListener.onLoginFailueListenter("账号或密码不能为空~");
            }
        }else {//一般会走认证服务器，获取cookie，token之类，这里模拟登陆
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(5000);//休眠5s
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (!name.equals("admin")&&!password.equals("1")){
                        if (loginResultListener!=null){
                            loginResultListener.onLoginFailueListenter("账号或密码错误~");
                        }
                    }else {
                        if (loginResultListener!=null){
                            loginResultListener.onLoginSucessListener();
                        }
                    }
                }
            }).start();
        }

    }
}
