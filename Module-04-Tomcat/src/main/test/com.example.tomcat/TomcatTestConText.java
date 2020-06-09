package com.example.tomcat;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Random;

/**
 * @author yukiloh
 * @version 0.1
 * @date 2020/6/9 15:02
 */
public class TomcatTestConText {

    @Test
    public void testContext01() throws UnsupportedEncodingException {
//        System.out.println(new Random().nextInt(10));
        String s = "%E4%B8%80%E5%85%B1%E4%BA%94%E4%B8%AA%E5%AD%97%E4%B8%80%E5%85%B1%E4%BA%94%E4%B8%AA%E5%AD%97%E4%B8%80%E5%85%B1%E4%BA%94%E4%B8%AA%E5%AD%97%E4%B8%80%E5%85%B1%E4%BA%94%E4%B8%AA%E5%AD%97%E4%B8%80%E5%85%B1%E4%BA%94%E4%B8%AA%E5%AD%97%E4%B8%80%E5%85%B1%E4%BA%94%E4%B8%AA%E5%AD%97%E4%B8%80%E5%85%B1%E4%BA%94%E4%B8%AA%E5%AD%97%E4%B8%80%E5%85%B1%E4%BA%94%E4%B8%AA%E5%AD%97%E4%B8%80%E5%85%B1%E4%BA%94%E4%B8%AA%E5%AD%97%E4%B8%80%E5%85%B1%E4%BA%94%E4%B8%AA%E5%AD%97%E4%B8%80%E5%85%B1%E4%BA%94%E4%B8%AA%E5%AD%97";

        String decode = URLDecoder.decode(s, "utf-8");
        System.out.println(decode);
    }
}
