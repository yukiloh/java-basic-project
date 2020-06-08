package com.example.tomcat.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/*一些response方法的演示*/
@WebServlet({"/resp"})
public class ResponseExercise extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost");

        /*重定向*/
//        resp.sendRedirect("https://cn.bing.com/?");

        /*字符流输出*/
            /*先告诉浏览器使用utf-8解码*/
//        resp.setContentType("text/html;charset=utf-8");
//
//            /*获取字符输出流，输出数据*/
//        resp.getWriter().write("abc字符输出");


        /*字节输出流*/
            /*也需要先声明utf-8，此处已声明略过*/
            /*获取字节输出流，输出数据*/
        resp.getOutputStream().write("abc字节输出".getBytes());




    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
