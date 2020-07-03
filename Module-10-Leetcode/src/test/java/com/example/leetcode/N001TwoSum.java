package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class N001TwoSum {

    /**
     * 给定一个target,判断数组内是哪2个数字之和,返回2数的位置.数字无法重复使用
     * 解题思路:
     * 遍历数组,检查当前元素与target的差值,如果在map中存在则返回元素的位置和map中的位置
     * 没有则存入map中(key:元素位置,val:元素的值)
     * 会进行完整遍历,时间O(n)
     */
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
