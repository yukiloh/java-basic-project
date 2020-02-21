<%@ page import = "java.text.SimpleDateFormat" %>
<%@ page import = "java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Ash
  Date: 2019/7/8
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>
  <br>

  HELLO TOMCAT<br>
  先显示jsp的write，之后才是body内的内容<br>
  但是这里使用了隔断的写法<br>
  <hr>

<%--  &lt;%&ndash;JSP的演示&ndash;%&gt;--%>
<%--  <%!   /*成员区域*/--%>
<%--    int a = 97;--%>
<%--  %>--%>

<%--  <%    /*执行代码区*/--%>
<%--    response.getWriter().write(a);--%>
<%--  %>--%>

<%--  &lt;%&ndash;直接打印区&ndash;%&gt;--%>
<%--  <%=--%>
<%--    "hello JSP!"--%>
<%--  %>--%>



  <%
    response.setContentType("text/html;charset=utf-8");
    Cookie[] cookies = request.getCookies();        /*获取cookie*/
    Boolean flag = true;                            /*用来控制进入分支--无cookie或者有cookie但是无name=lastlogintime*/
    if (cookies != null && cookies.length > 0 ) {        /*判断cookie非空且长度大于0*/
      for (Cookie c:cookies) {
        String name = c.getName();
        if ("lastlogintime".equals(name)) {   /*有cookie且name匹配*/
          String valueTime = c.getValue();
  %>

  <%="<h1>welcom,你好,last login time: </h1><br>" %><%= "<h1>"+valueTime+"</h1><br>"+" （会直接往页面输入内容）"%>
  <%--隔断的写法,可以不影响页面布局,但代码位置还是会收到执行顺序影响--%>

  <%
          valueTime= new SimpleDateFormat("yyyy-MM-dd----HH:mm:ss").format(new Date().getTime());
          c.setMaxAge(60*60*24);  /*设置cookie存活时间，1天*/
          c.setValue(valueTime);
          response.addCookie(c);
          flag = true;
          break;
        }

      }
    }if (cookies == null || cookies.length <= 0 || !flag) { /*无cookie*/
    String valueTime = new SimpleDateFormat("yy-MM-dd_HH-mm-ss").format(new Date().getTime());
    Cookie c = new Cookie("lastlogintime", valueTime);
    c.setMaxAge(60 * 60 * 24);  /*保留一天*/
    response.addCookie(c);
    %>
  <%="<h1>welcom,你好,you hava no cookie!</h1>"%>
  <%
    /*cookie禁用以下字符：[ ] ( ) = , " / ? @ : ;  还有空格，如需要用则必须URL转码*/
            /*SimpleDateFormat函数语法：
               G 年代标志符  y 年  M 月  d 日  h 时 在上午或下午 (1~12)  H 时 在一天中 (0~23)  m 分  s 秒  S 毫秒
               E 星期  D 一年中的第几天  F 一月中第几个星期几  w 一年中第几个星期  W 一月中第几个星期  a 上午 / 下午 标记符
               k 时 在一天中 (1~24)  K 时 在上午或下午 (0~11)  z 时区
             */

  }
  %>
  </body>
</html>
