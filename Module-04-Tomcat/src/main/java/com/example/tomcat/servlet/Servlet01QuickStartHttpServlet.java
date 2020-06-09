package com.example.tomcat.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;


/*
 * 用于演示 HttpServlet 中的一些基本方法
 * postman测试地址: /servlet/quickstart?username=tony&sel=1&sel=2&sel=3
 * body中也可以传入数据
 */

/**
 * 配置servlet的路径
 * servlet3.0后新功能,可通过注解设置资源的路径,替换了web.xml的配置
 * 注解的参数可以是一个数组
 */
@WebServlet({"/servlet/quickstart","/test"})
public class Servlet01QuickStartHttpServlet extends HttpServlet {

    /**
     * 执行Get方法
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet!");

        //获取request中的信息(7个方法)
        System.out.println(req.getMethod());            //获取请求方式,GET
        System.out.println(req.getContextPath());       //虚拟目录
        System.out.println(req.getServletPath());       //servlet路径
        System.out.println(req.getQueryString());       //获取get方式的请求参数
        System.out.println(req.getRequestURI());        //获取URI
        System.out.println(req.getRequestURL());        //url
        System.out.println(req.getProtocol());          //获取协议和版本 HTTP/1.1
        System.out.println(req.getRemoteAddr());        //获取ip地址

        //获取request-header中的信息
        System.out.println(req.getHeader("user-agent"));        //获取浏览器的类型，chrome，Firefox...
        System.out.println(req.getHeader("referer"));           //获取引用页，可判断盗链

        //进行转发,会转发至Servlet01Forward中的容器
        //req.getRequestDispatcher("/servlet/forward").forward(req,resp);

        //也可以直接在get方法中调用post方法,需要传入request和response
        //doPost(req, resp);
    }

    /**
     * 执行Post方法
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost!");

        //post获取的request参数会可能会出现乱码(因为读取的是字节)
        //因此此处需要指定编码(get的乱码已在8.0中解决)
        req.setCharacterEncoding("UTF-8");

        //获取请求体body,只有post有请求体
        //通过字符流获取
        BufferedReader bufferedReader = req.getReader();
        String line;
        System.out.println("====request body====");
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }
        System.out.println("====request body end====\n");

        //==一些通用方法的演示==
        //获取参数(地址栏)username
        System.out.println("username: "+req.getParameter("username"));

        //获取数组参数，具体需要历遍来打印
        String[] parameterValues = req.getParameterValues("sel");
        System.out.println("====param sel====");
        for (String p:parameterValues) {System.out.println("sel: "+p);}
        System.out.println("====param sel end====\n");

        //获取所有参数的名称
        Enumeration<String> parameterNames = req.getParameterNames();
        System.out.println("====all param names====");
        while (parameterNames.hasMoreElements()) {
            System.out.println(parameterNames.nextElement());
        }
        System.out.println("====all param names end====\n");

        //所有请求参数的map集合
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<String> keySet = parameterMap.keySet();
        System.out.println("====map param====");
        for (String name:keySet) {
            //通过key再获取value数组
            String[] strings = parameterMap.get(name);
            for (String s:strings) {System.out.println(s);}
        }
        System.out.println("====map param end ====\n");


        //设置域共享数据，可用于转发
        req.setAttribute("tester","sharing!");
        //调用getRequestDispatcher下的forward方法来转发
        req.getRequestDispatcher("/servlet/context").forward(req,resp);
    }
}
