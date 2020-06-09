package com.example.tomcat.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;


/**
 * 一些response的方法的演示,感觉不太会用到
 */
@WebServlet({"/servlet/response"})
public class Servlet03ResponseExercise extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");

        //设置响应头为utf-8解码
        resp.setContentType("text/html; charset=utf-8");

        //2种字符输出流的方式,因为只允许一次输出,这里通过随机取模来实现
        if ((new Random().nextInt(10)%2)==0) {
            //通过字符输出流向页面输入数据
             resp.getWriter().write("abc字符输出");
        }else {
            //通过字节输出流向页面输入数据,需要指定编码为utf-8
            resp.getOutputStream().write("abc字节输出".getBytes(StandardCharsets.UTF_8));
        }

        //重定向
//        resp.sendRedirect("https://cn.bing.com/?");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
