package com.example.javase.InnerClass;

public class HerosWeapon {  //weapon类
    private String weaponName;
    private int weaponAtk;

    public String getWeaponName() {
        return weaponName;
    }

    public String useWeapon(){      //return 一个string 包含weapon name 和 weapon atk数值
        String usewep = getWeaponName()+"(atk:"+getWeaponAtk()+")";
        return  usewep;
    }


    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public int getWeaponAtk() {
        return weaponAtk;
    }

    public void setWeaponAtk(int weaponAtk) {
        this.weaponAtk = weaponAtk;
    }

    public HerosWeapon(String weaponName, int weaponAtk) {
        this.weaponName = weaponName;
        this.weaponAtk = weaponAtk;
    }

    public HerosWeapon() {
    }
}
