package Annotation.AnnoCheckCase;


import java.io.*;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;

//通过注解CheckTest，检测MethodNeedCheck类的方法有无异常
public class CheckTestMain {
    public static void main(String[] args) throws IOException {

        //如果方法上有@CheckAnno，则运行，并打印错误日志
        //1.创建对象
        MethodNeedCheck methodNeedCheck = new MethodNeedCheck();
        //2.获取字节码文件对象
        Class<? extends MethodNeedCheck> clazz = methodNeedCheck.getClass();

        //3.获取所有方法
            //先创建字符读取，貌似需要用字符流读取否则会出现乱码？
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("bug.txt"), StandardCharsets.UTF_8));
        int count = 0;      //统计bug出现的次数
        for (Method method : clazz.getMethods()) {
            //4.如果有check注释
            if (method.isAnnotationPresent(CheckAnno.class)){       //isAnnotationPresent:指定的方法是否添加了指定的注解
                try {
                    //则执行
                    method.invoke(methodNeedCheck);
                } catch (Exception e) {
                    //5.如果出现异常则捕获并写入
                    bufferedWriter.write("Exception: "+method.getName());
                    bufferedWriter.newLine();               //真实原因  获取字节码       获取简短类名
                    bufferedWriter.write("Exception name: "+e.getCause().getClass().getSimpleName());
                    bufferedWriter.newLine();
                    bufferedWriter.write("Exception reason: "+e.getCause().getMessage());
                    bufferedWriter.newLine();
                    count++;
                }
            }
        }
        bufferedWriter.write("count: "+count);
        bufferedWriter.flush();     //最后记得关闭流
        bufferedWriter.close();
    }
}
