package com.example.tomcat.Servlet.CookieExercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


/*获取cookie的servlet，并演示了判断是否是首次登陆的练习*/
@WebServlet("/CookieExerciseTestGet")
public class CookieExerciseTestGet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();        /*获取cookie*/
        Boolean flag = true;                            /*用来控制进入分支--无cookie或者有cookie但是无name=lastlogintime*/
        if (cookies != null && cookies.length > 0 ) {        /*判断cookie非空且长度大于0*/
            for (Cookie c:cookies) {
                String name = c.getName();
                if ("lastlogintime".equals(name)) {   /*有cookie且name匹配*/
                    String valueTime = c.getValue();
                    response.getWriter().write("welcom,你好,last login time: " + valueTime);
                    valueTime= new SimpleDateFormat("yy-MM-dd_HH-mm-ss").format(new Date().getTime());
                    c.setMaxAge(60*60*24);  /*设置cookie存活时间*/
                    c.setValue(valueTime);
                    response.addCookie(c);
                    flag = true;
                    break;
                }

            }
        }if (cookies == null || cookies.length <= 0 || flag == false){ /*无cookie*/
            String valueTime = new SimpleDateFormat("yy-MM-dd_HH-mm-ss").format(new Date().getTime());
            Cookie c = new Cookie("lastlogintime", valueTime);
            c.setMaxAge(60 * 60 * 24);
            response.addCookie(c);
            response.getWriter().write("welcom,你好,you hava no cookie!");
            /*cookie禁用以下字符：[ ] ( ) = , " / ? @ : ;  还有空格，如需要用则必须URL转码*/
            /*SimpleDateFormat函数语法：
               G 年代标志符  y 年  M 月  d 日  h 时 在上午或下午 (1~12)  H 时 在一天中 (0~23)  m 分  s 秒  S 毫秒
               E 星期  D 一年中的第几天  F 一月中第几个星期几  w 一年中第几个星期  W 一月中第几个星期  a 上午 / 下午 标记符
               k 时 在一天中 (1~24)  K 时 在上午或下午 (0~11)  z 时区
             */
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
