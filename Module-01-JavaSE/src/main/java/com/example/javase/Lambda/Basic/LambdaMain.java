package com.example.javase.Lambda.Basic;

import java.util.Arrays;


//一个练习lambda表达式的类
public class LambdaMain {
    public static void main(String[] args) {


        //调用方法invokeDo，使用匿名内部类重写LambdaInterface
        invokeDo(new LambdaInterface() {
            @Override
            public void doSomething() {
                System.out.println("done!");
            }
        });


        //直接使用匿名函数进行重写
        invokeDo(() -> {System.out.println("lambda done!");});
        //因为只有一行语句,中间的{};可以省略(如果是那句话是return也可以省略)
        //调用的方法（（无参） ->语法体）；
        //================================

        //下面是一个有参匿名函数的用法
        //创建一个LambdaConstructor类型的数组 lambdalist
        LambdaConstructor[] lambdalist = {
                new LambdaConstructor(13,20),
                new LambdaConstructor(11,21),
                new LambdaConstructor(12,22)
        };

        //使用匿名内部类的写法，进行重写
//        Arrays.sort(lambdalist, new Comparator<LambdaConstructor>() {
//            @Override
//            public int compare(LambdaConstructor o1, LambdaConstructor o2) {
//                return o1.getA() - o2.getA();
//            }
//        });

                                //在sort方法中,使用lambda表达式进行重写(实际上是作为一个参数(?))
        Arrays.sort(lambdalist,(LambdaConstructor o1, LambdaConstructor o2)->{return o1.getA() - o2.getA();});
        //调用的方法(  (第一个参数,第二个参数原本是Comparator的重写,这里可以直接省略变为compare需要传入的2个比较大小的参数) -> {方法体:返回语句）;}  );


        //最后强化for循环打印
        for (LambdaConstructor l:lambdalist) {
            System.out.println(l.getA()+""+l.getB());
        }
    }

    //传入一个LambdaInterface类的doS
    private static void invokeDo(LambdaInterface doS) {
        doS.doSomething();
    }
}

