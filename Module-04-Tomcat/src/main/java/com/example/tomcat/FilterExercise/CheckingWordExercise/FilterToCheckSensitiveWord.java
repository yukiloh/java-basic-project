package com.example.tomcat.FilterExercise.CheckingWordExercise;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;





/*使用动态代理，代理真实对象req，在invoke中替换输入页面的所有keyword词汇*/
@WebFilter(value = "/check_sensitive")
public class FilterToCheckSensitiveWord implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        /*真实对象:req*/
        /*代理对象:proxy_req*/      /*增强的方法：getParameter*/
        ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if ("getParameter".equals(method.getName())) {
                    /*增强对象,获取返回值*/                           /*req.getParameter("textarea");*/
                    String obj = (String) method.invoke(req, args); /*invoke(真实对象,传入的参数),↑返回的是String!所以这里obj强转为str类型*/
                    if (obj != null) {
                        obj = obj.replace(keyWord, "*");
                    }
                    return obj;

                }
                return method.invoke(req, args);/*如果不是则原样返回*/
            }


        });

        chain.doFilter(proxy_req,resp);
    }

    private String keyWord; /*设置一个key word*/
    public void init(FilterConfig config) throws ServletException {
        /*加载配置*/
        keyWord = "e";
        System.out.println("key word: "+keyWord+"!");

    }

}
