package Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8848);       //准备

        OutputStream outputStream = socket.getOutputStream();       //发送
        outputStream.write("hello".getBytes());

        InputStream inputStream = socket.getInputStream();      //接受回传
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        System.out.println("get: "+new String(bytes,0,len));

        socket.close();     //关闭

    }
}
