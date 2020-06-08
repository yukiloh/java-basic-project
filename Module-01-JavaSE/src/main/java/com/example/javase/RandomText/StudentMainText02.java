package com.example.javase.RandomText;

import java.util.ArrayList;
//


public class StudentMainText02 {
    public static void main(String[] args) {

        //要求：自定义4个学生对象，添加到集合，历遍打印
        //练习3：创建集合后，创建一个类，按照{Element 01 @,Element 02@....}的格式打印输出


        //创建一个集合，包含student元素
        ArrayList<Student> list = new ArrayList<Student>();

        //实例化4个student,并赋予name&age的参数
        Student s01 = new Student("s01", 88);
        Student s02 = new Student("s02", 99);
        Student s03 = new Student("s03", 55);
        Student s04 = new Student("s04", 24);
        Student s05 = new Student("s05", 25);
        Student s06 = new Student("s06", 26);
        Student s07 = new Student("s07", 27);


        //把4个student添加进集合list
        list.add(s01);
        list.add(s02);
        list.add(s03);
        list.add(s04);
        list.add(s05);
        list.add(s06);
        list.add(s07);
        System.out.println(list);
        //调用打印机
        printter(list);
    }




    public static void printter(ArrayList<Student> list) {
        //历遍，并按要求打印
        System.out.print("{");  //打印开头
        for (int i = 0; i < list.size(); i++) {
            Student temp = list.get(i);
            System.out.print("Name: "+temp.getName() + "  " + "Age :"+temp.getAge());
            if (i == list.size() - 1) {     //按要求插入@
                break;
            } else
                System.out.print("@");


        }
        System.out.println("}");        //打印尾巴
    }
}
