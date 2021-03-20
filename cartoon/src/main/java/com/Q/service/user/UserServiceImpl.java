package com.Q.service.user;

import com.Q.dao.BaseDao;
import com.Q.dao.user.UserDao;
import com.Q.dao.user.UserDaoimpl;
import com.Q.pojo.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class UserServiceImpl implements UserService{
    //业务层都会调用Dao层；
    private UserDao userDao;

    public UserServiceImpl() {
        this.userDao = new UserDaoimpl();
    }
    //email和psw为前端所传
    @Override
    public User login(String email, String psw) {
        Connection connection = null;
        User user = null;


        try {
            connection = BaseDao.getConnection();
            //通过业务层调用具体的数据库操作
            user = userDao.getLoginUser(connection,email);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return user;
    }
    @Test
    public void test(){
        User user = login("1286270880@qq.com","1246");
        System.out.println(user.getPsw());
    }
}
