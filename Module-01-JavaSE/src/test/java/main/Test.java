package main;

import java.lang.reflect.InvocationTargetException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.stream.IntStream;

public class Test {


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
//        long a = new TimeCounter().start();
//        //调用其他main方法
//        DouDiZhu douDiZhu = new DouDiZhu();
//        douDiZhu.main(null);

//        char c = "あ";
//        System.out.println((String) "あ");

//        new TimeCounter().end(a);

        // System.out.println("hello");
        /**
          \u01234
          */
        String word = "AbCdE";
        IntStream chars = word.chars();
        System.out.println(chars.min().toString());

    }

}


