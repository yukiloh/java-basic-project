package com.example.javase.InnerClass;

public class HeroDead {
    private String dead;

    public String getDead() {
        dead = " dead!, put into Tcinerary Casket with Diamond";
        return dead;
    }

    public void setDead(String dead) {
        this.dead = dead;
    }

    public HeroDead(String dead) {
        this.dead = dead;
    }

    public HeroDead() {
    }
}
