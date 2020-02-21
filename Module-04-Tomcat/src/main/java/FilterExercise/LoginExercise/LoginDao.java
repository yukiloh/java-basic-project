package FilterExercise.LoginExercise;

import java.sql.*;

public class LoginDao {

    public static User login(User user) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String username = user.getUser();
        String passwd = user.getPassword();

        Connection conn = DriverManager.getConnection("jdbc:mysql:///db1?serverTimezone=UTC", "root", "111111");
        PreparedStatement preparedStatement = conn.prepareStatement("SELECT NAME,password FROM testtable WHERE NAME = ? AND PASSWORD = ?;");
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,passwd);
        ResultSet result = preparedStatement.executeQuery();

        boolean b = result.next();

        if (b != false){
            return user;
        }else return null;



        /*下方是使用Druid和JDBCutils的代码，不能读取，问题不明*/
//        System.out.println("login done");
//        //提升作用域,貌似不用也可以因为直接扔
//        Connection connection = null;     //连接数据库对象
//        PreparedStatement preparedStatement = null;     //执行sql对象
//        ResultSet result = null;        //处理结果
//        //从工具包中直接获取连接
//
////        DataSource dataSource = DruidUtils.getDataSource();
//
//
//        String name = user.getUser();
//        String password = user.getPassword();
//
//        System.out.println(name);
//        System.out.println(password);
//
//
//
//
//
//        connection = DruidUtils.getConnection();
//        //获取预处理pstmt对象
//        //定义sql语句
//        preparedStatement = connection.prepareStatement("SELECT NAME,password FROM testtable WHERE NAME = ? AND PASSWORD = ?;");
//        preparedStatement.setString(1,name);    //第一个?和第二个?,用?作为占位符
//        preparedStatement.setString(2,password);
//
//
//        //执行sql
//        result = preparedStatement.executeQuery();
//        System.out.println(result.next());
//
//

//        if (result.next()) {
//            return user;
//        }else return null;
    }
}
