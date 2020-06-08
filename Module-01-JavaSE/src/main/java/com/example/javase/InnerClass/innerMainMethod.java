package com.example.javase.InnerClass;

import java.util.ArrayList;
import java.util.List;

public class innerMainMethod {
    HeroClass heroClass;

    public static void main(String[] args) {
        Body body =  new Body();    //外部类的对象
        body.methodBody();      //通过外部类的对象，调用外部类的方法，间接使用内部类Heart

        Body.Heart heart = new Body().new Heart();//直接调用成员内部类
        heart.beat();

        Body.Outer outer = new Body().new Outer();//实例化外部类Body的内部类Outer
        outer.outerMethod();//调用实例化的outer中的方法outerMethod

        //======================================================================
        System.out.println("======================================================================");



        String heroname = "傻逼";
        int heroLevel = 18;
        String weaponName = "shit";
        int weaponAtk = -1;


        HeroClass hero = new HeroClass();       //实例化hero
        HerosWeapon weapon = new HerosWeapon(); //实例化weapon
        weapon.setWeaponName(weaponName);           //给weapon赋值
        weapon.setWeaponAtk(weaponAtk);

        hero.setHeroLevel(heroLevel);                  //给hero赋值
        hero.setHeroName(heroname);
        hero.setHerosWeapon(weapon);            //给heroWeapon赋值weapon
        //======================================================================

        //匿名内部类的用法
        HeroArmor heroArmor = new HeroArmor() { //实例化一个匿名的抽象方法
            @Override
            public void armorValue() {
                System.out.println(heroname+"'s armor = "+10);
            }
        };  //这里有个;
        heroArmor.armorValue(); //=10       //调用这个类

        //匿名方法调用接口
        new HeroArmor(){
            @Override
            public void armorValue() {
                System.out.println("now "+heroname+"'s armor = "+15);
            }
        }.armorValue(); //=15



        hero.attackAction();                    //调用atk动作

        //直接调用匿名内部类Skill
        new Skill(){

            @Override
            public void cast() {
                System.out.println(heroname+" cast somthing!");
            }
        }.cast();



        hero.deadMethod();                      //调用dead方法


        //======================================================================
        System.out.println("======================================================================");


        //接口也可以作为一个方法的 返回类型 和 参数类型
        List<String> list = new ArrayList<>();      //从ArrayList实现类 的 接口list 处，实例化集合list
        List result = addMethod(list);              //用result来接受方法addMethod的结果
        for (int i = 0; i < list.size(); i++) {     //历遍
            System.out.println(list.get(i));        //输入用list.get()
        }

    }
    public static List<String> addMethod(List<String> list){    //接口List作为返回类型 和 参数的方法
        list.add("frist");
        list.add("second");
        list.add("thrid");
        return list;
    }
}
