package com.example.javase.Thread;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程相关的一些案例
 */
public class ThreadMain {


    /**
     * 通过继承Thread类实现多线程的方式
     */
    @Test
    public void testContext1() {
        MyThread mt = new MyThread("狗狗蛋");
        mt.setName("No.1");
        mt.start();
        new MyThread("狗蛋").start(); //给多线程取名为狗蛋

        System.out.println("end main");
    }

    /**
     * 通过实现runnable接口的方式
     */
    @Test
    public void testContext2() {
        //内部是一个卖票案例,ris中会在锁住对象,防止票超卖
        RunnableImplSynchronized ris = new RunnableImplSynchronized();
        Thread ts0 = new Thread(ris);
        Thread ts1 = new Thread(ris);
        Thread ts2 = new Thread(ris);
        ts0.start();
        ts1.start();
        ts2.start();
    }

    /**
     * 通过callable实现多线程的方式
     * callable可以接收异步返回的结果,这也是他与runnable最大的区别
     */
    @Test
    @SuppressWarnings("unchecked")
    public void testContext22() throws InterruptedException, ExecutionException {
        //实例化callable接口
        CallableImpl callable = new CallableImpl();

        //Future可以对Callable任务的执行结果进行取消、查询是否完成、获取结果(阻塞)
        //但他只是一个接口,因此才有了FutureTask

        //FutureTask继承了Runnable和Future接口
        //既可以作为Runnable倍线程执行,又可以作为Future得到Callable的结果
        //事实上,FutureTask是Future接口的一个唯一实现类...
        FutureTask<String> task = new FutureTask<String>(callable);
        //将FutureTask作为runnable,执行Thread任务
        new Thread(task).start();

        //模拟处理其他业务...
        Thread.sleep(1000);
        //获得callable的返回值
        System.out.println(task.get());


        //或者也可以通过线程池来调用callable
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        Future future = threadPool.submit(callable);
        System.out.println(future.get());
        threadPool.shutdown();
    }

    /**
     * synchronized的静态同步方法的使用
     */
    @Test
    public void testContext3() {
        //静态同步方法的用法.静态方法没有this,Synchronized内需要传入自身的class文件
        RunnableImplSynchronizedStatic staticObject = new RunnableImplSynchronizedStatic();
        Thread tss0 = new Thread(staticObject);
        tss0.setName("no1");                        //给线程改名no1
        Thread tss1 = new Thread(staticObject);
        tss1.setName("no2");
        Thread tss2 = new Thread(staticObject);
        tss2.setName("no3");
        tss0.start();
        tss1.start();
        tss2.start();
    }

    /**
     * 可重入锁 ReentrantLock 的使用
     * 为什么叫可重入呢?
     * 类的头部中存在锁的状态,0代表未锁,1代表锁
     * 在可重入锁中,锁的状态可能>=1,因为其子类/内部类可能继续对对象进行加锁行为
     * 这便是可重入锁
     * 除了sync关键词和ReentrantLock其他都不是可重入锁(未验证)
     */
    @Test
    public void testContext4() {
        LockImpl lki = new LockImpl();
        Thread tt1 = new Thread(lki);
        tt1.setName("一号日花鸡");
        Thread tt2 = new Thread(lki);
        tt2.setName("二号日花鸡");
        Thread tt3 = new Thread(lki);
        tt3 .setName("三号日花鸡");
        System.out.println(lki);

        tt1.start();
        tt2.start();
        tt3.start();
    }

    /**
     * ThreadLocal可以创建一个能被多个线程访问的变量,使变量在**每个线程都有独立拷贝**
     * 比如一个连接器,频繁的建立连接会极大影响性能(数据库连接器)
     * 因此可以通过ThreadLocal创建连接器的副本,供其他线程使用且互相之间不会影响,也不存在线程安全问题
     * 一定要注意释放避免内存泄漏(调用remove())
     */
    @Test
    public void testContext5() throws InterruptedException {

        //模拟2个不同的方法,并且有不同的参数
        MyClass myClass1 = new MyClass("hello");
        MyClass myClass2 = new MyClass("world");

        //创建runnable
        MyRunnable myRunnable1 = new MyRunnable(myClass1);
        MyRunnable myRunnable2 = new MyRunnable(myClass2);

        //执行多线程
        new Thread(myRunnable1).start();
        new Thread(myRunnable2).start();
        new Thread(myRunnable1).start();
        new Thread(myRunnable2).start();

        //防止过早结束
        Thread.sleep(1000);
    }

    private class MyRunnable implements Runnable{
        //具体ThreadLocal的实现
        private ThreadLocal<MyClass> local = new ThreadLocal<>();
        private MyClass myClass;

        //通过构造函数传入参数
        MyRunnable(MyClass myClass) {
            this.myClass = myClass;
        }

        @Override
        public void run() {
            //设置参数
            local.set(myClass);
            try {
                //调用ThreadLocal中的方法
                local.get().printString();
            }finally {
                //最后保证释放内存(重要)
                local.remove();

                //ThreadLocal是弱引用,当外界不再引用threadLocal(==null)时会被gc
                //但线程销毁后会对ThreadLocal也进行销毁,但ThreadLocal中的value并没有释放(即没调用remove)
                //此时jvm进行gc时会发生内存泄漏,即无法回收value的值

                //关于remove的源码的概括,赋值null才使得value能被gc
                //entry.value = null;
                //entry = null;
            }
        }
    }

    //模拟一个需要被多个线程调用的类
    private class MyClass {
        private String msg;

        MyClass(String msg) {
            this.msg = msg;
        }

        private void printString() {
            System.out.println(Thread.currentThread().getName()+" call this method: "+msg);
        }
    }

    /**
     * 附,使用threadLocal来实现hibernate的session
     * private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
     *
     * //获取Session
     * public static Session getCurrentSession(){
     *     Session session =  threadLocal.get();
     *     //判断Session是否为空，如果为空，将创建一个session，并设置到本地线程变量中
     *     try {
     *         if(session ==null&&!session.isOpen()){
     *             if(sessionFactory==null){
     *                 rebuildSessionFactory();// 创建Hibernate的SessionFactory
     *             }else{
     *                 session = sessionFactory.openSession();
     *             }
     *         }
     *         threadLocal.set(session);
     *     } catch (Exception e) {
     *         // TODO: handle exception
     *     }
     *
     *     return session;
     * }
     */


    // 以下内容在https://github.com/yukiloh/one-line-memo/blob/master/readme.md中有副本

    /**
     * 测试thread.join()
     * 关于join(): 父线程会等待执行join的子线程(父线程挂起),当子线程执行完后才会唤醒父线程,继续执行之后的代码
     */
    @org.junit.jupiter.api.Test
    void testContext6() throws InterruptedException {
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
     * sleep(0),让当前线程与其他线程在此次进行竞争
     */
    @org.junit.jupiter.api.Test
    void testContext7() throws InterruptedException {
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
    @org.junit.jupiter.api.Test
    void testContext8(){
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
    @org.junit.jupiter.api.Test
    void testContext9() throws InterruptedException {
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

