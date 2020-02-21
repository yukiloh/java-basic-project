package Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        while (true){
            ServerSocket serverSocket = new ServerSocket(8848); //初始准备

            Socket socket = serverSocket.accept();      //获取请求

            InputStream is = socket.getInputStream();       //接收
            byte[] bytes = new  byte[1024];
            int len = is.read(bytes);
            System.out.println("get:"+new String(bytes,0,len));

            OutputStream os = socket.getOutputStream();     //回传
            os.write("rogey".getBytes());

            serverSocket.close();       //关闭
        }

//        socket.close();
    }
}
