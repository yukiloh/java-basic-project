package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class N013RomanToInt {


    @Test
    public void testContext00(){
        System.out.println(romanToInt("XII"));
    }



    public int romanToInt(String s) {
        if(s==null || s.length() == 0){return 0;}

        // 用HashMap去存储罗马数与数字之间的关系
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X', 10);
        map.put('L',50);
        map.put('C',100);
        map.put('D', 500);
        map.put('M',1000);

        /*手动获取第一个罗马数字*/
        int num = map.get(s.charAt(0));

        for(int i=1;i<s.length();i++){
            if(map.get(s.charAt(i)) <= map.get(s.charAt(i-1))){
                //如果小等于前一个数字，则加
                num += map.get(s.charAt(i));
            }else{
                //减去上一个循环中多加的数字
                num = num - 2*map.get(s.charAt(i-1)) + map.get(s.charAt(i));
            }
        }
        return num;
    }

}
