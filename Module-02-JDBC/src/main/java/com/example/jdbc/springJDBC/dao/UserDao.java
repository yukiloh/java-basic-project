package com.example.jdbc.springJDBC.dao;

import com.example.jdbc.springJDBC.entity.User;
import com.example.jdbc.springJDBC.mapper.UserMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author yukiloh
 * @version 0.1
 * @date 2020/6/9 2:05
 * dao层,内部通过jdbcTemplateObject来执行crud
 * 详细guide: https://docs.spring.io/spring/docs/3.0.x/spring-framework-reference/html/jdbc.html
 */
public class UserDao {

    private JdbcTemplate jdbcTemplateObject;

    /**
     * 此处的dataSource会从spring容器中注入数据
     */
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    /**
     * INSERT / UPDATE / DELETE 都是通过jdbcTemplateObject.update(...)来实现的
     * SELECT 需要通过 queryForXxx 来获取结果
     */

    /**
     * 创建用户
     */
    public void create(String name, String password) {
        String SQL = "insert into user (username, password) values (?, ?)";
        jdbcTemplateObject.update( SQL, name, password);
    }

    /**
     * 根据id,查询用户.
     */
    public User getUserById(Integer id) {
        String SQL = "select * from user where id = ?";
        User user = jdbcTemplateObject.queryForObject(
                SQL                     //sql语句
                ,new Object[]{id}       //需要传入sql的参数,这里是id
                ,new UserMapper()       //如果返回的是多列结果,需要在这里指定映射关系
        );
        return user;
    }

    /**
     * 根据id,查询用户名
     */
    public String getUsernameById(Integer id) {
        String SQL = "select username from user where id = ?";
        String username = jdbcTemplateObject.queryForObject(
                SQL
                ,new Object[]{id}
                ,String.class           //如果查询的是单列结果(不需要映射的情况),则可以传入结果类型
        );
        return username;
    }

    /**
     * 查询所有用户
     */
    public List<User> getAllUsers() {
        String SQL = "select * from user";
        List<User> userList = jdbcTemplateObject.query(SQL,
                new UserMapper());
        return userList;
    }

    /**
     * 根据id,删除用户
     */
    public void deleteById(Integer id){
        String SQL = "delete from user where id = ?";
        jdbcTemplateObject.update(SQL, id);
        System.out.println("Deleted Record with ID = " + id );
    }

    /**
     * 根据id,更新用户密码
     */
    public void update(Integer id, String password){
        String SQL = "update user set username = ? where id = ?";
        jdbcTemplateObject.update(SQL, password, id);
    }
}
