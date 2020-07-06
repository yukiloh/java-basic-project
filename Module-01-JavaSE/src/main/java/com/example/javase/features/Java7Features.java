package com.example.javase.features;

import org.junit.jupiter.api.Test;

import java.io.*;

class Java7Features {

    /**
     * 列举了一些1.7的特性
     */
    @Test
    void num() {
        // 数字中插入_
        // 方便阅读,本身无意义
        // 不可以将_加载首尾(包括1._01也是非法的)
        int a = 1_145_141_919;
        System.out.println(a);
    }

    @Test
    void catchWithResources() throws IOException {
        //取缔try-finally

        String src = "foo.txt";
        String dst = "foo-dst.txt";

        //try中的变量需要实现接口Closeable/AutoCloseable,便可以自动在使用完后进行close
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)
        ) {
            byte[] buff = new byte[1024];
            int n;
            while ((n = in.read(buff)) >= 0) {
                out.write(buff, 0, n);
            }
        }

        //实际原理是编译期间为你添加finally进行close,语法糖
        //参考: https://www.jianshu.com/p/6adb6dbc4140
    }
}
