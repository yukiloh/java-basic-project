package com.example.javase.Thread;

public class RunnableImplSynchronizedStatic implements Runnable {
    private static int tickets = 100;
    @Override
    public void run() {
        //这个for的位置决定了是先调用一个进程进行循环，还是先循环方法，再在内部决定线程
        for (int i = 0; i < 100; i++) {
            SynStaticMethod();

        }
    }


    //静态同步方法的用法
    private static /*synchronized */void SynStaticMethod() {
        /*静态方法中没有this；静态方法属于类，不属于自己*/
        synchronized (RunnableImplSynchronizedStatic.class){    //静态方法锁定的是本类中的class属性，class文件对象（反射部分知识）
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (tickets > 0) {
                System.out.println(Thread.currentThread().getName() + " tickets " + tickets);
                tickets--;
            }
        }
    }
}
