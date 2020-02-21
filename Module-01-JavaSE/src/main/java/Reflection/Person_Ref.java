package Reflection;

import Method.Person;

public class Person_Ref {
    public String namee;
    public String nameee;
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person_Ref{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person_Ref(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person_Ref() {
    }

    public void Person_Do(){
        System.out.println("do!");
    }
    public void Person_DoMore(String thing){
        System.out.println("do!"+thing);
    }
}
