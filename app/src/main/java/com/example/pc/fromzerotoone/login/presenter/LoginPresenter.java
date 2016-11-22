package com.example.pc.fromzerotoone.login.presenter;

import android.widget.Toast;

import com.example.pc.fromzerotoone.login.bean.UserBean;
import com.example.pc.fromzerotoone.login.biz.LoginBiz;
import com.example.pc.fromzerotoone.login.biz.ibiz.ILoginBiz;
import com.example.pc.fromzerotoone.login.biz.ibiz.ILoginResultListener;
import com.example.pc.fromzerotoone.login.iview.ILoginView;

/**
 * Created by pc on 2016/11/16.
 */
public class LoginPresenter {
    private ILoginBiz iLoginBiz;
    private ILoginView iLoginView;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
        iLoginBiz=new LoginBiz();
    }

    public void login(UserBean userBean){
                   iLoginView.setProgressVisiblity(true);
                    iLoginBiz.login(new ILoginResultListener() {
                        @Override
                        public void onLoginSucessListener() {
                            iLoginView.setProgressVisiblity(false);
                            iLoginView.toIntentMain();
                        }

                        @Override
                        public void onLoginFailueListenter(String errorMessage) {
                            iLoginView.setProgressVisiblity(false);
                            Toast.makeText(iLoginView.getActivity(),errorMessage,Toast.LENGTH_LONG).show();
                        }
                    },userBean);
    }
}
