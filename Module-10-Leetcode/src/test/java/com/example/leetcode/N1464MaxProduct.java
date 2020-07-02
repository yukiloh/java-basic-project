package com.example.leetcode;

import org.junit.jupiter.api.Test;

/**
 * @author yukiloh
 * @version 0.1
 * @date 2020/7/2 14:09
 */
public class N1464MaxProduct {

    @Test
    void testContext() {
        int[] ints = {1,2,3,4,5};
        System.out.println(maxProduct(ints));
    }

    /**
     * 给与整数的数组
     * 求最大的2个数
     * 并求 num[i]-1 * num[j]-1 的结果
     * 解题思路:
     * 设2个最大数max1,max2,并约定max2一定大于等于max1
     * 如果当前值i>max1,则判断i是否大于max2
     * 如果是则将i赋值给max2(并把此时的max2赋值给max1)
     * 如果不是则赋值给max1
     */
    public int maxProduct(int[] nums) {
        //java中,数组的上限为int,即2^31-1
        if (nums.length >= 2) {
            //初始化2个最大值,其中i<=j
            int i = 0,j = 0;

            //leetcode显示,fori比for慢
            for (int o =0;o < nums.length;o++) {
                int num = nums[o];
                if (num>i) {
                    if (num>j) {
                        i = j;
                        j = num;
                    }else i = num;
                }
            }
            return (i-1)*(j-1);
        }
        return 0;
    }
}
