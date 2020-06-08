package com.example.javase.Socket.UpDodnload;


import java.io.*;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) throws IOException {
        clientStart();
    }

    private static void clientStart() throws IOException {
        Socket socket = new Socket("127.0.0.1",8848);

        FileInputStream fileInputStream = new FileInputStream("E:\\javatest\\TCPFolder\\upfolder\\01.jpg");     //指定读取路径的文件

        OutputStream outputStream = socket.getOutputStream();       //读取文件至outputStream
        int len;
        byte[] bytes = new byte[1024];
        while ((len = fileInputStream.read(bytes)) != -1){
            outputStream.write(bytes,0,len);
        }
        socket.shutdownOutput();    //关闭输出流

        InputStream inputStream = socket.getInputStream();  //开始接收回传
        while ((len = inputStream.read(bytes)) != -1){      //读取并打印回传
            System.out.println(new String(bytes,0,len));
        }

        //关闭流
        inputStream.close();
        outputStream.close();
        fileInputStream.close();
        socket.close();
    }
}
