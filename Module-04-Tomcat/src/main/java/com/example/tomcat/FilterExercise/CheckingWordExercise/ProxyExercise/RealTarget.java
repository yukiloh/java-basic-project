package com.example.tomcat.FilterExercise.CheckingWordExercise.ProxyExercise;

public class RealTarget implements TheirInterface {

    @Override
    public String showString(String s) {
        return "show "+s+" !";
    }

    @Override
    public void showMethod() {
        System.out.println("show!");
    }
}
