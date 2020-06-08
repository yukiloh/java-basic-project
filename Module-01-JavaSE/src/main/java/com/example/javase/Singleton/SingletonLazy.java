package com.example.javase.Singleton;

public class SingletonLazy {


    /*懒汉双锁-延迟加载*/
    /*延迟加载有线程安全问题
      多个线程判断当前方法为空，会重复生成新的实例*/
    private static SingletonLazy instance=null;
    private SingletonLazy() {};

    public static SingletonLazy getInstance(){
        if (instance == null) {                     /*校验示例是否为空*/    /*劣等写法：先同步，再判空，99%的时候时不需要进行判空的，所以极其浪费资源*/
            synchronized (SingletonLazy.class) {    /*为空则同步，再次进行空判断*/
                if (instance == null) {
                    instance = new SingletonLazy();
                }
            }
        }
        return instance;
    }

}
