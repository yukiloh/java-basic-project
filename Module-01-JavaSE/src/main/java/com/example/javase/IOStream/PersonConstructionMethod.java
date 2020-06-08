package com.example.javase.IOStream;

import java.beans.Transient;
import java.io.NotSerializableException;

public class PersonConstructionMethod extends NotSerializableException {

    private int Bust;
    private int Waist;
    private int hip;

    private String name;
    private int stature;    //身高
    private int age;
    private transient String sex;    //瞬时关键词，隐藏了sex关键词不写入文件
//    private static final long serialVersionUID = 100L;        //可以自定义序列号,注意名称

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PersonConstructionMethod(String name, int stature, int age,String sex) {
        this.name = name;
        this.stature = stature;
        this.age = age;
        this.sex = sex;
    }


    // 不同于关键词transient,@Transient只能作用于方法(官方推荐放在get上)
    // 该方法所对应的真值(属性)当被编码器导出时(测试了向前端导出json),该真值会被忽视
    // 原文:A true value for the "transient" attribute indicates to encoders derived from Encoder that this feature should be ignored.
    @Transient
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStature() {
        return stature;
    }

    public void setStature(int stature) {
        this.stature = stature;
    }



    public PersonConstructionMethod() {
    }
}
