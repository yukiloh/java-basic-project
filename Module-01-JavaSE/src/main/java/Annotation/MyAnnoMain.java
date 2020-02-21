package Annotation;

import Reflection.Person_Ref;

//一个解析（使用）注解的练习，通过调用注解中的类名和方法名，实现方法的调用
@MyAnno(className = "Annotation.DemoMethod",methodName = "show")
public class MyAnnoMain {
    public static void main(String[] args) throws Exception {

        //1.解析注释（调用注释中的2个属性）
            //正常代码
//        Class<MyAnnoMain> myAnnoMainClass = MyAnnoMain.class;     //读取类文件
//        MyAnno annotation = myAnnoMainClass.getAnnotation(MyAnno.class);      //从类文件中通过getA方法读取其中的注解
//        String className = annotation.className();        //再从注解中读取类名
//        String methodName = annotation.methodName();      //和方法名

            //匿名表达式
        String className = MyAnnoMain.class.getAnnotation(MyAnno.class).className();
        String methodName = MyAnnoMain.class.getAnnotation(MyAnno.class).methodName();
        System.out.println(className+methodName);

            //正常代码
//        Class cls = Class.forName(className);   //通过forName来加载类，这个类不是本类！
        DemoMethod demoMethod = new DemoMethod();       //实例化对象
//        cls.getMethod(methodName).invoke(demoMethod);     //从类中get方法名并执行

        Class.forName(className).getMethod(methodName).invoke(demoMethod);      //匿名表达式写法

        //通过类读取加载的类文件，再从类get其中的方法，最后传入对象、执行



    }

}
