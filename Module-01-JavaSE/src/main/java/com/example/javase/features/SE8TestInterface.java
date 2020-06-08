package com.example.javase.features;

public interface SE8TestInterface {
    void showInt(int a);

    //默认方法,也称为扩展方法
    default int plusInt(int a) {
        return a+1;
    }

    //也可以使用静态方法
    static int initInt() {
        return 1;
    }
}
