package com.example.javase.Socket.UpDodnload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TcpServer {

    public static void main(String[] args) throws IOException {
        //新建server端的套接字
        ServerSocket serverSocket1 = new ServerSocket(8848);
        ServerSocket serverSocket2 = new ServerSocket(8849);

        while (true) {
            webPageStart(serverSocket1);     //开启web页面
            serverStart(serverSocket2);      //开启上传服务
        }
        // serverSocket1.close();   //最后需要关闭端口.因为while(true),不会执行到这一步的
    }



    private static void serverStart(ServerSocket serverSocket) throws IOException {      //客户端的配置操作
        new Thread(() -> {
            try {
                Socket socket = serverSocket.accept();      //开启接收，需要写在多线程里面，类似于监听？

                File file = new File("E:\\javatest\\TCPFolder\\Serverfolder");      //设置根目录位置
                if (!file.exists()) {       //如果目录不存在（前面有个！）
                    file.mkdir();           //就创建
                }

                InputStream inputStream = socket.getInputStream();      //读取接收的字节
                String fileName = (new Random().nextInt(99999))+".jpg";     //定义random文件名，问题是我怎么知道这个是jpg的呢...
                FileOutputStream fileOutputStream = new FileOutputStream("E:\\javatest\\TCPFolder\\Serverfolder"+File.separator+fileName);  //指定路径

                int len;            //开始写入接收的字节
                byte[] bytes = new byte[1024];
                while ((len = inputStream.read(bytes)) != -1){
                    fileOutputStream.write(bytes,0,len);
                }
                System.out.println("File received");  //本屏打印已接受

                socket.getOutputStream().write("get it!".getBytes());   //回传



//            socket.shutdownOutput();    //传达end，或者关闭close也行
                fileOutputStream.close();
                inputStream.close();

                serverSocket.close();   //结束server socket

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();


    }

    private static void webPageStart(ServerSocket serverSocket) throws IOException {      //客户端的配置操作
        Socket socket = serverSocket.accept();      //开启接收
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write("HTTP/1.1 200 OK \r\n".getBytes());
                    outputStream.write("Content-Type:text/html\r\n".getBytes());
                    outputStream.write("\r\n".getBytes());

                    String request = bufferedReader.readLine();
                    System.out.println(request);
//                        String[] strings = request.split(" ");
//                        String path = strings[1].substring(1);  //GET /xxxxxxxxx xxxxxxxxx
                    FileInputStream fileInputStream = new FileInputStream("E:\\javatest\\TCPFolder\\艾泽拉斯议事厅 - Hall of Azeroth NGA玩家社区.html   ");
                    int len;
                    byte[] bytes = new byte[1024];
                    while ((len = fileInputStream.read(bytes)) != -1) {
                        outputStream.write(bytes, 0, len);
                    }
                    bufferedReader.close();
                    outputStream.close();
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        }



}
