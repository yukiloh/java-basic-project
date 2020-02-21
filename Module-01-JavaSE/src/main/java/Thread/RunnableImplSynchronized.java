package Thread;

public class RunnableImplSynchronized implements Runnable {

    private int tickets = 100;

    @Override
    //synchronized 同步方法对象
    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronizedMethod();
        }

    }
//    2种同步方法的方法
//    1.private synchronized void synchronizedMethod() {....}
//    2.private synchronized void synchronizedMethod() {
//        synchronized (this)/*一定要加this*/{....}
    private /*synchronized*/ void synchronizedMethod() {
        synchronized (this) {
            if (tickets > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " tickets " + tickets);
                tickets--;
            }
        }
    }
}
