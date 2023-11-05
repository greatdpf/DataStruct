package com.greatdpf.stack;

import com.greatdpf.doubleLinkedList.DoubleLinkedList;

/**
 * description：双向链表实现栈
 *
 * @author staring
 * @date 2023/11/5
 */
public class DoubleLinkedListForStack<T> {
    private DoubleLinkedList<T> stack;
    private int size = 0;

    private DoubleLinkedList<T> minStack;

    public DoubleLinkedListForStack() {
        stack = new DoubleLinkedList<>();
    }

    public void push(T data) {
        stack.addFirst(data);
        size++;
    }

    public T pop() {
        if (size <= 0) {
            throw new RuntimeException("栈已空");
        }
        T first = stack.getFirst();
        size--;
        return first;
    }

}
