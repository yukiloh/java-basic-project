package com.example.tomcat.filter;

import javax.servlet.*;     /*注意一定是javax.servlet下的包*/
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;


/**
 * 过滤filter的使用
 * 关于dispatcherTypes: 设定需要拦截的过滤的类型,REQUEST对应request请求,FORWARD则为转发请求
 * 如果只设定REQUEST,转发时并不会进行拦截
 */
@WebFilter(
        value = {"/filter/quickstart"}
        ,dispatcherTypes = {
                DispatcherType.REQUEST
                ,DispatcherType.FORWARD
        })
public class Filter01QuickStart implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * 过滤器的主要业务逻辑
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter done!!");

        //可以通过类型转换,获取HttpServletRequest
        //HttpServletRequest request = (HttpServletRequest) servletRequest;

        //模拟一个if/else判断,来演示过滤器的作用
        boolean isOk = new Random().nextInt(10)%2 == 0;
        if (isOk) {
            System.out.println("success!");

            //如果成功则进行放行
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            System.out.println("failed...");

            //如果失败,则重定向至其他页面
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.sendRedirect("/");
        }
    }

    @Override
    public void destroy() {

    }
}
