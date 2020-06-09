package com.example.tomcat.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * 关于cookie的基本,如何设置cookie
 * cookie禁用以下字符：[ ] ( ) = , " / ? @ : ;  还有空格,如需要使用时需要进行转码
 */
@WebServlet("/cookie/set-cookie")
public class Cookie01SetCookie extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置下编码
        response.setContentType("text/html; charset=utf-8");

        //创建cookie
        Cookie cookie = new Cookie("msg", "hello");
        //设置存活时间(1天)
        cookie.setMaxAge(60*60*24);


        //cookie的value存在字数限制
        String value = "一共五个字一共五个字" +
                "一共五个字一共五个字一共五个字一共五个字" +
                "一共五个字一共五个字一共五个字一共五个字一共五个字";
        Cookie cookie1 = new Cookie(
                "longCookie"
//                , URLEncoder.encode(value, StandardCharsets.UTF_8)    //java10中可用
                , URLEncoder.encode(value,"utf-8")
        );

        //存入response中
        response.addCookie(cookie);
        response.addCookie(cookie1);

        System.out.println("cookie is set");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
