import Utils.JDBCDruidUtils;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;

// 使用Druid数据库连接池的练习
public class JDBCSQLPoolDruidExercise {
    public static void main(String[] args) throws Exception {

        //1.导入druid.jar包
        //2.定义配置文件
        //3.加载配置文件


        //通过普通方法调用druid
//        useDruid();


        //通过工具类使用druid
        useDruidWithUtils();



    }

    private static void useDruidWithUtils() throws SQLException {
        //提升作用域,貌似不用也可以因为直接扔
        Connection connection = null;     //连接数据库对象
        PreparedStatement preparedStatement = null;     //执行sql对象
        ResultSet result = null;        //处理结果
        //从工具包中直接获取连接
        connection = JDBCDruidUtils.getConnection();
        //获取预处理pstmt对象
                //定义sql语句
        String sql = "SELECT * FROM testtable JOIN testtable_sex ON testtable.`sex` = testtable_sex.`id` ORDER BY testtable.`id` ASC;";
        preparedStatement = connection.prepareStatement(sql);
        //执行sql
        result = preparedStatement.executeQuery();

        List<GetSQLData> all = JDBCMainFullVersion.getAll(result);//遍历打印
        for (int i = 0; i < all.size(); i++) {
            System.out.println(all.get(i).getName()+" "+all.get(i).getSex2()+" "+all.get(i).getScore());    //获得result和普通方法不同,无法打印出list集合
        }

        JDBCDruidUtils.close(preparedStatement,connection,result);//记得回收
    }

    private static void useDruid() throws Exception {
        Properties properties = new Properties();
        InputStream inputStream = JDBCSQLPoolDruidExercise.class.getClassLoader().getResourceAsStream("Utils/Druid.props");
        properties.load(inputStream);

        //4.通过工厂DruidDataSourceFactory获取数据库连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        //5.获取连接对象getConnection
        Connection connection = dataSource.getConnection();

        System.out.println(connection);
    }
}
