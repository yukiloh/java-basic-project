package Enum;

/*Enum的类，可以理解为定义一个类，且该类继承了Enum；
（原始的）Enum类中的构造方法只可以被自己和子类调用*/
public enum     TestEnum {
    A("a"),     /*可以理解为这是一个对象，且给定，无法更改*/
    B("b"),
    C("c"),
    D("d"),
    E("e");

    /*为枚举对象提供一个String类型的参数 key*/
    private String key;

    /*构造函数*/
    private TestEnum(String key) {  /*与其他构造函数不同，Enum的构造函数的关键词为私有*/
        this.key = key;
    }
    /*并提供get、set方法*/
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

//    枚举也是一个类，也可以实现接口，或者添加抽象类（代码省略）
}
