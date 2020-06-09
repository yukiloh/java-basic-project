package com.example.tomcat.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;


/*获取cookie的servlet，并演示了判断是否是首次登陆的练习*/
@WebServlet("/cookie/get-cookie")
public class Cookie01GetCookie extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        //获取cookie
        Cookie[] cookies = request.getCookies();

        //存在cookie时
        if (cookies != null && cookies.length > 0 ) {
            //遍历打印cookie
            for (Cookie c:cookies) {
                String cookieName = c.getName();

                //tomcat默认的在url传输时是用iso8859-1编码,就算启用URL编码也不太管用,尽量不要用中文
                String cookieValue = URLDecoder.decode(c.getValue(),"utf-8");
                System.out.println("cookie name: "+ cookieName+"   "+"cookie value: "+cookieValue);
            }
        }else System.out.println("no cookie");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
