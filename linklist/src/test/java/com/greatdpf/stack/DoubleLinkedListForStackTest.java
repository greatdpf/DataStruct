package com.greatdpf.stack;

/**
 * description：测试双向链表实现栈
 *
 * @author staring
 * @date 2023/11/5
 */
public class DoubleLinkedListForStackTest {
    public static void main(String[] args) {
        DoubleLinkedListForStack<Integer> stack =
                new DoubleLinkedListForStack<>();
        // 5 4 3 2 1 0
        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
