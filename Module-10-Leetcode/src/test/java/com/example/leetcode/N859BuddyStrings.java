package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class N859BuddyStrings {

    @Test
    void testContext() {

        int i = 1;
        int j = 1;
        i++;
        ++j;
        System.out.println(i);
        System.out.println(j);

//        System.out.println(buddyStrings("aa", "aa"));

    }

    /**
     * 交换A中的2个字母,如果可以得到B,则返回true,反之则false
     *
     * 思路:
     * 1,当字符串长度不相等，数组长度小于2，的情况下会返回false
     * 2,当字符串长度大于2，且完全相同时，如果字符串存在重复字符，会返回true
     * 3.当字符串不相同的字符非2时，返回false
     * 4,当字符串不相同字符对为2时，且交叉相同时，返回true
     */
    public boolean buddyStrings(String A, String B) {
        //1.AB长度不同,或A(B)长度小于2的,都返回false
        if (A.length() != B.length() || A.length() < 2) return false;

        //如果AB相同,且存在相同字符,则返回true(ab和ab返回false,但aab和aab返回true)
        if (A.equals(B)) {
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < A.length(); i++) {
                if (set.contains(A.charAt(i)))
                    return true;
                else
                    set.add(A.charAt(i));
            }
            return false;
        }

        //如果AB不同,则进行判断
        int count = 0;
        int first = -1, second = -1;            //记录2个不同字符的位置
        for (int i = 0; i < A.length(); i++) {

            //不同的字符大于2时返回false
            if (count > 2) return false;

            //如果不相同则i++
            if (A.charAt(i) != B.charAt(i)) {
                count++;
                //并记录位置,first记过了则记second
                if (first == -1)
                    first = i;
                else
                    second = i;
            }

        }
        //最后遍历结束,返回交换的结果
        return count == 2 && A.charAt(first) == B.charAt(second) && A.charAt(second) == B.charAt(first);

    }
}