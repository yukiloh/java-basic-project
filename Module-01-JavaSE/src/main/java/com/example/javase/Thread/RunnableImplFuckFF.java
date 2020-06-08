package com.example.javase.Thread;

public class RunnableImplFuckFF implements Runnable {
    private long times = 0;

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            fuckFF();
            times++;
        }

    }

    private  void fuckFF() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" is fucking yun zhi,now is "+times+"times");
    }
}
