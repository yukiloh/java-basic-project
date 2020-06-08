package com.example.guava.guava04eventBus;

import com.google.common.eventbus.Subscribe;

//处理多个
public class MultipleListener {

    //同类型(String)的都会被触发,执行
    @Subscribe
    public void doTask1(final String event) {
        System.out.println("do: "+event);
    }

    @Subscribe
    public void doTask2(final String event) {
        System.out.println("do: "+event);
    }

    //非对应类型不会执行;    传入的如果是123这种数字也不会执行,必须指定为Integer
    @Subscribe
    public void doIntTask(final Integer event) {
        System.out.println("do: "+event);
    }
}
