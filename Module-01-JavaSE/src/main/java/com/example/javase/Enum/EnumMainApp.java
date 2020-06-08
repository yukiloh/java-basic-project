package com.example.javase.Enum;

import java.util.EnumMap;
import java.util.EnumSet;

/**
 * 演示枚举的用法
 */
public class EnumMainApp {
    public static void main(String[] args) {
        MyEnum a = MyEnum.A;                //获取一个枚举

        MyEnum a1 = MyEnum.valueOf("B");    //通过枚举名称获取该枚举
        MyEnum[] values = MyEnum.values();  //获取整个枚举
        int ordinalA = a.ordinal();             //获取该枚举的序号，offset=0

        //循环10次，调用switch切换
        for (int i = 0; i < 10; i++) {          //展示了循环和枚举的用法
            switchTest();
            System.out.println(myEnum);
        }

        //通过枚举的构造方法，调用枚举对象中的值
        String a2 = MyEnum.A.getKey();
        String b2 = MyEnum.B.getKey();
        String c2 = MyEnum.C.getKey();
        String d2 = MyEnum.D.getKey();
        String e2 = MyEnum.E.getKey();
        System.out.println(a2+"  "+b2+"  "+c2+"  "+d2+"  "+e2);

        //调用枚举中的方法(接口方法)
        a.MyPrint();

        //Enum的2个子类，set & map
        //EnumSet的用法展示
        EnumSet<MyEnum> set = EnumSet.allOf(MyEnum.class);
        System.out.println(set);        //打印结果：[A, B, C, D, E]

        //EnumMap的用法,将枚举作为map的泛型进行使用
        EnumMap<MyEnum,String> map = new EnumMap<MyEnum, String>(MyEnum.class);
        map.put(MyEnum.A,"aaa");
        System.out.println(map.get(MyEnum.A));


    }


    private static MyEnum myEnum = MyEnum.A;

    //在switch中调用枚举进行判断
    private static void switchTest(){
        switch (myEnum){
            case A:
                myEnum = MyEnum.B;
                break;
            case B:
                myEnum = MyEnum.C;
                break;
            case C:
                myEnum = MyEnum.D;
                break;
            case D:
                myEnum = MyEnum.E;
                break;
            case E:
                myEnum = MyEnum.A;
                break;
        }
    }
}
