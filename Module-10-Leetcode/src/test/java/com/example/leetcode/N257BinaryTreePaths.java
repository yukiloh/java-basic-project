package com.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

public class N257BinaryTreePaths {

    @Test
    void testContext() {
        TreeNode node1 = new TreeNode(10);

        TreeNode node2 = new TreeNode(11);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(2);
        TreeNode node7 = new TreeNode(8);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.right = node7;

        System.out.println(binaryTreePaths(node1).toString());
    }

    /**
     *
     */
    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> paths = new LinkedList<>();
        buildPath(root, "", paths);
        return paths;
    }

    private void buildPath(TreeNode root, String path, LinkedList<String> paths) {
        if (root != null) {
            //当前节点不为空,则添加当前的节点至路径
            path += Integer.toString(root.val);

            // 当前节点是叶子节点,把路径加入到答案中
            if (root.left == null && root.right == null) paths.add(path);
            else{
                // 当前节点不是叶子节点，继续递归遍历
                path += "->";
                buildPath(root.left, path, paths);
                buildPath(root.right, path, paths);
            }
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}