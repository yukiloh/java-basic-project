package com.example.javase.ThreadPool;

import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author yukiloh
 * @version 0.1
 * @date 2020/6/4 2:31
 * 介绍线程池
 */
public class MyTest {

    public void guide() throws IOException {

        //固定大小的线程池.无界阻塞队列,会出现oom
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);

        //无限制创建线程池,也会oom,适合处理大量耗时短的任务
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        //fixed和cached2个线程池在内部其实实现了ThreadPoolExecutor
        //介绍下内部的参数
        //    public ThreadPoolExecutor(int corePoolSize,//线程池的核心线程数量
        //                              int maximumPoolSize,//线程池的最大线程数
        //                              long keepAliveTime,//当线程数大于核心线程数时，多余的空闲线程存活的最长时间
        //                              TimeUnit unit,//时间单位
        //                              BlockingQueue<Runnable> workQueue,//任务队列，用来储存等待执行任务的队列
        //                              ThreadFactory threadFactory,//线程工厂，用来创建线程，一般默认即可
        //                              RejectedExecutionHandler handler//拒绝策略，当提交的任务过多而不能及时处理时，我们可以定制策略来处理任务
        //                               ) {


        //不同于Executors.newFixedThreadPool(1)
        //fixed可以强转为ThreadPoolExecutor(因为底层是实现了TPE)
        //而single不可以,这才做到了single(他是实现了FinalizableDelegatedExecutorService)
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        System.in.read();   //阻塞线程
    }

    /**
     * 线程池语法的使用
     */
    @Test
    public void testContext01() throws InterruptedException, ExecutionException {
        CountDownLatch latch = new CountDownLatch(10);

        //创建一条runnable
        Runnable runnable = (() -> {
            System.out.println(Thread.currentThread().getName() + " is running,times: ");
            latch.countDown();
        });

        //创建一条callable,任务执行完毕后可以有返回值
        Callable<String> callable = () -> {
            System.out.println(Thread.currentThread().getName() + " is running,times: ");
            latch.countDown();
            return "callable finished";
        };

        //创建一个2线程的池
        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++) {
            threadPool.execute(runnable);                           //execute: 没有返回值
            Future<String> future = threadPool.submit(callable);    //submit: 有返回值
            System.out.println(future.get());                       //通过get()方法来获取返回值
        }

        threadPool.shutdown();                                      //关闭线程池,未执行完的任务会继续执行
        List<Runnable> runnables = threadPool.shutdownNow();        //关闭线程池,未执行完毕的任务会返回队列(runnable)

        System.out.println(threadPool.isShutdown());                //如果调用shutdown,则返回true
        System.out.println(threadPool.isTerminated());              //调用shutdown,且所有任务都完成后返回true
        latch.await();
    }


    /**
     * 简单实践多线程的意义
     * sleep(100)模拟io阻塞
     * 如果没有阻塞,jvm会占用100%系统来处理业务,多线程反而没有单线程快(可以设置循环一万次)
     * 如果存在阻塞,单线程时候会有100ms休眠,而多线程会利用者100ms的休眠切换到其他线程来完成任务(时间可以缩短1/4)
     */
    @Test
    public void testContext02() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);

        Runnable runnable = (() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " is running,times: " + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.println(Thread.currentThread().getName()+"is finished==========");
            latch.countDown();

        });

        ExecutorService threadPool = Executors.newFixedThreadPool(1);

        for (int i = 0; i < 10; i++) {
            threadPool.submit(runnable);
        }

        latch.await();
    }
}
