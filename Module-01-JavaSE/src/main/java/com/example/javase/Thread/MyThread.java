package com.example.javase.Thread;

public class MyThread extends Thread{
    //Thread的子类
    public MyThread(String name) {
        super(name);
    }

    public void run(){

        String threadName = getName();
        System.out.print(threadName);
        Thread t = MyThread.currentThread();
        System.out.println("ThreadEnd");
        System.out.println(t);
    }

}
