package com.example.pc.fromzerotoone.login.iview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.example.pc.fromzerotoone.MainActivity;
import com.example.pc.fromzerotoone.R;
import com.example.pc.fromzerotoone.base.BaseActivity;
import com.example.pc.fromzerotoone.login.bean.UserBean;
import com.example.pc.fromzerotoone.login.presenter.LoginPresenter;

/**
 * Created by pc on 2016/11/16.
 */
public class LoginActivity extends BaseActivity implements ILoginView {
    private EditText edtName,edtPassword;
    private Button btnLogin;
    private RelativeLayout rlProgress;
    private LoginPresenter presenter;
    private UserBean userBean=new UserBean();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewsId();
        init();
    }

    private void findViewsId() {
        edtName= (EditText) findViewById(R.id.edt_name);
        edtPassword= (EditText) findViewById(R.id.edt_password);
        btnLogin= (Button) findViewById(R.id.btn_login);
        rlProgress= (RelativeLayout) findViewById(R.id.rl_progress);
    }

    private void init() {
      presenter=new LoginPresenter(this);
        userBean.setUsername(edtName.getText().toString());
        userBean.setPassword(edtPassword.getText().toString());
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rlProgress.setVisibility(View.VISIBLE);
                presenter.login(userBean);
            }
        });
    }

    //======
    @Override
    public Activity getActivity() {
        return LoginActivity.this;
    }



    @Override
    public void toIntentMain() {
        Intent intent=new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void setProgressVisiblity(boolean isVisible) {
        if (isVisible){
            rlProgress.setVisibility(View.VISIBLE);
        }else {
            rlProgress.setVisibility(View.GONE);
        }
    }
}
