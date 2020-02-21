package RandomText;

public class Student {
    //一个标准的Java类的4个部分
    //1.声明的成员变量为private
    //2.有一个无参的构造函数
    //3.有一个全参的构造函数
    //4.为每一个成员变量提供set/get方法

    private String name;
    private int age;

//    public Student() {
//    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
