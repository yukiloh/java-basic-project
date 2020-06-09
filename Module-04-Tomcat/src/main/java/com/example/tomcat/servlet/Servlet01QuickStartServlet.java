package com.example.tomcat.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;


/**
 * Servlet容器的使用演示
 */
@WebServlet({"/servlet/context"})
/**
 * 通过实现Servlet接口来实现容器的功能
 * 本文件的路径,会被Servlet01QuickStartHttpServlet中的doPost转发所访问
 * 访问后会打印域属性"tester",并删除该域属性
 */
public class Servlet01QuickStartServlet implements Servlet {

    /**
     * servlet初始化时
     * 随第一次访问而初始化
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("servlet is init");

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 具体业务逻辑
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet is accessed");

        //获取名为tester的属性
        Object tester = servletRequest.getAttribute("tester");
        System.out.println("attr=tester: "+tester);

        //删除tester
        servletRequest.removeAttribute("tester");
        System.out.println("attr=tester is deleted");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁时
     * 随服务器终止而销毁
     */
    @Override
    public void destroy() {
        System.out.println("servlet is destroyed");
    }
}
