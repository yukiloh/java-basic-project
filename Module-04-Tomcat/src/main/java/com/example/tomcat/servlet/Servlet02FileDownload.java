package com.example.tomcat.servlet;

import com.example.tomcat.constant.MyConstant;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;


/**
 * 演示提供文件下载的练习，浏览器可以解析的文件类型会直接打开
 * 访问地址 → 跳转至servlet → 获取filename、读取文件 → 响应（设置header为attachment）
 * 注意,使用中文的文件名会乱码虽然可以解决但比较麻烦(省略)
 * 下载测试地址: /download?filename=01.jpg
 */
@WebServlet({"/servlet/download"})
public class Servlet02FileDownload extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取文件名
        String filename = req.getParameter("filename");
        //通过容器context获取的服务器中的真实路径
        //图片文件保存在/webapp/images/文件夹下,此处通过全局常量路径IMAGES_PREFIX_PATH添加了路径前缀
        String realPath = req.getServletContext().getRealPath(MyConstant.IMAGES_PREFIX_PATH+filename);

        //获取文件的类型
        String mimeType = this.getServletContext().getMimeType(filename);
        //设置通过设置响应头来设置响应类型
        resp.setHeader("content-type",mimeType);
        //设置响应方式（提供下载的名字）
        resp.setHeader("content-disposition","attachment;filename="+filename);

        //创建字节输出流
        ServletOutputStream outputStream = resp.getOutputStream();

        //文件写入，需要传入真实路径
        FileInputStream fileInputStream = new FileInputStream(realPath);
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bytes)) != -1){
            outputStream.write(bytes,0,len);
        }
        fileInputStream.close();
        outputStream.close();
    }
}
