package com.Q.dao.user;

import com.Q.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;

public interface UserDao {
    public User getLoginUser(Connection connection, String email) throws SQLException;
}
