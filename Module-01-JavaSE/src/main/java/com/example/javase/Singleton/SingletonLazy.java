package com.example.javase.Singleton;

/**
 * 懒汉双锁-延迟加载
 */
public class SingletonLazy {

    //延迟加载有线程安全问题,多个线程判断当前方法为空,会重复生成新的实例
    private static SingletonLazy instance=null;

    private SingletonLazy() {}

    public static SingletonLazy getInstance(){
        if (instance == null) {                     //校验示例是否为空
            synchronized (SingletonLazy.class) {    //为空则同步，再次进行空判断
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }

    //不太好的写法:先同步(synchronized),再判空.因为99%的时候时不需要进行同步,因此极其浪费性能
}
