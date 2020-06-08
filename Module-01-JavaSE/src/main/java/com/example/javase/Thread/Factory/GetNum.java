package com.example.javase.Thread.Factory;


import java.util.Random;

//另一个线程，给对象减去一个数值
public class    GetNum extends Thread{ //2个对象的成员变量相同
    private Objectobj number;
    Random r = new Random();



    public GetNum(Objectobj number){
        this.number = number;
    }

    @Override
    public void run() {
        synchronized (number){
            if (number.isFlag() == false) { //如果对象没有做过增量（false）则等待
                try {
                    number.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();

                 }
            }
            int rnum = r.nextInt(10)+1;
            int result;
            if (rnum <=number.getNumber()) {
                result = number.getNumber() - rnum;
            }else {
                rnum = number.getNumber();
                result = 0;
            }
            System.out.println("傻逼上司吐了" + rnum + "口屎 " + " 现在嘴里有 " + result + "口屎 ");
            number.setNumber(result);
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            number.setFlag(false);  //已做过减量，给状态赋值false
            number.notify();        //唤醒另一条线程
        }
    }
}
