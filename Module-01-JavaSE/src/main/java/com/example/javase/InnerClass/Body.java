package com.example.javase.InnerClass;

public class Body {

    private String name;
    //===========================================================
    //Body的构造函数
    public Body() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void methodBody(){
        new Heart().beat();//匿名对象

    }
    //============================================================
    public class Heart{
        //内部类

        public void beat() {
            //内部方法
            System.out.println("beat!");
        }
    }
    //============================================================
    public class Outer{
        public void outerMethod() {
            class Inner{
                public void innerMethod(){
                    System.out.println("Inner Method!");
                }
            }
            Inner inner = new Inner();
            inner.innerMethod();
        }
    }
}
