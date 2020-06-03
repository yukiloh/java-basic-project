package Thread;

import java.util.concurrent.locks.ReentrantLock;


//一个用于测试公平锁的案例
public class MyFairLock {

    private ReentrantLock lock = new ReentrantLock(true);
    private int count = 0;

    private void testFail(){
        for (int i = 0; i < 10; i++) {
            try {
                lock.lock();
                // boolean b = lock.tryLock();     //tryLock:判断该锁是否被使用.也可以传入时间变量,在规定期间内进行判断
                count++;
                System.out.println(Thread.currentThread().getName() + "获得了锁,count: " + count);
            }finally {
                lock.unlock();
            }
        }
    }
    public static void main(String[] args) {
        MyFairLock fairLock = new MyFairLock();
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName()+"启动");
            fairLock.testFail();
        };
        Thread[] threadArray = new Thread[5];
        for (int i=0; i<5; i++) {
            threadArray[i] = new Thread(runnable);
            threadArray[i].start();
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}