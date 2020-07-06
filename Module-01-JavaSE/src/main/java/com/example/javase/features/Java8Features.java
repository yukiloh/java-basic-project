package com.example.javase.features;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;

class Java8Features implements Java8TestInterface {

    /**
     * 列举了JAVA8的特性
     */

    //1. 接口中使用静态方法(类似于抽象类中的default)
    @Override
    public void showInt(int a) {
        //调用静态方法
        if (a==0) a = Java8TestInterface.initInt();

        System.out.println(a);

        //在重写的方法内直接调用接口的扩展方法
        System.out.println(plusInt(a));
    }

    //具体调用
    @Test
    void show() {
        showInt(1);
    }

    // 个人理解,这使得接口和抽象类的区别进一步缩小,同时也使得接口有更好的拓展性



    //2. 函数式接口的注解
    @FunctionalInterface
    interface Converter<F, T> {
        //函数式接口中的方法只能有一个抽象方法,多个则会报错
        T convert(F from);
        //T convert1(F from);

        //但允许有多个默认方法
        default void show(F from) {
            System.out.println(from);
        }

        //如果不添加 @FunctionalInterface,则可以有多个抽象方法
        //所以该注释主要是帮助编译检查的?
    }

    @Test
    void lambdaInterface() {
        // 实现接口并重写抽象方法
        // 此处可以省略了@Override是因为只有1个抽象方法,如果有多个方法编译器无法判断到底用哪个
        Converter<String, Integer> converter2 = (from) -> {
            show(); //默认方法不受影响
            return Integer.valueOf(from);
        };


        Integer converted = converter2.convert("123");
        System.out.println(converted);    // 123

        //java8的另一个新特性,使用 :: 关键字来传递方法或者构造函数引用
        Converter<String, Integer> converter3 = Integer::valueOf;

        // 或者,当接口用来创建构造函数(TargetFactory<T extends TargetClass>)
        // 此时可以通过Target::new来关联目标类的构造函数和TargetFactory,免去了实现接口的那步
        // 实际代码略(没遇到过)
    }

    // lambda允许使用外部的final变量也是java8的特性...
    // 静态变量可以进行读写,这和lambda/静态变量/普通变量进jvm的顺序有关

    // 提供了一些原来guava的接口,内含了默认方法因此可以更方便使用(比如supplier,Consumer等)



    //3. clock,用于替代原来的currentTimeMillis
    //一般用于需要判断时区的时候
    @Test
    void clock() {
        //这俩一样
        System.out.println(System.currentTimeMillis());
        System.out.println(Clock.systemDefaultZone().millis());

        Clock clock = Clock.systemDefaultZone();
        Instant instant = clock.instant();
        Date legacyDate = Date.from(instant);
        System.out.println(instant);        //0区
        System.out.println(legacyDate);     //当地时区


    }


}
