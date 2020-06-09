package com.example.jdbc.springJDBC;

import com.example.jdbc.springJDBC.dao.UserDao;
import com.example.jdbc.springJDBC.entity.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yukiloh
 * @version 0.1
 * @date 2020/6/9 2:22
 * springJdbc的测试案例
 */
class SpringJDBCMain {

    private static UserDao userDao;

    /**
     * 初始化,注入userDao
     */
    @BeforeAll
    static void before() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        userDao = (UserDao) context.getBean("userDao");
    }

    /**
     * 测试案例,查询所有用户
     */
    @Test
    void testContext1() {
        userDao.getAllUsers().forEach(user -> System.out.println(user));
    }

    //getUserById

    /**
     * 查询单个用户/用户名
     */
    @Test
    void testContext2() {
        Integer id = 1;

        //为了测试queryForObject中使用Mapper来指定返回结果
        User user = userDao.getUserById(id);
        System.out.println(user);

        //为了测试queryForObject中使用String.class来指定返回结果
        String username = userDao.getUsernameById(id);
        System.out.println(username);
    }
}
