package com.example.javase.Thread;

import java.util.concurrent.Callable;

/**
 * 通过Callable接口来实现多线程
 */
public class CallableImpl implements Callable {
    @Override
    public String call() throws Exception {
        return "this is callable result";
    }


}
