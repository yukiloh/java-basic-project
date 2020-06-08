package com.example.javase.LeetCode;

import org.junit.Test;

import java.util.*;

public class N136singleNumber {
    /*判断一个数组的不重复数字,返回那个不重复的数字(只会出现2次)*/


    @Test
    public void testContext() {
//        int[] ints= {1,1,2,2,3};
//        System.out.println(singleNumber(ints));

        int[] ints2= {1,1,1,2,2,2,3};
        System.out.println(singleNumberII(ints2));



//        int result = 2 ^ 2;
//        System.out.println(result);
    }

    private int singleNumber(int[] nums) {
        HashSet<Integer> integers = new HashSet<>();
        for (int num : nums) {
            if (!integers.add(num)) integers.remove(num);   /*如果存入失败,则已经存入,删除该元素*/
        }
        return integers.iterator().next();
    }

    /*通过位运算,二进制下 111 ^ 111 = 0*/
    private int singleNumber2(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result ^= i;
        }
        return result;
    }

    /*看不懂*/
    private int singleNumberII(int[] nums) {
        int len = nums.length, result = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int j = 0; j < len; j++) {
                sum += (nums[j] >> i) & 1;
            }
            result |= (sum % 3) << i;
        }
        return result;
    }


}




