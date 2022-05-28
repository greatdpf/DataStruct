package com.staring.tree;


/**
 * className： BinaryTree
 * description：
 * createDate： 2022/5/28
 * @author staring
 */
public class Tree {
    /**
     * 树节点
     */
    static class TreeNode {
        // 左子树
        TreeNode left;
        // 右子树
        TreeNode right;
        // 数据
        int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    /**
     * 先序遍历
     */
    public static void pre(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        pre(node.left);
        pre(node.right);
    }

    /**
     * 中序遍历
     */
    public static void mid(TreeNode node) {
        if (node == null) {
            return;
        }
        mid(node.left);
        System.out.print(node.data + " ");
        mid(node.right);
    }

    /**
     * 后续遍历
     */
    public static void last(TreeNode node) {
        if (node == null) {
            return;
        }
        mid(node.left);
        mid(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        node1.right = node3;
        node1.left = node2;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node4.left = node7;
        node5.right = node8;
        node6.left = node9;
        node6.right = node10;
        pre(node1);
    }




}
