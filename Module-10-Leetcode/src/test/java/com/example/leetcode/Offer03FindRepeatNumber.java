package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class Offer03FindRepeatNumber {

    @Test
    void testContext() {
    }

    /**
     * 如果对时间有要求就拿set做
     * 如果对空间有要求有2种做法
     * 1.可以通过排序后检查相邻2个数是否相同
     * 2.原地置换
     */

    //set的做法
    public int findRepeatNumber01(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            boolean add = set.add(num);
            if (!add) return num;
        }
        return -1;
    }

    //利用数据结构的特性进行原地置换
    //因为int[]的length长度为int的范围(2^31-1)
    //检查nums[i] == i,不相等则进行置换,如果置换后 nums[i] == nums[nums[i]] ,则表示有重复,抛出重复数字
    public int findRepeatNumber02(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {                  //如果当前下表和对应数字不相等,则准备置换
                if (nums[i] == nums[nums[i]])       //当前下标对应的数值,和置换后所在的位置数值,如果相等则表示已经置换,存在重复
                    return nums[i];

                int temp = nums[i];                 //进行置换
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
