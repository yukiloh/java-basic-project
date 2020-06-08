package com.example.javase.Singleton;

/**
 * 饿汉型-立即加载
 */
public class SingletonEager {

    //定义一个私有静态变量
    private static SingletonEager instance = new SingletonEager();

    private SingletonEager() {}

    //创建一个对外提供实例的get方法
    public static SingletonEager getInstance() {
        return instance;
    }

    //添加的测试变量
    private Integer integer = 0;

    public Integer getInteger() {
        return integer;
    }
    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    //单例中,一般中只有一个实例存在
}




