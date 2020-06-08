package com.example.javase.Thread.Factory;


//这个一个 给对象加一个数值，然后又减去这个对象数值的例子，                             主要练习了等待（wait）和唤醒（notify）。
public class Main {
    public static void main(String[] args) {
        Objectobj objectobj = new Objectobj();      //实例化一个Objectobj类的 objectobj
        MakeNum mkn = new MakeNum(objectobj);       //开启2条线程
        GetNum gtn = new GetNum(objectobj);


        objectobj.setNumber(0);                     //给对象的初始值设为0
        for (int i = 0; i < 10; i++) {              //循环10次
            mkn.run();
            gtn.run();
        }
        System.out.println("最后嘴里有"+objectobj.getNumber()+"口屎！");
    }
}
