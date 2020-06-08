package com.example.javase.RandomText;
import java.util.ArrayList;
import java.util.Random;

//要求：生成6个随机数，添加入集合，并历遍打印
public class randomText01 {
    public static void main(String[] args) {
        //实例化random to  random
        Random random = new Random();
        //实例化一个集合 ArrayList to list
        ArrayList<Integer> list = new ArrayList<>();
        //随机6次，添加入集合
        for (int i = 0; i < 6; i++) {
            int temp = random.nextInt(33)+1;
            list.add(temp);
        }
        System.out.println(list);   //打印输出看结果
        //获取集合的长度

        //历遍输出每个集合的元素
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)  +  "   ");
        }
    }
}
