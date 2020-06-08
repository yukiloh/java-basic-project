package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

public class N001TwoSum {

    @Test
    public void twoSum(){
        /*给定一个target,判断数组内是哪2个数字之和,返回2数的位置*/
        /*解题思路:判断当前数需求值(与target的差值),在map中查找该当的key,若存在则返回位置;会进行完整遍历*/
        Integer target = 17;
        int[] nums= {1,2,3,4,5,6,7,10,17,0};

        /*建议需要做以下非空判断*/
        if (nums == null || nums.length == 0) return ;

        int position = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i:nums) {
            map.put(i,position+1000);   /*+1000是为了区分key*/
            position++;
            Integer requiredNumber = target - i;
            Integer key = map.get(requiredNumber);
            if (key != null) {
                System.out.println("target: "+target);
                System.out.println("list: "+ Arrays.toString(nums));                /*通过Arrays.toString打印数组*/
                System.out.println("number1: "+i+"  index: "+map.get(i));
                System.out.println("number2: "+requiredNumber+"  index: "+key);
//                System.out.println(map.keySet());                                 /*keySet获取的是key*/
            }
        }

    }
}
