package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class N1089DuplicateZeros {

    @Test
    void testContext() {

    }

    /**
     *  复写给定数组中的所有0,但复写前后数组长度不发生改变.要求不使用额外的空间
     */
    public void duplicateZeros(int[] arr) {
        int count = 0;
        int len = arr.length;
        int i = 0;

        // 统计需要复制的0的个数count,若i+count大于原数组长度,则舍弃后面的部分
        while (i + count < len) {
            if (arr[i++] == 0) count++;
        }

        i--;    //减去循环中多余的++

        // 再从尾到头遍历
        int j = len - 1;
        // 需要先处理特殊情况
        // 如果末尾数字是0,则可能发生数组越界
        // 因此需要+1来判断是否大于len,如果超过则只复制1最后那位1次

        if (count + i + 1 > len) {
            arr[j--] = arr[i--];
            count--;
        }
        // 遇0则复制两次,非0则复制本身.当count=0时结束遍历,这之前的数字不需要改动
        while (count > 0) {
            arr[j--] = arr[i];
            if (arr[i] == 0) {
                arr[j--] = arr[i];
                count--;
            }
            i--;
        }
    }

}