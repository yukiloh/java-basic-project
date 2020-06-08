package com.example.jdbc.springJDBC.mapper;

import com.example.jdbc.springJDBC.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author yukiloh
 * @version 0.1
 * @date 2020/6/9 2:11
 * 用于映射java中的实体类
 * 如果希望兼容多个实体类,可以参考: https://blog.csdn.net/u010887744/article/details/64216979
 */
public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }
}
