import Utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//这是一个验证用户名密码登陆的练习,内包含了预编译sql和事务处理
public class JDBCLoginExercise {
    public static void main(String[] args) throws SQLException {

        //1.输入用户名密码     今后是否为空应该是网页来判断
        System.out.println("input user: ");
        String username = new Scanner(System.in).next();

        System.out.println("input pswd: ");
        String passwd = new Scanner(System.in).next();



        //2.调用数据库内容
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {



//            result = JDBCUtils.getConnection().createStatement().executeQuery("SELECT NAME,password FROM testtable WHERE NAME = '"+username+"' AND PASSWORD = '"+passwd+"';");
                //↑常规方法写入语句，容易造成数据库注入，于是使用prepStat预编译的sql语句
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement("SELECT NAME,password FROM testtable WHERE NAME = ? AND PASSWORD = ?;");
            preparedStatement.setString(1,username);    //第一个?和第二个?,用?作为占位符
            preparedStatement.setString(2,passwd);
            result = preparedStatement.executeQuery();


            //补充内容事务的开启      防止程序进行中出现错误修改了第一次
//            connection.setAutoCommit(false);  //关闭自动提交
//            connection.commit();    //提交事务



        } catch (Exception e) {         //进行回滚的时候,需要catch报错,注意作用域要变大
//            if (connection != null){    //必须保证conn不为空才能进行回滚
//                connection.rollback();  //回滚操作
//            }
            e.printStackTrace();
        }

        //3.判断结果
        Boolean flag = loginMethod(result);
//        Boolean flag = loginMethodMine(result,username,passwd);
        if (flag) {
            System.out.println("success");
        }else {
            System.out.println("error");
        }

        //4.回收资源，prepStat继承了stat，所以修改名称即可
        JDBCUtils.close(preparedStatement,connection,result);



        }



    private static Boolean loginMethod(ResultSet result) throws SQLException {

        if (result.next()) {
            return true;
        } else {
            return false;
        }
    }


        private static Boolean loginMethodMine(ResultSet result, String name, String passwd) throws SQLException {
        GetSQLData getSQLData;
        List<GetSQLData> list = new ArrayList<>();  //创建一个用来接收结果的ArrayList


        while (result.next()) {
            String username = result.getString(1);//name
            String pswd = result.getString(2);//score

            getSQLData = new GetSQLData();  //调用javabean中的set
            getSQLData.setName(username);
            getSQLData.setPswd(pswd);
            list.add(getSQLData);   //将一行数据添加入list中
        }
        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).getName().equals(name) && list.get(i).getPswd().equals(passwd)) {
                return true;
            }

        }
    return false;
    }

}
