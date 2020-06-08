package com.example.javase.Singleton;

/**
 * 内部类延迟单例
 * 对象通过内部静态的常量来实例化
 * 因为instance是静态常量,所以只能赋值一次,且随内部类一同生成
 * 对比懒汉式,静态内部类单例没有线程安全问题(不需要双锁)
 */
public class SingletonInner {

    private SingletonInner() {}
    private int id;         //加入一些其他参数作为测试
    private String name;

    @Override
    public String toString() {
        return "SingletonInner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    //对外提供实例的get方法
    public static SingletonInner getInstance(){
        return SingletonHolder.instance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //内部静态类,通过该内部类生成实例
    private static class SingletonHolder{
        private static SingletonInner instance = new SingletonInner();
    }

}
