package com.Q.service.user;

import com.Q.pojo.User;

import java.sql.Connection;

public interface UserService {
    //用户登录
    public User login(String email,String psw);
}
