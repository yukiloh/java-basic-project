package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class N119PascalsTriangleII {
    /*杨辉三角,帕斯卡三角
    * 输入： 3
      输出： [1,3,3,1] */

    @Test
    public void testContext() {
        System.out.println(getRow1(4));

    }

    //方法1,通过循环算出,原理:
    //1.每一次遍历都在list尾部加一个元素 1 ,例如 [1,2,1]→[1,2,1,1]
    //2.从尾部第n-1开始倒叙遍历,让n-1 = n-1 + n-2 ,例如[1,2,1,1]→[1,2,3,1]
    //3.一直遍历到第二位
    public List<Integer> getRow1(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i <= rowIndex; i++) {            //rowIndex = 2,3...
            res.add(1);
            for(int j = i-1; j > 0; j--) {              //j = 1,2...
                /*插入第i-1位的元素,赋值i-2 + i-1*/  /*等同于对上一列进行相加计算*/
                res.set(j, res.get(j-1) + res.get(j));  //设置第1位,为第0位+第1位;设置第2位,为第1位+第2位...
            }
        }
        return res;
    }

    //方法2:通过二项式定理
    //因为 C(n,m) = n!/(m!*(n-m)!),则推出 第m+1项=第m项 * (n-1)/(m+1)
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        long cur = 1;
        for (int i = 0; i <= rowIndex; i++) {
            res.add((int) cur);
            cur = cur * (rowIndex-i)/(i+1);
        }
        return res;
    }
}
