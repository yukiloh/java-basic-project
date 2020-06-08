package com.example.javase;

import org.junit.Assert;
import org.junit.Test;      //  junit貌似要手动import一下

public class MyTest {


//    @Before                 //必先执行
//    public void init(){     //init  初始化，python也有个__init__
//        System.out.println("init:   ");
//    }
//
//    @After                  //必最后执行
//    public void close(){     //
//        System.out.println("close.");
//    }


    @Test
    public void testTest() {
        int result = 2 + 3;
        System.out.println("test start!");
//        Assert.assertEquals(4,result);
        Assert.assertEquals(5,result);      //断言（期望值，结果值）
        System.out.println("resule: " + result);

    }

    @Test
    public void testTest2() {
        int total = 80000;
        for (int i = 0; i < total; i++) {
            if (isPrime(i)) {
                System.out.println("prime: "+i);
            }
        }
        System.out.println("all done");
    }

    private boolean isPrime(int v) {
        if (v == 1 || v == 2 || v == 3){
            return true;
        }


        for (int i = 2; i < v; i++) {
            if (v % i == 0) return false;
        }

        return true;
    }

}
