package com.example.javase.Singleton;

/**
 * 通过枚举获取单例，仅JDK1.5后可用，最好的单例实现方式
 */
public enum  SingletonEnum {
    instance;           //枚举内的对象
    SingletonEnum() {}  //枚举的构造函数

    //对外部提供一个get方法来调用枚举
    public void method(){
        System.out.println("hello");
    }

}
