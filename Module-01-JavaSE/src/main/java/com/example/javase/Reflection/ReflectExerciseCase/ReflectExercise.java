package com.example.javase.Reflection.ReflectExerciseCase;


import com.example.javase.Reflection.Person_Ref;

import java.io.InputStream;
import java.util.Properties;

//创建一个框架,可以创建任意类的对象,并调用任意方法
public class ReflectExercise {
    @SuppressWarnings("unchecked")  //压制警告
    public static void main(String[] args) throws Exception{
        //1.加载配置文件,通过类加载器下的方法getResourceAsStream来读取配置文件的字节流(一般不推荐读取绝对路径)
        InputStream propStream = ReflectExercise.class.getClassLoader().getResourceAsStream("file.properties");
        //原案例没有使用maven,直接按项目路径去读
//        InputStream propStream = ReflectExercise.class.getClassLoader().getResourceAsStream("com/example/javabasic/Reflection/ReflectExerciseCase/Ref.properties");

        if (propStream!=null) {
            //实例化prop对象,读取流中数据,并↓加载classname和method的内容
            Properties prop = new Properties();
            prop.load(propStream);

            //按属性名读取值
            String classname = prop.getProperty("className");
            String method = prop.getProperty("methodName");

            //2.使用反射加载类
            Class cls = Class.forName(classname);               //通过forName来加载prop中的类名,来获取对象cls
            cls.getMethod(method).invoke(new Person_Ref());     //通过getMethod加载prop中method的名称,再通过invoke执行方法invoke
                                                                //需要传入对象所执行的对象Person_Ref

            //总结,所有的配置都是path,如果需要更改执行的方法或是类只需要从properties更改即可
        }else System.out.println("prop is null");
    }
}


