package com.example.tomcat.FilterExercise.LoginExercise.Utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DruidUtils {
    //1.注册驱动
    //2.获取连接对象
    //3.释放资源

    private static DataSource dataSource;   //提升ds的作用域
    static {
        try{
            System.out.println("coming ss");
            Properties properties = new Properties();
            InputStream inputStream = DruidUtils.class.getClassLoader().getResourceAsStream("Druid.props");
            System.out.println("getprops");
            properties.load(inputStream);
            System.out.println("loadpps");

            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    //2.创造一个获取连接的方法
    public static Connection getConnection() throws SQLException {  //获取连接的方法
        System.out.println("getcon");
        return dataSource.getConnection();
    }

    //4.获取连接池的方法
    public static DataSource getDataSource (){
        System.out.println("getdaS");
        return dataSource;
    }

    //3.回收(归还)资源
    //关2个
    public static void close (Statement statement, Connection connection) {
        if (statement != null) {    //if用来避免空指针报错
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //重载，关闭3个
    public static void close (Statement statement, Connection connection, ResultSet resultSet) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
