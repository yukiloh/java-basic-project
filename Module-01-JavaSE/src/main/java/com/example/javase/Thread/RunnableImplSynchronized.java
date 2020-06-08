package com.example.javase.Thread;

/**
 * 卖票案例,通过synchronized来锁住对象,阻止线程不安全
 */
public class RunnableImplSynchronized implements Runnable {

    private int tickets = 100;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronizedMethod();
        }

    }
//    2种synchronized的用法,效果一样
//    1.private synchronized void synchronizedMethod() {....}
//    2.private void synchronizedMethod() {
//        synchronized (this){....}
    private void synchronizedMethod() {
        synchronized (this) {
            if (tickets > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " tickets " + tickets);
                tickets--;
            }
        }
    }
}
