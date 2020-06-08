package com.example.javase.LeetCode;

import org.junit.Test;

import java.util.TreeMap;

public class Other02SortString {
    /*
    * 判断字符串，进行分割，将结果排序（TreeMap）
    * */


    @Test
    public void testContext() {
        String s = "11一一121一二一65六五1一";
        int i = 0;
        boolean isHanzi = false;
        StringBuffer value = new StringBuffer();
        StringBuffer key = new StringBuffer();
        TreeMap<Integer, String> map = new TreeMap<>();

        key.append(s.charAt(i));
        i++;
        while (i < s.length()){        //loop start
            if (s.charAt(i) < 57){     //为数字时
                if (isHanzi) {
                    /*如前个为汉字，放入集合*/
                    map.put(Integer.parseInt(key.toString()),value.toString());
                    isHanzi = false;
                    key.delete(0,key.length());
                    value.delete(0,value.length());
                }
                key.append(s.charAt(i));
            }else {         /*为汉字时*/
                if (!isHanzi) isHanzi = true;
                value.append(s.charAt(i));
            }                           //loop end
            i++;
        }
        map.put(Integer.parseInt(key.toString()),value.toString());
        System.out.println(map.toString());
    }

}
