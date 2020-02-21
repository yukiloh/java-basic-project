package Method;

public class Person {
    //成员变量
    String name;        //自己的名字
    private int age;

    public void sayHello(String name) {
        System.out.println(name+" hello,i am "+this.name);
        //关于this，当需要访问当前类下的成员变量时，this.成员变量
        //如果不加则根据就近原则访问方法下的变量name
        //因为this只调用成员变量，所以只应出现在方法中
    }
    public Person(){        //创建构造方法
                            //构造方法与类名相同，无返回值，可重载
        System.out.println("构造方法");
    }
    public Person(int age){
        System.out.println("无参构造方法");
        System.out.println(age);
    }

}
