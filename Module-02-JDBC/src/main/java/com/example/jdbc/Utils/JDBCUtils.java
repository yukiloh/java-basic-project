package com.example.jdbc.Utils;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

//一个用来使用jdbc的java工具类
public class JDBCUtils {

    //此工具类的3个目的
    //1.注册驱动
    //2.获取连接对象
    //3.释放资源


    //2.获取连接对象
    private static String url;//提升作用域
    private static String user;
    private static String pswd;
    private static String driver;
        //使用静态代码块导入配置文件
    static {
        try {
//            Class.forName("com.mysql.jdbc.Driver");         //1.注册驱动，其实不写也可以
            Properties properties = new Properties();   //创建prop

//            ClassLoader classLoader = JDBCUtils.class.getClassLoader(); //用类加载器,
//            URL resource = classLoader.getResource("JDBCprop.prop");//加载配置文件中的内容

//            properties.load(new FileReader(resource.getPath()));//获取配置文件中的路径，用FR读取，最后用prop加载配置内容
            properties.load(new FileReader("E:\\Code\\java-code\\JDBC\\src\\JDBCprop.prop"));//获取配置文件中的路径，用FR读取，最后用prop加载配置内容

            url = properties.getProperty("url");    //4个配赋值，
            user = properties.getProperty("user");
            pswd = properties.getProperty("pswd");
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            e.printStackTrace();
         }
    }


    //创造getConn方法，获取链接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,pswd);  //内传入了数据库的用户名密码
    }


    //3.释放资源    关2个
    public static void close (Statement statement,Connection connection) {
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
