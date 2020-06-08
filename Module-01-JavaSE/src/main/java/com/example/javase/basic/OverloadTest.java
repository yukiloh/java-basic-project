package com.example.javase.basic;

public class OverloadTest {

    //关于重载的测试
    //看到springboot源码中有多个run,而且返回类型不同,因此进行了研究

    private Integer run(){
        return 1;
    }

    private void run(int a) {

    }

    private String run(String a) {
        return "";
    }

    //结论: 方法名相同(重载时),返回类型可以相同,但参数不可
}
