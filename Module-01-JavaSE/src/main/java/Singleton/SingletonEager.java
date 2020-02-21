package Singleton;

public class SingletonEager {


    /*饿汉-立即加载*/
    /*步骤：
    * 定义一个类，构造函数为私有；存在静态私有变量；*/
    private static SingletonEager instance = new SingletonEager();  /*静态私有变量*/
    private SingletonEager() {};                                    /*构造函数为私有*/

    public static SingletonEager getInstance() {                    /*提供方法*/
        return instance;
    }


    /*添加的测试变量*/
    private Integer integer = 0;

    public Integer getInteger() {
        return integer;
    }
    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    /*单例一般，一个类中只有一个实例存在*/
}




