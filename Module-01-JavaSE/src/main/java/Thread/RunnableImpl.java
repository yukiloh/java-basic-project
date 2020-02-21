package Thread;

public class RunnableImpl implements Runnable {

    //Runnable的的实现类，覆盖重写了run方法

    //synchronized 同步代码块
    private int tickets = 100;
    Object obj = new Object();

    public void run() {
        synchronized (obj){ //需要传入一个obj
            for (int i = 0; i < 100; i++) {
                if (tickets > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName()+"-----tickets "+tickets);
                    tickets--;
                }
            }
        }
    }
}
