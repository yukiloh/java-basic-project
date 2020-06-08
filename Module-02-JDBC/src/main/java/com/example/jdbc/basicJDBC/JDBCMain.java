package com.example.jdbc.basicJDBC;

import java.sql.*;

//这个一个演示 使用jdbc调用数据库的练习,但演示并非完美的方法,有更好的、动态的其他版本
public class JDBCMain {

    public static void main(String[] args){
        // JDBC的使用顺序8步
            //标准格式规范，提升stat的和conn的作用域，使finally中可以close
        Connection conn = null;     //连接数据库对象
        Statement statement = null;     //执行sql对象
        ResultSet result = null;

        try {       //标准格式的规范： 用try抓报错
            //1.导入驱动jar包，每次更换了module都要idea里面添加一次

            //2.注册驱动，mysql 5.0以后可以省略 且不写可以略过红色的报错
//        Class.forName("com.mysql.jdbc.Driver");

            //3.获取数据库连接对象                                 //MySql服务器地址：端口号    //8.0版本后，需要在数据库名后+  ?serverTimezone=UTC
//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?serverTimezone=UTC", "root", "111111");
                //如果是本地的host而且端口是3306，可以简写为  ///
            conn = DriverManager.getConnection("jdbc:mysql:///db1?serverTimezone=UTC", "root", "111111");


            //4.定义sql语句                //练习：添加、修改、删除记录
//            String sql = "INSERT INTO testtable(id,NAME,sex,score) VALUES(NULL,\"JDBCtester1\",1,60);";   //创建一条数据，JDBCtester
//            String sql = "UPDATE testtable SET score = 61 WHERE NAME = 'JDBCtester1';";                   //修改其分数为61
//            String sql = "DELETE from testtable WHERE NAME = 'JDBCtester1';";                             //删除这条数据


            //5.获取执行sql对象 Statement
            statement = conn.createStatement();


            //6.执行sql
//            int i = statement.executeUpdate(sql);     //执行上面的sql语句，某个版本以后需要使用executeUpdate；
//            System.out.println("return:"+i);          //打印看结果，执行了多少语句

                //resultSet
            result = statement.executeQuery("SELECT * FROM testtable;");   //查询结果

            while (result.next()){      //next() 获取第一行的结果,如到最后行则返回false
                int r1 = result.getInt(1);  //第一列是id
                String r2 = result.getString(2);//第二列是name
                int r3 = result.getInt(4);//第四列是score
                System.out.println(r1+"==="+r2+"==="+r3);   //组合打印看结果
            }



//            //7处理结果
//            result.next();
//            int r1 = result.getInt(1);
//            String r2 = result.getString(2);
//            int r3 = result.getInt(4);
//
//            System.out.println(r1+"==="+r2+"==="+r3);


            //判断结果执行超过1条则打印成功
//            if (i > 0) {
//                System.out.println("done");
//            }else {
//                System.out.println("error");
//            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {     //8.标准格式下的释放资源，避免程序出错停止而发生的未close
            if (statement != null) {    //if用来避免空指针报错
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
