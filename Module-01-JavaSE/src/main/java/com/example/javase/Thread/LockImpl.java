package com.example.javase.Thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 用于展示ReentrantLock的用法
 */
public class LockImpl implements Runnable{
    private ReentrantLock reentrantLock = new ReentrantLock();  //先实例化reentrantLock
    private int times = 0;

    @Override
    public void run() {
        //在需要锁定的位置插入lock锁
        reentrantLock.lock();

        try {
            for (int i = 0; i < 100; i++) {
                threadUsedLock();
                times++;
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            //必须使用finally的方式来保证unlock的使用
            reentrantLock.unlock();
        }
    }

    private void threadUsedLock() {
        System.out.println(Thread.currentThread().getName()+"times "+times);
    }
}
