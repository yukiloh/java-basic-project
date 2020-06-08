package com.example.javase.Thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {


    /**
     * 测试thread.join()
     */
    @Test
    void testContext() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("111");
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("222");
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("333");
                }
            }
        });

        thread1.start();
        thread2.start();
        thread2.join(); //等到thread2执行完再执行父线程(main),因此产生了t1,t2先后执行,最后才会执行t3
        thread3.start();

        //关于join的理解:
        //当调用父线程下子线程的join时，父线程会挂起线程
        //直到子线程执行完毕，再唤醒父线程继续执行
    }

    /**
     * 测试sleep(0)
     */
    @Test
    void testContext1() throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("111");
                    try {
                        Thread.sleep(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("222");
                    try {
                        Thread.sleep(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }

    /**
     * 公平锁与非公平锁的区别
     */
    @Test
    void testContext2(){
        //创建一个runnable
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName()+"启动");
            myLock();
        };

        //创建并启动线程
        for (int i = 0; i < 5; i++) {
            new Thread(runnable).start();
        }

    }

    private ReentrantLock lock = new ReentrantLock(false);   //此处的true来控制是否为公平锁
    private int count = 0;

    private void myLock() {
        for (int i = 0; i < 10; i++) {
            try {
                lock.lock();
                count++;
                System.out.println(Thread.currentThread().getName() + "获得了锁,count: " + count);
            }finally {
                lock.unlock();
            }
        }
    }

    /**
     * CountDownLatch,线程计数器,用于解决子线程未执行完毕,父线程过早死亡的问题
     */
    @Test
    void testContext3() throws InterruptedException {
        //创建一个CountDownLatch. latch: 门闩
        CountDownLatch latch = new CountDownLatch(2);

        Runnable runnable = (() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " is running,times: " + (i+1));
            }
            latch.countDown();
        });

        //创建2条线程
        new Thread(runnable).start();
        new Thread(runnable).start();
        System.out.println("latch count: " + latch.getCount());

        //使用await()等待countdown(即子线程运行完毕)
        latch.await();
        System.out.println("task finished!");
    }
}
