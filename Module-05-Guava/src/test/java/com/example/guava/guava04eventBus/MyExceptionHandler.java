package com.example.guava.guava04eventBus;

import com.google.common.eventbus.SubscriberExceptionContext;
import com.google.common.eventbus.SubscriberExceptionHandler;

public class MyExceptionHandler implements SubscriberExceptionHandler {
    @Override
    public void handleException(Throwable throwable, SubscriberExceptionContext subscriberExceptionContext) {
        //Throwable: 异常
        //SubscriberExceptionContext:可获取异常所在的容器信息
        //例如异常所在的方法
        System.out.println("exception method: "+subscriberExceptionContext.getSubscriberMethod());
    }
}
