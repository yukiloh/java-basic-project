package com.example.javase.IOStream;

import java.io.*;
import java.util.ArrayList;


//写入一个arraylist,然后再读出并打印
//竟然一次成功了...
public class SerialExercise {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        writeArraylist();   //先写入
        showArraylist();    //再读取打印
    }

    private static void writeArraylist() throws IOException {
        ArrayList<PersonConstructionMethod> arrPer = new ArrayList<>();
        arrPer.add(new PersonConstructionMethod("Tom",100,5,"man"));
        arrPer.add(new PersonConstructionMethod("Jerry",10,2,"man"));
        arrPer.add(new PersonConstructionMethod("William",180,50,"man"));

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\Code\\java-code\\step1\\src\\IOStream\\SerialForTest.txt"));
        oos.writeObject(arrPer);
        oos.close();
    }

    private static void showArraylist() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\Code\\java-code\\step1\\src\\IOStream\\SerialForTest.txt"));
        Object obj = ois.readObject();  //返回的是一个obj类型
        ois.close();

        ArrayList<PersonConstructionMethod> pp =(ArrayList<PersonConstructionMethod>) obj;      //强转obj为AL<PCM>,pp接受
        for (PersonConstructionMethod p:pp) {       //历遍打印
            System.out.println(p.getName()+"  "+p.getStature()+"  "+p.getAge()+"  "+p.getSex());
        }
    }
}
