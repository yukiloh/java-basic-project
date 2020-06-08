package com.example.javase.Singleton;

import org.junit.Test;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 关于单例
 */
public class SingletonTestContext {

    @Test
    public void mainTest() {
        //实际调用单例的4种比较好的方式

        //饿汉型,立即加载
        SingletonEager.getInstance();

        //懒汉型,延迟加载,需要双锁
        SingletonLazy.getInstance();

        //内部类型,延迟加载,不需要双锁
        SingletonInner.getInstance();

        //枚举型,Effective Java中推荐的方案
        //通过枚举中的常量(instance)来调用其下的方法
        SingletonEnum.instance.instanceMethod();

    }

    /**
     * 鉴定
     */
    @Test
    public void testContext() throws ExecutionException, InterruptedException {
        //使用可返回结果的callable
        Callable<SingletonInner> callable = new Callable<SingletonInner>() {
            @Override
            public SingletonInner call() throws Exception {
                return SingletonInner.getInstance();
            }
        };

        //通过线程池创建2个instance
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        SingletonInner instance1 = threadPool.submit(callable).get();
        SingletonInner instance2 = threadPool.submit(callable).get();

        //通过地址来判断他们是否是同一个
        System.out.println(instance1==instance2);

    }
}
