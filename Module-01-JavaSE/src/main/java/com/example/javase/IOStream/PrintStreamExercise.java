package com.example.javase.IOStream;


import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.PrintStream;

//打印流的练习,特别短    和其他流一样3个步骤
public class PrintStreamExercise {

    //会生成在项目的根目录下
    public static void main(String[] args) throws FileNotFoundException {       //只有一个找不到文件的报错
        PrintStream ps = new PrintStream("printStream.txt");

        ps.write(99);       //调用父类write还是字节流输出
        ps.println();
        ps.println("this is the common grammar!");      //一般调用自己的println

        System.setOut(ps);  //直接输出语法setOut
        System.out.println("wrote in txt!");        //接下来所有的sout都会输出至txt
        ps.close();                                 //直到close
        System.out.println("end!");                 //这行不会输入到txt


    }

    //会生成在模块的根目录下
    @Test
    void testContext() throws FileNotFoundException {
        PrintStream ps = new PrintStream("printStream.txt");

        ps.write(99);       //调用父类write还是字节流输出
        ps.println();
        ps.println("this is the common grammar!");      //一般调用自己的println

        System.setOut(ps);  //直接输出语法setOut
        System.out.println("wrote in txt!");        //接下来所有的sout都会输出至txt
        ps.close();                                 //直到close
        System.out.println("end!");                 //这行不会输入到txt
    }
}
