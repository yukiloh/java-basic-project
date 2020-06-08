package com.example.tomcat.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/*用来演示使用 HttpServlet 下的 request方法，获取各种参数 的练习*/      /*post有时会发生500读取不到*/

@WebServlet({"/get","/post"})
public class HttpServletExercise extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet!");

//        /*获取  请求行   的7个方法*/
//        System.out.println(req.getMethod());/*获取请求方式    GET*/
//        System.out.println(req.getContextPath());/*虚拟目录   /httpe*/                           /*较常用*/
//        System.out.println(req.getServletPath());/*servlet路径    input=get*/
//        System.out.println(req.getQueryString());/*获取get方式的请求参数         input=get*/
//        System.out.println(req.getRequestURI());/*获取URI   /httpe*/                             /*较常用*/
//        System.out.println(req.getRequestURL());/*url    http://localhost/httpe*/                /*较常用*/
//        System.out.println(req.getProtocol());/*获取协议和版本 HTTP/1.1*/
//        System.out.println(req.getRemoteAddr());/*获取ip地址    0:0:0:0:0:0:0:1*/
//
//        /* 获取  请求头  */
//        System.out.println(req.getHeader("user-agent"));        /*获取浏览器的类型，chrome，Firefox...*/
//        System.out.println(req.getHeader("referer"));           /*获取引用页，可判断盗链*/
//
//
//        /* get和post实际存在通用的读取方法，所以可以在get中写入↓*/
        this.doPost(req,resp);      /*可以简化代码*/

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("doPost!");


//        /*post获取的request参数会出现乱码，get的乱码已在8.0中解决*/
//        req.setCharacterEncoding("UTF-8");      /*读取的是字节*/
//
//        /*获取 请求体  只有post有请求体*/
//            /*通过字符流 获取*/
//        BufferedReader bufferedReader = req.getReader();
//        System.out.println(bufferedReader);     /*org.apache.catalina.connector.CoyoteReader@5e5243bf*/
//        String line = null;
//        while ((line = bufferedReader.readLine()) != null){
//            System.out.println(line);               /*username=post*/
//        }
//        System.out.println("=========================");
//
//        /*一些通用方法的演示*/
//        System.out.println("1"+req.getParameter("username"));       /*所选参数的单个值*/            /*常用*/
//
//        String[] parameterValues = req.getParameterValues("sel");   /*所选参数的所有值，具体需要历遍来打印*/
//        for (String p:parameterValues) {System.out.println(p);}
//
//        Enumeration<String> parameterNames = req.getParameterNames();   /*所有请求参数的名称*/
//        while (parameterNames.hasMoreElements()) {
//            System.out.println(parameterNames.nextElement());               /*枚举打印的方式*/
//        }
//
//        Map<String, String[]> parameterMap = req.getParameterMap();       /*所有请求参数的map集合*/             /*常用*/
//        Set<String> keySet = parameterMap.keySet();
//        for (String name:keySet) {      /*获取键*/
//            String[] strings = parameterMap.get(name);  /*通过键再获取值的数组*/
//            for (String s:strings) {System.out.println(s+"-----");}
//        }

        /*共享数据，只可用于转发   一定要先共享再转发！！！*/
        req.setAttribute("tester","sharing!");
          /*转发的示例，调用getRequestDispatcher下的forward方法来转发，推荐使用匿名函数，因为gRD下只有这个方法而且只会使用一次*/
        req.getRequestDispatcher("/demo").forward(req,resp);


    }
}
