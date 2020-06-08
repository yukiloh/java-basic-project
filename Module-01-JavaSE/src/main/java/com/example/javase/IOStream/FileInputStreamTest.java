package com.example.javase.IOStream;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("E:\\javatest\\FileOutputStreamTest.txt");

        int byte1 = fis.read();     //读取单个字节
        System.out.println(byte1);

        byte [] bytes = new byte[1024];  //读取多个字节，标准读取1024字节
        int len;      //用于接收.read返回的int值
        while ((len = fis.read(bytes)) != -1) {     //判断返回的int值是否为-1(-1代表读完)
            System.out.println(new String(bytes, 0, len));  //打印输出转化为String的数组bytes,0为起始位置,长度为byte2
        }
        fis.close();        //回收资源
    }
}
