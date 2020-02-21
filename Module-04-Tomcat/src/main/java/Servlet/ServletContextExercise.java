package Servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;


//一个演示提供文件下载的练习，浏览器可以解析的文件类型会直接打开
//点击地址→跳转至servlet→获取filename、读取文件→应答（设置header为attachment）
/*使用中文的文件名会乱码，可以解决，麻烦*/
@WebServlet({"/download"})
public class ServletContextExercise extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {

        String filename = req.getParameter("filename"); /*获取文件名*/
        String realPath = req.getServletContext().getRealPath(filename);/*找到文件的真实路径*/


        String mimeType = this.getServletContext().getMimeType(filename);   /*获取文件的类型*/
        resp.setHeader("content-type",mimeType);        /*设置应答类型*/
        resp.setHeader("content-disposition","attachment;filename="+filename);/*设置应答方式（提供下载的名字）*/





        ServletOutputStream outputStream = resp.getOutputStream();      /*使用resp创建字节输出流对象*/

        FileInputStream fileInputStream = new FileInputStream(realPath);    /*文件写入，需要传入真实路径*/
        byte[] bytes = new byte[1024*10];       /*多传点*/
        int len;
        while ((len = fileInputStream.read(bytes)) != -1){
            outputStream.write(bytes,0,len);
        }
        fileInputStream.close();
        outputStream.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        this.doPost(req,resp);
    }
}
