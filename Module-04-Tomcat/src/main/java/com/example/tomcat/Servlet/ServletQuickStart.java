package com.example.tomcat.Servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;


//Servlet的快速开始的练习
//虚拟目录：config→Deployment→Application context

                                /*   " /*.html "只有此种为不合法路径！*/
@WebServlet({"/demo","/demooo"/*,"*.html"*/})
/*servlet3.0新功能，利用注解设置资源路径，免去了web.xml*//*本次练习中demo和demoo其实2个实现的是一个类*/
//也可以进行多个页面的配置value是一个数组

//2点注意，还有一种只重写service的接口GenericServlet
//但实际使用中大多数是实现HttpServlet
public class ServletQuickStart implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("run!");
        System.out.println("and forwarded!");       /*表示转发成功*/

        Object tester = servletRequest.getAttribute("tester");/*表示获取了共享数据*/
        System.out.println(tester);         /*打印看下结果*/
        servletRequest.removeAttribute("tester");       /*删除共享数据*/


    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
    }
}
