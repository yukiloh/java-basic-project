package com.example.javase.IOStream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;



//使用Properties属性集来写入/读取文件
public class PropertiesStoreAndLoadExercise {
    public static void main(String[] args) throws IOException {
        propStore();
        propLoad();
    }

    private static void propStore() throws IOException {        //写入
        Properties prop = new Properties();     //创建Properties集合
        prop.setProperty("key1","value1");      //往集合里写内容
        prop.setProperty("key2","value2");
        prop.setProperty("key3","value3");

        prop.store(new FileWriter("E:\\javatest\\PropertiesReaderWriterTest.txt"),"comments");
        //使用properties下的store方法，调用FileWriter写入prop集合中的内容，这里使用了匿名函数
        //也可以使用FileOutputStream字节输出流，但是不能写入中文编码
        //因为是匿名函数，使用完便结束，不需要使用close（？）


    }

    private static void propLoad() throws IOException {     //输出
        Properties prop = new Properties();     //创建Properties集合
        prop.load(new FileReader("E:\\javatest\\PropertiesReaderWriterTest.txt"));
        //使用prop下的load方法，并使用FileReader方法传入读取prop类型内容（prop的读取这一步已完成）

        Set<String> stringSet = prop.stringPropertyNames();     //通过历遍读取prop中的内容
        for (String key:stringSet){
            String value = prop.getProperty(key);
            System.out.println(key+value);
        }

    }

}
