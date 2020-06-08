package com.example.javase.Method;


public class demoPerson {
    public static void main(String[] args) {


        Person person = new Person();       //创建一个person对象，并调用了构造方法

        Person personAge = new Person(0);


        person.name = "ME";     //给成员变量name赋值
        person.sayHello("YOU");     //给方法sayHello下的name赋值


    }
}
