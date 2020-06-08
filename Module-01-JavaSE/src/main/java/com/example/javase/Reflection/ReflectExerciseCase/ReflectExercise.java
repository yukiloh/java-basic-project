package com.example.javase.Reflection.ReflectExerciseCase;


import com.example.javase.Reflection.Person_Ref;

import java.io.InputStream;
import java.util.Properties;

//创建一个框架,可以创建任意类的对象,并调用任意方法
public class ReflectExercise {
    public static void main(String[] args) throws Exception{
        //1.加载配置文件
        InputStream propStream = ReflectExercise.class.getClassLoader().getResourceAsStream("com/example/javabasic/Reflection/ReflectExerciseCase/Ref.properties");
        //代码解释:使用本类 类下的 类加载器 加载方法:getResourceAsStream,读取配置文件的字节流,
        // 配置文件路径可以复制相对路径relative path,绝对路径怎么在别的机器运行?

        Properties prop = new Properties(); //实例化prop对象,用来↓
        prop.load(propStream);              //读取流中的数据
                                            //并↓加载classname和method的内容
        //还记得properties的是用来读取字节的map型嘛...
        String classname = prop.getProperty("className");   //"  "←这地方名字不要写错了..
        String method = prop.getProperty("methodName");

        //2.使用反射加载类
        Class cls = Class.forName(classname);   //通过forName来加载类
        Person_Ref person_ref = new Person_Ref();   //实例化对象
        cls.getMethod(method).invoke(person_ref);   //通过getMethod获取method的名字,再invoke执行,传入对象

        //总结,所有的配置都是path,如果需要更改执行的方法或是类只需要从properties更改即可

    }
}


