package com.example.javase.IOStream;


import java.io.*;
import java.util.HashMap;

//缓冲字符输入输出流的练习（字节流跳过）
public class BufferedWriterAndReaderExercise {
    public static void main(String[] args) throws IOException {
//        bufferedWriterMethod();   //缓冲流写入的自定义方法
        bufferedReaderMethod();     //读取带段标的出师表，排序打印（其实失败了）

    }


    private static void bufferedWriterMethod() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\javatest\\BufferedWriterTest.txt"));
        bw.write("buffered writer done!\r\n");
        for (int i = 0; i < 3; i++) {
            bw.write("next line");
            bw.newLine();
        }
        bw.close();
    }

    private static void bufferedReaderMethod() throws IOException {
        HashMap<String,String > map = new HashMap<>();        //用hashmap接受1.文字段落
        BufferedReader br = new BufferedReader(new FileReader("E:\\javatest\\出师表.txt"));        //用缓冲字符输入流读取出师表
        BufferedWriter bw = new BufferedWriter((new FileWriter("E:\\javatest\\出师表2.txt")));     //写入给出师表2
        String line;        //因为br.readLine()读取的是一行String
        while ((line = br.readLine()) != null) {    //读到最后一行会返回null
            String[] strings = line.split("\\.");       //以.切片,注意\\2次转义
            map.put(strings[0], strings[1]);     //key会自动sort1、2、3、4...但事实上并不会
            //返回2个元素,0号为序列号,1号为文本内容
        }
        for (String key:map.keySet()) {     //用String类的key去历遍map
            String value = map.get(key);    //根据key值获取value
            line = key+value;               //拼装key和value
            System.out.println(line);
            bw.write(line);                 //写入到出师表2文件
            bw.newLine();                   //写入完后打印
        }
        bw.close();
        br.close();
    }
}
