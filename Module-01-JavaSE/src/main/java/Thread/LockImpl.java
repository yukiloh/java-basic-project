package Thread;

import java.util.concurrent.locks.ReentrantLock;


//这是一个展示lock锁的类
public class LockImpl implements Runnable{
    ReentrantLock reentrantLock = new ReentrantLock();  //先实例化reentrantLock
    private int times = 0;

    @Override
    public void run() {
        reentrantLock.lock();       //在需要的位置插入lock锁
        try {
            for (int i = 0; i < 100; i++) {
                threadUsedLock();
                times++;
            }
        }
        finally {reentrantLock.unlock();    //建议用try&finally的方式来保证unlock的使用
        }
    }

    private void threadUsedLock() {
        System.out.println(Thread.currentThread().getName()+"times "+times);
    }
}
