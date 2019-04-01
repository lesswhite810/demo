package com.example.demo2.mapper;

import com.example.demo2.entity.User;

public interface UserMapper {

    User Sel(int id);

    User login(String userName,String passWord);

    int register(User user);
}
