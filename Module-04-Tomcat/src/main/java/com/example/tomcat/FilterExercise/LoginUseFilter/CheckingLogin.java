package com.example.tomcat.FilterExercise.LoginUseFilter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/*通过使用filter,验证登陆的练习，访问homepage.html前会验证是否已经登陆,是:则放行,否:则跳转login1.html页面*/
@WebServlet({"/checkinglogin"})
public class CheckingLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("username"));
        boolean username = "username".equals(request.getParameter("username"));
        boolean password = "password".equals(request.getParameter("password"));
        if (password == true && username == true) {
            System.out.println("forwarding!");
            Cookie cookie = new Cookie("token", "ok");
            cookie.setMaxAge(5);        /*cookies 只存活5秒*/
            response.addCookie(cookie);
            response.sendRedirect("homepage.html");

        }else {
            System.out.println("login failed!");
            response.sendRedirect("login1.html");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
