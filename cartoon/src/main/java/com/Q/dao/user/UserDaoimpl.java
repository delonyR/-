package com.Q.dao.user;

import com.Q.dao.BaseDao;
import com.Q.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoimpl implements UserDao {
    @Override
    public User getLoginUser(Connection connection, String email) throws SQLException {


        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;

        if (connection != null) {
            String sql = "select * from users where email=?";
            Object[] params = {email};

            resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);

            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setBirthday(resultSet.getDate("birthday"));
                user.setNickname(resultSet.getString("nickname"));
                user.setEmail(resultSet.getString("email"));
                user.setLevel(resultSet.getInt("level"));
                user.setPsw(resultSet.getString("psw"));
                user.setSex(resultSet.getString("sex"));
            }
            //连接可能存在业务，我们需要到业务层的时候再去做
            BaseDao.closeResource(null, preparedStatement, resultSet);
        }
        return user;
    }
}