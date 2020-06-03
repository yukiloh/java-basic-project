package Thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {


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
        thread2.join();
        thread3.start();
    }



    //测试sleep(0)
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
}
