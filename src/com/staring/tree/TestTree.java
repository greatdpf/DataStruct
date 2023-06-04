package com.staring.tree;


import java.util.Stack;

/**
 * className： BinaryTree
 * description：
 * createDate： 2022/5/28
 * @author staring
 */
public class TestTree {
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
     * 递归序
     * @param node
     */
    public static void show(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        show(node.left);
        System.out.print(node.data + " ");
        show(node.right);
        System.out.print(node.data + " ");
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
     * 非递归实现先序遍历
     */
    public static void pre1(TreeNode node) {
        // 1. 先压入头节点到栈中；
        // 2. 取出第一个节点，打印；
        // 3. 再将其右子树压入栈，再将其左子树压入栈；(一定是先右后左，因为栈是后进先出，所以先打印左，再打印右)
        // 4. 重复第二个步骤；
        // 头 左 右
        // 定义一个栈
        Stack stack = new Stack();
        stack.push(node);
        // 循环
        while (!stack.empty()) {
            TreeNode head = (TreeNode)stack.pop();
            System.out.print(head.data + " ");
            // 需要判断是否为空，因为栈可以压入 null 元素
            if (head.right != null ) {
                // 压入右子树
                stack.push(head.right);
            }
            if (head.left != null) {
                // 压入左子树
                stack.push(head.left);
            }

        }



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
        System.out.println();
        pre1(node1);
        System.out.println();
        show(node1);
        System.out.println();
    }




}
