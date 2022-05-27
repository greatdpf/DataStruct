package com.staring.stack;

/**
 * className: StackForLink
 * description: 链表实现栈
 * author: staring
 * createDate: 2022/3/24
 * version: 1.0
 */
public class StackForLink {
    /**
     * 单节点
     */
    public static class SingleStackNode {
        int value;
        SingleStackNode next;

        public SingleStackNode(int value) {
            this.value = value;
        }
    }

    /**
     * 单向栈：先进后出
     */
    public static class SingleStack {
        SingleStackNode head;

        public SingleStack() {

        }

        public SingleStack(int value) {
            head = new SingleStackNode(value);
        }

        public void add(int value) {
            SingleStackNode newNode = new SingleStackNode(value);
            newNode.next = head;
            head = newNode;
        }

        public int get() {
            if (head == null) {
                throw new RuntimeException("栈已空，请添加元素");
            }
            SingleStackNode singleStackNode = head;
            head = head.next;
            return singleStackNode.value;
        }

        public int peek() {
            if (head == null) {
                throw new RuntimeException("栈已空，请添加元素");
            }
            return head.value;
        }

        public boolean isEmpty() {
            return head == null;
        }

    }
    public static void main(String[] args) {
        SingleStack singleStack = new SingleStack(1);
        singleStack.add(2);
        singleStack.add(3);

        System.out.println(singleStack.get());
        System.out.println(singleStack.get());
        System.out.println(singleStack.get());
        System.out.println(singleStack.get());


    }
}
