package com.example.javase.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//反射的练习
public class ReflectMain {
    public static void main(String[] args) throws Exception {

        //获取class对象的三种方式
        //泛型竟然可以？
        Class<?> class1 = Class.forName("com.example.javase.Reflection.Person_Ref");//连同package都要写，写错类名会报错：java.lang.ClassNotFoundException:（且会经常遇到）
//        System.out.println(class1);

//        Class<Person_Ref> class2 = Person_Ref.class;
//        System.out.println(class2);
//
//        Person_Ref person_ref = new Person_Ref();
//        Class<? extends Person_Ref> class3 = person_ref.getClass();
//        System.out.println(class3);


        //class对象操作的示范  成员变量、构造方法、成员方法、类名
        //成员变量
        //获取成员变量
        Field field1 = class1.getField("namee");        //获取 指定field名字的 public成员变量
        Field[] fields = class1.getFields();                    //获取所有public 成员变量
        for (Field elem:fields) {System.out.println(elem);}       //↑示例namee nameee
        Field[] declaredFields = class1.getDeclaredFields();    //获取所有（包括private）的成员变量  ，用数组储存

        //操作成员变量
        Person_Ref person_ref = new Person_Ref();   //创建person的对象
        field1.set(person_ref,"Tom");            //进行修改
        System.out.println(field1.get(person_ref)); //读取结果：Tom
        System.out.println(person_ref.getName());   //直接从person对象读取出来的值是null，所以保存在了反射中的person对象中的namee？

        //操作所有（类型）成员变量declaredField
        declaredFields[2].setAccessible(true);  //暴力印射  [2]是private name
        declaredFields[2].set(person_ref,"Jerry");
        System.out.println(declaredFields[2].get(person_ref));



        //构造方法（只展示部分，其余基本和成员变量相同）            ※构造方法，是用来创建对象的！
        Constructor<?> constructor = class1.getConstructor(String.class, int.class);        //印射创建了构造方法（传入参数）
        System.out.println(constructor.newInstance("Tom",5));   //从印射的构造方法里实例化一个对象，并赋值

//        Object person_ref2 = class1.newInstance();//直接从类中实例化一个空参，这是一种简化操作   该方法已过时



        //成员方法
        Method person_do = class1.getMethod("Person_Do");   //person_do.invoke(person_ref1) :"do"   不传入参数
        person_do.invoke(person_ref);       //执行
//        System.out.println(person_do.invoke(person_ref));      //:null

        Method person_do_more = class1.getMethod("Person_DoMore",String.class); //传入参数
        person_do_more.invoke(person_ref, "eat");       //invoke:调用     调用peson_do_more,并传入参数 eat

        Method[] methods = class1.getMethods();//调用所有方法,返回一个列表
        for (Method method:methods) {System.out.println(method);}//打印了全部的method,包括父类的
        System.out.println(person_do.getName());    //这里补充了一个getName的方法,据说后面会有用

        //
    }
}
