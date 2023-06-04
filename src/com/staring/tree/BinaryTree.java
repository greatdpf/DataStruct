package com.staring.tree;


import java.util.TreeMap;

/**
 * description：二叉树
 *
 * @author staring
 * @date 2023/5/31
 */
public class BinaryTree<E> {
    private TreeNode<E> root;
    private int size = 0;

    public TreeNode<E> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<E> root) {
        this.root = root;
    }

    /**
     * 二叉树节点
     * @param <E>
     */
    static final class TreeNode<E> {
        E val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}

        public E getVal() {
            return val;
        }

        public void setVal(E val) {
            this.val = val;
        }
    }


    public BinaryTree() {
    }

    /**
     * 前序遍历
     */
    public void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历
     */
    public void midOrder() {

    }

    /**
     * 后序遍历
     */
    public void postOrder() {

    }

    public boolean add(E val) {
        return true;
    }

    public boolean remove(E val) {
        return true;
    }

    public static void main(String[] args) {
/*        TreeNode node1 = new TreeNode(1);
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
        node6.right = node10;*/
    }
}
/*
class BinaryTreeTest {
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

    }
}
*/

