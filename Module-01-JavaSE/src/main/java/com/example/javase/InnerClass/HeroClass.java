package com.example.javase.InnerClass;

public class HeroClass {    //hero类 内含成员变量name、level、weapon
    private String heroName;
    private int heroLevel;
    private HeroWeapon heroWeapon;

    public HeroClass(Skill skill) {
        this.skill = skill;
    }

    private Skill skill;

    public HeroWeapon getHeroWeapon() {
        return heroWeapon;
    }

    public void attackAction(){     //调用attack动作                调用weapon的useWeapon函数（String）
        System.out.println("Level "+heroLevel+" "+heroName+" use "+ heroWeapon.useWeapon()+" attacked ");
    }

    public void deadMethod(){
        HeroDead heroDead = new HeroDead();
        System.out.println(heroName+heroDead.getDead());
    }

    public void setHeroWeapon(HeroWeapon heroWeapon) {
        this.heroWeapon = heroWeapon;
    }

    public HeroClass(HeroWeapon heroWeapon) {
        this.heroWeapon = heroWeapon;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public int getHeroLevel() {
        return heroLevel;
    }

    public void setHeroLevel(int heroLevel) {
        this.heroLevel = heroLevel;
    }

    public HeroClass() {
    }
}
