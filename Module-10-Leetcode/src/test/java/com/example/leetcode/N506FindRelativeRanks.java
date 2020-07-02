package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class N506FindRelativeRanks {

    @Test
    void testContext() {
        int[] arr={10,23,42,12,20,6};
        System.out.println(Arrays.toString(findRelativeRanks(arr)));

    }

    /**
     * 给定一个包含分数元素的数组(越高排名越优),处理后返回代表名次的字符串数组,前三替换为换金银铜牌
     * 例如: [5, 4, 3, 2, 1] → ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
     *
     * 思路:
     * 创建一个保存分数的数组site
     * 然后排序原来的数组arr
     * 再倒序遍历(因为排序后是顺序排列),输出到结果集String[]中
     * 因为保存了分数的坐标,所以可以通过site来获取原来数组的位置
     * 结果的第[j]即site[arr[arr.length-i]
     */
    private String[] findRelativeRanks(int[] nums) {
        String[] res = new String[nums.length];

        // 特殊情况进行处理
        if(nums.length == 1) {
            res[0] = "Gold Medal";
            return res;
        }
        if(nums.length == 2) {
            if(nums[0] > nums[1]) {
                res[0] = "Gold Medal";
                res[1] = "Silver Medal";
            } else {
                res[1] = "Gold Medal";
                res[0] = "Silver Medal";
            }
            return res;
        }

        // 找出最大元素
        int max = nums[0];
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
            }
        }

        // 创建一个数组,储存元素的下标
        int[] site = new int[max + 1];
        for(int i = 0; i < nums.length; i++) {
            site[nums[i]] = i;
        }

        // 数组升序排列,可以直接调用官方的api(快排)
        Arrays.sort(nums, 0, nums.length - 1);

        // 将名次存入数组中
        res[site[nums[nums.length - 1]]] = "Gold Medal";
        res[site[nums[nums.length - 2]]] = "Silver Medal";
        res[site[nums[nums.length - 3]]] = "Bronze Medal";
        int rank = nums.length;
        for(int i = 0; i < nums.length - 3; i++) {
            res[site[nums[i]]] = String.valueOf(rank);
            rank--;
        }
        return res;
    }
}