package com.Q.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BaseDao {
    static{
        init();
    }
    private static String driver;
    private static String url;
    private static String user;
    private static String password;

    public static void init(){
        Properties params = new Properties();
        String configfile = "db.properties";
        InputStream is = BaseDao.class.getClassLoader().getResourceAsStream(configfile);
        try {
            params.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver = params.getProperty("driver");
        url = params.getProperty("url");
        user = params.getProperty("user");
        password = params.getProperty("password");
    }
    /*创建数据库连接*/
    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    /*编写查询公共类*/
    /*多传参数好统一关闭*/
    public static ResultSet execute(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet,String sql,Object[] params) throws SQLException {
        //预编译的sql后面直接编译就行
        preparedStatement = connection.prepareStatement(sql);
        for(int i = 0;i < params.length;i++){
            //setObject,占位符从1开始，但是数组只能从0开始
            preparedStatement.setObject(i+1,params[i]);
        }
        resultSet = preparedStatement.executeQuery();
        return resultSet;
    }
    /*编写增删改公共类*/
    /*多传参数好统一关闭*/
    public static int execute(Connection connection,PreparedStatement preparedStatement,String sql,Object[] params) throws SQLException {
        //预编译的sql后面直接编译就行
        preparedStatement = connection.prepareStatement(sql);
        for(int i = 0;i < params.length;i++){
            //setObject,占位符从1开始，但是数组只能从0开始
            preparedStatement.setObject(i+1,params[i]);
        }
        int updaterows = preparedStatement.executeUpdate();
        return updaterows;
    }
    //释放资源
    public static boolean closeResource(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet){
        boolean flag = true;
        if(resultSet != null){
            try {
                resultSet.close();
                //GC回收
                resultSet = null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag = false;
            }
        }
        if(preparedStatement != null){
            try {
                preparedStatement.close();
                //GC回收
                preparedStatement = null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag = false;
            }
        }
        if(connection != null){
            try {
                connection.close();
                //GC回收
                connection = null;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                flag = false;
            }
        }
        return flag;
    }
}
