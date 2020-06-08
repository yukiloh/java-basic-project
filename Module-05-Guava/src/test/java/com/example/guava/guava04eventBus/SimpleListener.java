package com.example.guava.guava04eventBus;

import com.google.common.eventbus.Subscribe;


//处理单个事件
public class SimpleListener {

    //Subscribe:进行标记,该方法需要订阅eventBus所推送的内容
    @Subscribe
    public void doActioin(final String event) {
        //订阅方法的一些细节:
        //订阅的方法必须为void
        //event的参数只可设为1个
        System.out.println("do: "+event);
    }
}
