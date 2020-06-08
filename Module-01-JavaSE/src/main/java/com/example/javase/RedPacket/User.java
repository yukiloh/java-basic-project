package com.example.javase.RedPacket;

public class User {//父类 用户，有姓名，余额
    private String userName;
    private int wallet;

    public User() {
    }

    public User(String userName, int wallet) {
        this.userName = userName;
        this.wallet = wallet;
    }

    public String getUserName() {
        return userName;
    }

    public int getWallet() {
        return wallet;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setWallet(int wallet) {
        this.wallet = wallet;
    }

    public void show(){
        System.out.println("name:  "+userName+"   wallet:   "+wallet);
    }
}
