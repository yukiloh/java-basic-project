package com.example.javase.Interface;

public class MainClass {

    public static void main(String[] args) {
        TestInterfaceImplA testInterfaceImplA = new TestInterfaceImplA();
        TestInterfaceImplB testInterfaceImplB = new TestInterfaceImplB();

        TestInterfaceDefault testInterfaceDefault = new TestInterfaceDefault() {
            @Override
            public void absMethod() {

            }
        };


        testInterfaceImplA.absMethod();
        testInterfaceImplB.absMethod();
        testInterfaceDefault.interfaceDefault();


    }


}
