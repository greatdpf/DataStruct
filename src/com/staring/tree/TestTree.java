package com.staring.tree;


import java.util.ArrayDeque;
import java.util.Queue;
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
     * 二叉树的广度优先遍历（层遍历）：从上往下，从左往右
     * 1. 定义一个队列
     * 2. 将根节点压入
     * 3. 从队列中取出一个节点，打印
     * 4. 将此节点的左孩子压入队列中，在将其有孩子压入队列中
     * 5. 重复步骤3，直到队列为空；
     *
     */
    public static void breadthFirstTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(node);
        while (!arrayDeque.isEmpty()) {
            TreeNode newNode = (TreeNode) arrayDeque.poll();
            System.out.print(newNode.data + " ");
            if (newNode.left != null) {
                arrayDeque.add(newNode.left);
            }
            if (newNode.right != null) {
                arrayDeque.add(newNode.right);
            }
        }


    }

    /**
     * 先序遍历： 头 左 右
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
     * 1. 先压入根节点到栈中；栈中内容： 头 左 右
     * 2. 取出第一个节点，打印；
     * 3. 再将其右子树压入栈，再将其左子树压入栈；(一定是先右后左，因为栈是后进先出，所以先打印左，再打印右)
     * 4. 重复第二个步骤；
     * 头 左 右
     */
    public static void pre1(TreeNode node) {
        if (node == null) {
            return;
        }
        // 定义一个栈
        Stack stack = new Stack();
        // 压入根节点
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
     * 中序遍历 左 头 右
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
     * 中序遍历非递归实现方式：
     * 1. 先创建一个栈
     * 2. 将当前节点以及当前节点的左子树全部压入栈中，直到左子树为null；
     * 3. 弹出节点，并且将此节点打印，且将此节点的右子树作为当前节点
     * 4. 重复步骤 2；
     *
     */
    public static  void mid2(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack stack = new Stack();
        TreeNode current = node;
        while (current != null || !stack.empty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode treeNode = (TreeNode) stack.pop();
                System.out.print(treeNode.data + " ");
                if (treeNode.right != null) {
                    current = treeNode.right;
                }
            }
        }
    }

    public static  void mid1(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack stack = new Stack();
        stack.push(node);
        TreeNode head = node;
        while (head.left != null) {
            stack.push(head.left);
            head = head.left;
        }
        while (!stack.empty()) {
            TreeNode treeNode = (TreeNode) stack.pop();
            System.out.print(treeNode.data + " ");
            if (treeNode.right != null) {
                stack.push(treeNode.right);
                TreeNode newNode = treeNode.right;
                while (newNode.left != null) {
                    stack.push(newNode.left);
                    newNode = newNode.left;
                }
            }
        }
    }

    /**
     * 后续遍历： 左 右 头
     *
     */
    public static void last(TreeNode node) {
        if (node == null) {
            return;
        }
        last(node.left);
        last(node.right);
        System.out.print(node.data + " ");
    }

    /**
     * 后续遍历非递归方式实现：
     * 1. 先定义一个栈：栈中内容：头 左 右  -> 头 右 左 -> 左 右 头
     * 2. 先把根节点压入栈中
     * 3. 弹出第一个节点，不打印
     * 4. 将取出的节点的左子树压入堆中，再将右子树压入堆中（先取出右子树，在取出左子树）
     * 5. 最后将此节点放入第二个堆中。
     * 6. 重复第3个步骤，直到堆中无元素。
     * 7. 依次弹出第二个堆中的元素，并打印；
     *
     */
    public static void last1(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack stack = new Stack();
        Stack print = new Stack();
        stack.push(node);
        while (!stack.empty()) {
            TreeNode head = (TreeNode) stack.pop();
            // 压入第二个堆中
            print.push(head);
            if (head.left != null) {
                stack.push(head.left);
            }
            if (head.right != null) {
                stack.push(head.right);
            }
        }
        while (!print.empty()) {
            TreeNode head = (TreeNode) print.pop();
            System.out.print(head.data + " ");
        }
        System.out.println();
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
        System.out.println("前序遍历：");
        pre(node1);
        System.out.println();
        pre1(node1);
        System.out.println();
        System.out.println("中序遍历：");
        mid(node1);
        System.out.println();
        mid1(node1);
        System.out.println();
        mid2(node1);
        System.out.println();
        System.out.println("后序遍历：");
        last(node1);
        System.out.println();
        last1(node1);
        System.out.println();
        show(node1);
        System.out.println();
        System.out.println("宽度遍历：");
        breadthFirstTraversal(node1);
        System.out.println();
    }




}
