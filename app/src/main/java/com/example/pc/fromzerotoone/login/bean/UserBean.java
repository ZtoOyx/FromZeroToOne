package com.example.pc.fromzerotoone.login.bean;

import java.io.Serializable;

/**
 * Created by pc on 2016/11/16.
 */
public class UserBean implements Serializable {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
