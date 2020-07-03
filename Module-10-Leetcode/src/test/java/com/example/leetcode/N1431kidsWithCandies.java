package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class N1431kidsWithCandies {

    @Test
    void testContext() {

    }

    /**
     * 儿童节特供
     * 给出数组candies,每个元素代表小朋友持有多少糖
     * extraCandies代表附加的糖
     * 如果小朋友得到附加的糖后,大于等于candies中最多糖持有数,则返回true,反之则false
     * 通过2次遍历实现
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        List<Boolean> res = new ArrayList<>();

        //获取数组中的最大值
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > max) max = candies[i];
        }

        //尝试比较
        for (int i = 0; i < candies.length; i++) {
            if (candies[i]+extraCandies>=max) res.add(true);
            else res.add(false);
        }

        return res;
    }
}