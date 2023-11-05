package com.greatdpf.stack;

/**
 * description：数组实现栈
 *
 * @author staring
 * @date 2023/11/5
 */
public class ArrayForStack<T> {
    private Object[] stack;
    private int size = 0;

    public ArrayForStack(int capacity) {
        stack = new Object[capacity];
    }

    public void push(T data) {
        if (size >= stack.length) {
            throw new RuntimeException("栈已满");
        }
        stack[size++] = data;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (size < 0) {
            throw new RuntimeException("栈已空");
        }
        return (T) stack[--size];
    }

}
