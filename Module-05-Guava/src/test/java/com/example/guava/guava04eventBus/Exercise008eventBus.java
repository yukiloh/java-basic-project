package com.example.guava.guava04eventBus;

import com.google.common.eventbus.EventBus;
import org.junit.jupiter.api.Test;

//eventBus 事件的中间件
public class Exercise008eventBus {

    //基础用法
    @Test
    void test01(){
        //创建一个eventBus
        final EventBus eventBus = new EventBus();
        //将自定义SimpleListener注册至eb
        eventBus.register(new SimpleListener());
        //进行消息推送
        eventBus.post("say hello");
    }


    //推送多个事件,会根据类型触发订阅
    @Test
    void test02(){
        final EventBus eventBus = new EventBus();
        eventBus.register(new MultipleListener());

        eventBus.post("say hello"); //重复执行2次,因为task1和task2都接收String
        eventBus.post(123);         //默认此处传入的是Integer,如果接收方类型为int则不会触发!
    }


    //补充,如果一个子类继承父类,eb注册了子类后,父类的方法也会被推送!
    //相反,父类注册后,子类不会被推送
    //演示略


    //关于异常: 推送事件至订阅,如果这个事件有异常,则是由订阅来处理
    //处理eb的异常
    @Test
    void test03(){
        //eventBus中需要传入 实现了SubscriberExceptionHandler的类,用于捕获异常
        final EventBus eventBus = new EventBus(new MyExceptionHandler());
        eventBus.register(new ExceptionListener());
        eventBus.post("say hello");
    }


    //deadEvent: 主要用于处理没有被订阅的事件
    @Test
    void test04(){
        //创建时为eb命名
        EventBus eventBus = new EventBus("dead event");
        eventBus.register(new DeadEventListener());
        eventBus.post("hello world!");  //被处理的event
        eventBus.post(111);             //没有被处理的event,打印结果:DeadEvent{source=EventBus{dead event}, event=111}
    }
}
