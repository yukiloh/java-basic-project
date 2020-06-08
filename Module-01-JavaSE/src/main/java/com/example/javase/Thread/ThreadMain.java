package com.example.javase.Thread;

public class ThreadMain {

    public static void main(String[] args) {
        //这是一个多线程的方法演示

        //①通过继承Thread类实现多线程
        MyThread mt = new MyThread("狗狗蛋");
        mt.setName("No.1");
        mt.start();
        new MyThread("狗蛋").start(); //给多线程取名为狗蛋

        System.out.println("end main");






        //②实现Runnable接口实现多线程，相较Thread的方法，可以有更灵活的数据传递（子父类继承）
        //里面是同步代码块
        RunnableImpl run = new RunnableImpl();
        Thread t0 = new Thread(run);      //Runnable创建的实例作为参数传递给Thread，来运行
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        t0.start();
        t1.start();
        t2.start();


        //同步方法的用法，从RIS实现类实例化；实现runnable，内部添加同步代码块Synchronized{}
        RunnableImplSynchronized ris = new RunnableImplSynchronized();
        Thread ts0 = new Thread(ris);
        Thread ts1 = new Thread(ris);
        Thread ts2 = new Thread(ris);
        ts0.start();
        ts1.start();
        ts2.start();

        //静态同步方法的用法，从RISS实现类实例化；静态方法没有this，Synchronized内需要传入class文件
        RunnableImplSynchronizedStatic riss = new RunnableImplSynchronizedStatic();
        Thread tss0 = new Thread(riss);
        tss0.setName("no1");            //给线程改名no1
        Thread tss1 = new Thread(riss);
        tss1.setName("no2");
        Thread tss2 = new Thread(riss);
        tss2.setName("no3");
        tss0.start();
        tss1.start();
        tss2.start();

        /*日花鸡；未同步，实现Runnable接口*/
        RunnableImplFuckFF fkf = new RunnableImplFuckFF();
        Thread fk1 = new Thread(fkf);
        fk1.setName("一号日花鸡 ");
        Thread fk2 = new Thread(fkf);
        fk2.setName("二号日花鸡 ");
        Thread fk3 = new Thread(fkf);
        fk3 .setName("三号日花鸡 ");

        fk1.start();
        fk2.start();
        fk3.start();

        /*通过继承Runnable接口,并实例化ReentrantLock来实现同步多线程 */
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


        /*另外一种多线程的方法，实现Callable接口*/
        CallableImpl callable = new CallableImpl();
        try {
            Object call = callable.call();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*当需要保证同一时刻只有一个线程对变量进行操作时
        * 除了使用synchronized()加锁
        * 还可以通过ThreadLocal创建一个可以被多个线程安全访问的共享变量，使变量在每个线程都有独立拷贝
        * 注意释放，避免内存泄漏！*/
        ThreadLocal<Object> objectThreadLocal = new ThreadLocal<>();


    }
}

