package com.example.javase.RedPacket;

import java.util.ArrayList;

public class MainClass {


    public static void main(String[] args) {
        //创建一个群主
        GroupMaster groupMaster = new GroupMaster("狗群主",1000);

        //创建若干群员
        GroupMember groupMember1 = new GroupMember("狗群员A",0);
        GroupMember groupMember2 = new GroupMember("狗群员B",0);
        GroupMember groupMember3 = new GroupMember("狗群员C",0);
        GroupMember groupMember4 = new GroupMember("狗群员D",0);
        GroupMember groupMember5 = new GroupMember("狗群员E",0);


        //显示每个成员的姓名、钱包余额
        groupMaster.show();
        groupMember1.show();
        groupMember2.show();
        groupMember3.show();
        groupMember4.show();
        groupMember5.show();

        System.out.println("============================");

        //开始发红包
        ArrayList<Integer> arrayList = groupMaster.sendRedPacket(200,7);
        groupMember1.receiveRedPacket(arrayList);
        groupMember2.receiveRedPacket(arrayList);
        groupMember3.receiveRedPacket(arrayList);
        groupMember4.receiveRedPacket(arrayList);
        groupMember5.receiveRedPacket(arrayList);


        //展示结果
        groupMaster.show();
        groupMember1.show();
        groupMember2.show();
        groupMember3.show();
        groupMember4.show();
        groupMember5.show();
    }
}
