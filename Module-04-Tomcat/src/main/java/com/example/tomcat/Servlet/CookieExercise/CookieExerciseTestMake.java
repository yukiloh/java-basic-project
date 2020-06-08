package com.example.tomcat.Servlet.CookieExercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CookieExerciseTestMake")
public class CookieExerciseTestMake extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("msg", "hello");
        Cookie cookie1 = new Cookie("abcdd", "一共五个字一共五个字一共五个字一共五个字一共五个字一共五个字一共五个字一共五个字一共五个字一共五个字一共五个字一共五个字一共五个字一共五个字一共五个字一共五个字一共五个字一共五个字一共五个字一共五个字一共五个字一共五个字一共五个字一共五个字一共五个字一共五个字一共五个字一共五个字一共五个字一共五个字一共五个字一共五个字一共五个字一共五个字一共五个字一共五个字一共五个字一共五个字一共五个字一共五个字");
        /*cookie可以存在复数*/
        /*name不可以中文，但是8.0以后value可以，value有长度限制*/
        response.addCookie(cookie);
        response.addCookie(cookie1);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
