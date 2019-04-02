package com.example.demo2.entity;

import javax.validation.constraints.NotEmpty;

public class User {
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotEmpty(message = "姓名不能为空!")
    private String userName;
    @NotEmpty(message = "密码不能为空!")
    private String password;
}
