package com.example.tomcat.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Enumeration;


/*使用动态代理，代理真实对象req，在invoke中替换输入页面的所有keyword词汇*/
@WebFilter(value = "/filter/keyword")
public class Filter02ReplaceKeyword implements Filter {

    /**
     * keyword,替换关键词
     */
    private String keyWord;

    /**
     * 过滤器初始化,一般在容器初始化时被调用
     */
    @Override
    public void init(FilterConfig config) throws ServletException {
        //设置关键词
        keyWord = "b";
        System.out.println("the keyword is :"+keyWord);
    }

    @Override
    public void destroy() {
    }

    /**
     * 使用动态代理,实现关键词的替换
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        //将ServletRequest代理
        ServletRequest proxy_req =
                (ServletRequest) Proxy.newProxyInstance(
                        req.getClass().getClassLoader()
                        ,req.getClass().getInterfaces()
                        ,new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                //如果所代理的方法(ServletRequest)的方法名与"getParameter"匹配,则进行代理
                if ("getParameter".equals(method.getName())) {
                    //反射
                    String obj = (String) method.invoke(req, args);
                    if (obj != null) {
                        //将keyword替换为*
                        obj = obj.replace(keyWord, "*");
                    }
                    return obj;
                }

                //否则原样返回
                return method.invoke(req, args);
            }
        });

        //查看代理后的结果,因为没有返回到网页,因此直接从ServletRequest的值中查看结果
        //获取所有参数的名称
        Enumeration<String> parameterNames = proxy_req.getParameterNames();
        System.out.println("====all param names====");
        while (parameterNames.hasMoreElements()) {
            String nextElement = parameterNames.nextElement();
            //这里可以看到所有的value中,包含b的单词都被替换为*
            System.out.println(nextElement +"   "+proxy_req.getParameter(nextElement));
        }
        System.out.println("====all param names end====\n");

        //返回request和response
        chain.doFilter(proxy_req,resp);
    }
}
