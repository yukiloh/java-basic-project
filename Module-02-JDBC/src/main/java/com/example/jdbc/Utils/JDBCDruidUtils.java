package com.example.jdbc.Utils;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//一个通过工具类调用Druid连接池的练习
public class JDBCDruidUtils {

    //还是3个目的
    //1.注册驱动
    //2.获取连接对象
    //3.释放资源


    private static DataSource dataSource;   //提升ds的作用域
    //通过静态代码块注册驱动,获取连接对象
    static {
        try{
            //1.加载配置文件
            Properties properties = new Properties();
            InputStream inputStream = JDBCDruidUtils.class.getClassLoader().getResourceAsStream("com/example/jdbc/Utils/Druid.props");
            properties.load(inputStream);

            //通过工厂DruidDataSourceFactory获取数据库连接池对象
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    //2.创造一个获取连接的方法
    public static Connection getConnection() throws SQLException {  //获取连接的方法
        return dataSource.getConnection();
    }

    //4.获取连接池的方法
    public static DataSource dataSource(){
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
