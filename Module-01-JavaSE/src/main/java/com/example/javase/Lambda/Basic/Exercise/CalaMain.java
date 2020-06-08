package com.example.javase.Lambda.Basic.Exercise;

public class CalaMain {


    //一个使用lambda表达式的练习,传入2个数字,然后进行相加计算,并打印
    public static void main(String[] args) {
        invokeCalc(10,130, (int a, int b) -> a + b);
    }

    private static void invokeCalc(int a,int b,Calculator calculator) {
        int result = calculator.calc(a,b);
        System.out.println(result);
    }
}
