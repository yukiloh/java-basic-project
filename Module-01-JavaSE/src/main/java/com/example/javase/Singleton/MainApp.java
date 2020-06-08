package com.example.javase.Singleton;

import org.junit.Test;

public class MainApp {

    @Test
    public void mainTest() {
        //实际调用单例的4种比较好的方式

        //饿汉型
        SingletonEager.getInstance();

        //懒汉型
        SingletonLazy.getInstance();

        //内部类型
        SingletonInner.getInstance();

        //枚举型
        SingletonEnum.instance.method();

    }

    @Test
    public void testContext() {
        SingletonInner instance = SingletonInner.getInstance();
        instance.setId(1);
        instance.setName("狗蛋");
        System.out.println(instance);
    }
}
