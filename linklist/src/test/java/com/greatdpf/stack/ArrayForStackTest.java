package com.greatdpf.stack;

/**
 * description：测试数组实现栈
 *
 * @author staring
 * @date 2023/11/5
 */
public class ArrayForStackTest {
    public static void main(String[] args) {
        ArrayForStack<Integer> arrayForStack = new ArrayForStack<>(5);
        arrayForStack.push(0);
        arrayForStack.push(1);
        arrayForStack.push(2);
        arrayForStack.push(3);
        arrayForStack.push(4);
        System.out.println(arrayForStack.pop());
        arrayForStack.push(5);
        System.out.println(arrayForStack.pop());
        System.out.println(arrayForStack.pop());
        System.out.println(arrayForStack.pop());
    }
}
