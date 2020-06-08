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


    //静态同步方法的用法,同样是2种synchronized方法都可以
//    private static synchronized void SynStaticMethod() {
    private static void SynStaticMethod() {
        //注意,静态方法中没有this,因为静态方法**属于类**,而不是对象,同样静态方法也不能使用super

        //举一个例子,正常调用一个对象的方法时 new Obj().method(); 而静态方法则是Obj.method();
        //很容易就可以得出 静态方法属于类 这个结论

        //静态方法锁定的是class本身
        synchronized (RunnableImplSynchronizedStatic.class){
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
