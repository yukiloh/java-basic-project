package com.example.javase.Interface;

public class TestInterfaceImplA implements TestInterfaceDefault {

    //调用接口中的抽象方法需要全部重写
    @Override
    public void absMethod() {
        System.out.println("实现类A");
    }
}
