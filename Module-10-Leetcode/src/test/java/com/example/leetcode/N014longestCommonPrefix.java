package com.example.leetcode;

import org.junit.jupiter.api.Test;

public class N014longestCommonPrefix {


    /*查找一个字符串数组的公共前缀（前缀从第一个字符串开始）*/
    /*解法主要是利用了String.indexOf来巧妙的解决前缀问题*/

    @Test
    public void testContext(){
//        System.out.println("abc".indexOf("bc"));

        System.out.println(longestCommonPrefix(new String[]{"abcdefg", "abc", "abcd"}));


    }

    private String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)    return "";
        String prefix = strs[0];   /*将第一组字符串设为前缀*/
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(prefix) != 0)    /*当第二组(开始的)字符串与前缀进行匹配(indexOf)*/
                prefix = prefix.substring(0,prefix.length()-1);  /*如果不为0则删减前缀字符串的末尾(返回0表示从第0位开始与原字符串相同)*/
            i++;        /*当返回为0后,与下一组字符串进行匹配*/
        }
        return prefix;
    }



}
