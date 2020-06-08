package com.example.javase.IOStream.File;

import java.io.File;


//历遍一个文件夹
public class FileMain {
    public static void main(String[] args) {


        File file = new File("E:\\javatest");   //需要历遍的目录
        ergodicFile(file);      //ergodic 历遍并打印文件夹内所有内容

        System.out.println("========================");
        ergodicFileAndGetEndWith(file); //历遍并找出以txt结尾的文件

        System.out.println("========================");
        ergodicFileAndUseFilter(file);  //用filter判断txt,需要重写

    }

    private static void ergodicFile(File file) {
        System.out.println(file);           //先打印目标文件/文件夹
        File[] files = file.listFiles();    //用列表files接受file下的文件名称
        for (File obj:files){               //进行历遍
            if (obj.isDirectory()) {        //如果是一个文件夹
                ergodicFile(obj);           //继续调用自方法,把获得obj(文件夹)作为参数传入
            }else {
                System.out.println(obj);    //如果是个文件,则把file类型的obj打印
            }
        }
    }

    private static void ergodicFileAndGetEndWith(File file) {   //通过历遍，只打印以.txt结尾的文件
        File[] files = file.listFiles();
        for (File obj:files) {
            if (obj.isDirectory()){
                ergodicFileAndGetEndWith(obj);
            }else {
                if (obj.getPath().endsWith(".txt")) {
                    //除了getPath,还可以getName=xxxx.txt(没有路径)
                    //f.toString,直接转为String类型
                    System.out.println(obj);
                }
            }
        }
    }

    private static void ergodicFileAndUseFilter(File file) { //使用过滤器来判断.txt结尾的文件
//        IOStream.File[] folder = file.listFiles(new FileFilterImpl()); //常规方法
        File[] folder = file.listFiles(     //使用lambda函数来写重写filter
                (/*IOStream.File*/ pathname)->/*{return*/ pathname.isDirectory() || pathname.getPath().endsWith(".txt")/*;}*/
        );      //

        for (File f:folder) {
            if (f.isDirectory()) {
                ergodicFileAndUseFilter(f);
            }else {
                System.out.println(f);                      //这个else必须加
            }
        }
    }


}
