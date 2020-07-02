package com.example.leetcode;

import org.junit.jupiter.api.Test;

public class N1385FindTheDistanceValue {

    @Test
    void testContext() {
        int[] arr1 = {1,4,2,3};
        int[] arr2 = {-4,-3,6,10,20,30};
        int d = 3;

        System.out.println(findTheDistanceValue(arr1, arr2, d));
    }

    /**
     * 给定2个数组,以及标准d,返回他们的距离值
     * 关于距离值: arr1 中符合要求的元素数量
     * 如果 arr1[i] - arr2 [j] <= d 则 arr1[i] 不符合条件
     * 原题的描述有点蠢
     */
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;

        //这里选择使用循环的tag,也可以创建一个flag来进行判断
        loop1:for (int i = 0; i < arr1.length; i++) {
            int num1 = arr1[i];

            for (int j = 0; j < arr2.length; j++) {
                int num2 = arr2[j];
                if (Math.abs(num1-num2)<=d) continue loop1;
            }
            count++;
        }

        return count;
    }

}