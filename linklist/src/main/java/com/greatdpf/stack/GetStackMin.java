package com.greatdpf.stack;

import com.greatdpf.doubleLinkedList.DoubleLinkedList;

/**
 * description：O（1）：获取栈中最小值
 *
 * @author staring
 * @date 2023/11/5
 */
public class GetStackMin {
    private DoubleLinkedList<Integer> stack;

    /**
     * O(1) 获取最小值方法，多增加一个栈，叫做最小栈，同步增长值，此值为当前栈的最小值；
     */
    private DoubleLinkedList<Integer> minStack;

    private int size;

    public GetStackMin() {
        stack = new DoubleLinkedList<>();
        minStack = new DoubleLinkedList<>();
    }

    public void push(int data) {
        if (size == 0) {
            minStack.addFirst(data);
            stack.addFirst(data);
            size++;
            return;
        }
        if (minStack.peekFirst() > data) {
            minStack.addFirst(data);
        } else {
            minStack.addFirst(minStack.peekFirst());
        }
        stack.addFirst(data);
        size++;
    }

    public int pop() {
        if (size <= 0) {
            throw new RuntimeException("栈已空");
        }
        size--;
        minStack.getFirst();
        return stack.getFirst();

    }

    public int getMin() {
        if (size <= 0) {
            throw new RuntimeException("栈已空");
        }
        return minStack.peekFirst();
    }

}
