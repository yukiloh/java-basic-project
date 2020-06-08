package com.example.javase.Annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//定义类名和方法名，提供给类调用
@Target({ElementType.TYPE})     //适用于类
@Retention(RetentionPolicy.RUNTIME)     //保留至运行状态
public @interface MyAnno {
    String className();
    String methodName();
}
