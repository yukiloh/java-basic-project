package com.example.javase.InnerClass;

//接口类
public interface HeroArmor {
    //一般的接口类只能是public,并且可以省略public和abstract关键词
    //弄个private的接口,你让其他方法怎么实现
    void armorValue();

    //也可以在其中定义默认方法方法
    private void defaultMethod() {
        System.out.println("default method done!");
    }
}
