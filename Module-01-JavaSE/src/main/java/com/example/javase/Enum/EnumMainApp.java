package com.example.javase.Enum;

import java.util.EnumMap;
import java.util.EnumSet;

public class EnumMainApp {
    public static void main(String[] args) {
        /*枚举的用法*/
        TestEnum a = TestEnum.A;                /*获取一个枚举*/
        TestEnum a1 = TestEnum.valueOf("B");    /*通过枚举名称获取该枚举*/ /*感觉没卵用*/
        TestEnum[] values = TestEnum.values();  /*获取整个枚举*/
        int ordinalA = a.ordinal();             /*获取该枚举的序号，offset=0*/

        /*循环10次，调用switch切换*/
        for (int i = 0; i < 10; i++) {          /*展示了循环和枚举的用法*/
            switchTest();
            System.out.println(testEnum);
        }


        /*通过枚举的构造方法，调用枚举对象中的值*/
        String a2 = TestEnum.A.getKey();
        String b2 = TestEnum.B.getKey();
        String c2 = TestEnum.C.getKey();
        String d2 = TestEnum.D.getKey();
        String e2 = TestEnum.E.getKey();
        System.out.println(a2+"  "+b2+"  "+c2+"  "+d2+"  "+e2);


        /*Enum的2个子类，set & map(不常用)*/
        /*EnumSet的用法展示*/
        EnumSet<TestEnum> set = EnumSet.allOf(TestEnum.class);
        System.out.println(set);        /*打印结果：[A, B, C, D, E]*/

        /*EnumMap的用法(用的非常之少)*/
        EnumMap<TestEnum,String> map = new EnumMap<TestEnum, String>(TestEnum.class);
        map.put(TestEnum.A,"aaa");
        System.out.println(map.get(TestEnum.A));

    }


    private static TestEnum testEnum = TestEnum.A;

    /*提供一个switch切换的方法*/
    private static void switchTest(){
        switch (testEnum){
            case A:testEnum = TestEnum.B;break;
            case B:testEnum = TestEnum.C;break;
            case C:testEnum = TestEnum.D;break;
            case D:testEnum = TestEnum.E;break;
            case E:testEnum = TestEnum.A;break;
        }
    }
}
