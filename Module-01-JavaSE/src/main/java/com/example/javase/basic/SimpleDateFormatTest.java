package com.example.javase.basic;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yukiloh
 * @version 0.1
 * @date 2020/6/9 16:21
 */
public class SimpleDateFormatTest {
    /**
     * 关于SimpleDateFormat字符的意义:
     * G 年代标志符
     * y 年
     * M 月
     * d 日
     * h 时 在上午或下午 (1~12) 
     * H 时 在一天中 (0~23) 
     * m 分  s 秒  S 毫秒
     * E 星期 
     * D 一年中的第几天 
     * F 一月中第几个星期几 
     * w 一年中第几个星期 
     * W 一月中第几个星期 
     * a 上午 / 下午 标记符
     * k 时 在一天中 (1~24) 
     * K 时 在上午或下午 (0~11)  z 时区
     */

    @Test
    void testContext() {
//        String format = new SimpleDateFormat("yy-MM-dd_HH-mm-ss").format(new Date().getTime());   //旧的获取当前时间戳的方法

        //推荐使用 System.currentTimeMillis()
        String format = new SimpleDateFormat("yy-MM-dd_HH-mm-ss").format(System.currentTimeMillis());
        System.out.println(format);
    }
}
