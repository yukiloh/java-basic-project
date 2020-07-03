package com.example.leetcode;

import org.junit.jupiter.api.Test;

public class N100IsSameTree {

    @Test
    void testContext() {

    }

    /**
     * 判断2棵树是否相同
     * 采用递归解决
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //将2个节点互相比较
        if (p==null && q==null) return true;        //2个都是null,直接返回true
        if (p==null || q==null) return false;       //只有1个是null,返回false

        if (p.val!=q.val) return false;             //比较2个值,不同则返回false

        //如果相同,则继续递归
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}