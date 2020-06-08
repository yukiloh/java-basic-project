package com.example.javase.Enum;

//Enum的类，可以理解为定义一个类，且该类继承了Enum；
public enum MyEnum implements PrintInterface {

    //枚举中的常量.可以理解为这是一个对象,给定且无法更改
    A("a"),
    B("b"),
    C("c"),
    D("d"),
    E("e");

    //为枚举对象提供参数
    private String key;

    //枚举的构造函数
    //与其他构造函数不同，Enum的构造函数的关键词为private(编辑器会提示private为多余的)
    //枚举的构造方法只可以被自己和子类调用(备注:普通java类则一般是public)
    //且与一般java类不同,枚举必须要有构造函数,用来给枚举中的常量赋值
    MyEnum(String key) {
        this.key = key;
    }
    //并提供get、set方法
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


    //枚举也是一个类，也可以实现接口，或者添加抽象类
    @Override
    public void MyPrint() {
        System.out.println("selected key is : "+getKey());
    }

}
