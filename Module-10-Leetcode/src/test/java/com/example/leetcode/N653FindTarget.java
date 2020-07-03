package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class N653FindTarget {

    @Test
    void testContext() {

    }

    /**
     * 给定一个二叉搜索树(BSF,满足 左节点 < 当前节点 < 右节点 ),求是否存在2个节点之和等于k
     * 思路:
     * 遍历整个树,存入set中,检查是否存在有2个节点相加后等于k
     */
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return find(root,k,set);
    }

    private boolean find(TreeNode root, int k, HashSet<Integer> set) {
        if (root==null) return false;

        //通过set遍历,找到则返回true
        if (set.contains(k-root.val)) return true;

        //没找到则添加至set中
        set.add(root.val);

        //继续进行递归
        return find(root.left, k, set) || find(root.right, k, set);
    }

    //BSF参考
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}

