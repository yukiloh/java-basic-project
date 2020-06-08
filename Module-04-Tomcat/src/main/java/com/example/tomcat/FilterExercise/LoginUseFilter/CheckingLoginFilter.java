package com.example.tomcat.FilterExercise.LoginUseFilter;

import javax.servlet.http.Cookie;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(value = {"/homepage.html"},dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD})
public class CheckingLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie c : cookies) {
                if ("token".equals(c.getName()) && "ok".equals(c.getValue())) {
                    System.out.println("success!");
                    filterChain.doFilter(servletRequest, servletResponse);
                }

            }
        } else {
            System.out.println("failed...");
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.sendRedirect("/checkinglogin");
        }
    }

    @Override
    public void destroy() {

    }
}
