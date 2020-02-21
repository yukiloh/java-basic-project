package InnerClass;

public class HeroClass {    //hero类 内含成员变量name、level、weapon
    private String heroName;
    private int heroLevel;
    private HerosWeapon herosWeapon;

    public HeroClass(Skill skill) {
        this.skill = skill;
    }

    private Skill skill;

    public HerosWeapon getHerosWeapon() {
        return herosWeapon;
    }

    public void attackAction(){     //调用attack动作                调用weapon的useWeapon函数（String）
        System.out.println("Level "+heroLevel+" "+heroName+" use "+herosWeapon.useWeapon()+" attacked ");
    }

    public void deadMethod(){
        HeroDead heroDead = new HeroDead();
        System.out.println(heroName+heroDead.getDead());
    }

    public void setHerosWeapon(HerosWeapon herosWeapon) {
        this.herosWeapon = herosWeapon;
    }

    public HeroClass(HerosWeapon herosWeapon) {
        this.herosWeapon = herosWeapon;
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
