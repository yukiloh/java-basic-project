package Thread.Factory;

import java.util.Random;

//其中一个线程，给对象生成一个数值
public class MakeNum extends Thread{
    private Objectobj number;
    Random r = new Random();

//生成数值的构造函数，需要传入一个Objectobj number的对象

    public MakeNum(Objectobj number){
        this.number = number;//让对象的number = 本类的number
    }


    //覆盖重新run
    @Override
    public void run() {

        synchronized (number){
            if (number.isFlag() == true) {//如果对象已经加过数值（true），则等待（wait）
                try {
                    number.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }//等待完毕后继续
            int rnum = r.nextInt(10)+1;//随机一个0~10的数
            int result = number.getNumber() + rnum;//让对象加上一个随机数
            System.out.println("傻逼上次吃了"+rnum+"口屎 "+" 现在嘴里有 "+ result+"口屎 ");
            number.setNumber(result);
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            number.setFlag(true);//给对象设定已经增加（true）
            number.notify();//唤醒（另一个等待的线程）
        }
    }
}
