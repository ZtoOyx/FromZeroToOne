package com.example.pc.fromzerotoone.login.iview;

import android.app.Activity;

/**
 * Created by pc on 2016/11/16.
 */
public interface ILoginView {
    Activity getActivity();
    void toIntentMain();//登陆成功，跳到主页
    //设置等待进度条的显示于隐藏
    void setProgressVisiblity(boolean isVisible);
}
