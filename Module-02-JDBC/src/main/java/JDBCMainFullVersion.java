import Utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//这个一个完整的演示版本
public class JDBCMainFullVersion {



    /*步骤：
        1.（注册驱动，可以省略），连接数据库对象conn  ---通过JDBC工具类执行，其中通过配置文件传入服务器地址用户密码等
        2.创建数据库对象stat，执行数据库语句，返回result
        3.获取result中的内容  ---自定义一个方法
        4.打印结果
        5.回收资源
     */
    public static void main(String[] args) {
        //标准格式规范，提升stat的和conn的作用域，使finally中可以close
        Connection connection = null;     //连接数据库对象
        Statement statement = null;     //执行sql对象
        ResultSet result = null;        //处理结果

        try {
            result = JDBCUtils.getConnection().createStatement().executeQuery("SELECT * FROM testtable JOIN testtable_sex ON testtable.`sex` = testtable_sex.`id` ORDER BY testtable.`id` ASC;");
            //利用自定义的JDBC工具类中，返回的connection，来创建stat，再执行查询语句"按sex查询2表所有数据，按主表id升序"

            //调用getAll方法获取封装后的查询数据list
            List<GetSQLData> list = getAll(result);     //遍历打印
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(statement, connection, result); //调用close回收资源
        }
    }

    //这是个进行封装的，查询数据库结果的方法    返回封装后的List<GetSQLData>，输入处理数据后获得的result
    public static List<GetSQLData> getAll(ResultSet result) throws SQLException {
        GetSQLData getSQLData;  //提高作用域
        List<GetSQLData> list = new ArrayList<>();  //创建一个用来接收结果的ArrayList
        while (result.next()) {      //next() 获取第一行的结果,如到最后行则返回false
            int r1 = result.getInt(1);  //第一列是id
            String r2 = result.getString(2);//第二列是name
            int r3 = result.getInt(3);//sex1
            int r4 = result.getInt(4);//score
            String  r5 = result.getString(5);//pswd
            int r6 = result.getInt(6);//id
            String r7 = result.getString(7);//sex2

            getSQLData = new GetSQLData();  //调用javabean中的set
            getSQLData.setId(r1);
            getSQLData.setName(r2);
            getSQLData.setSex(r3);
            getSQLData.setScore(r4);
            getSQLData.setPswd(r5);
            getSQLData.setId2(r6);
            getSQLData.setSex2(r7);

            list.add(getSQLData);   //将一行数据添加入list中
        }
        return list;    //返回整个结果list
    }
}

