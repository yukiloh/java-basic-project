package com.example.javase.Annotation.AnnoCheckCase;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})     //适用于类
@Retention(RetentionPolicy.RUNTIME)     //保留至运行状态
public @interface CheckAnno {
}
