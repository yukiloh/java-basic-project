package com.example.javase.IOStream;


import java.io.*;

//练习转换流 OutputStreamWriter&InputStreamReader
public class OutputStreamWriterAndInputStreamReaderExercise {
    public static void main(String[] args) throws IOException {
        writeGBK();
        readGBK();
    }

    private static void writeGBK() throws IOException {
//        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("E:\\javatest\\新建文本文档.txt",false));//默认使用utf-8格式进行输出
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("E:\\javatest\\新建文本文档gbk.txt",false),"GBK");
        osw.write("GBK was wrote!");
        osw.write("\r\nGBK类型的汉字已经输入!");        //以gbk输入的1个汉字占2个字节,utf-8为3
        osw.flush();
        osw.close();
    }

    private static void readGBK() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("E:\\javatest\\新建文本文档gbk.txt"),"GBK");
        int len;
        while ((len = isr.read()) != -1){
            System.out.print((char)len);
        }

    }
}
