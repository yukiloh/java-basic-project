package com.example.javase.HelloWorld;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class TestClass {
    /*使用seed打印helloworld*/
    public static void main(String ... args) {
        System.out.println(randomString(-229985452)+' '+randomString(-147909649));
        //hellow world
    }

    public static String randomString(int seed) {
        Random rand = new Random(seed);
        StringBuilder sb = new StringBuilder();
        while(true) {
            int n = rand.nextInt(27);
            if (n == 0) break;
            sb.append((char) ('`' + n));
        }
        return sb.toString();
    }

    @Test
    public void test(){
        /*日期转毫秒值*/
        String str_date1 = "2013-4-25";
        String[] split = str_date1.split("-");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.valueOf(split[0]), Integer.valueOf(split[1]), Integer.valueOf(split[2]), 0, 0, 0);
        System.out.println(calendar.getTimeInMillis());

        /*另一种打印今天日期的方式*/
        DateFormat dateInstance = DateFormat.getDateInstance(DateFormat.FULL);
        String format = dateInstance.format(new Date());
        System.out.println(format);     /*2019年10月4日星期五*/
    }
}
