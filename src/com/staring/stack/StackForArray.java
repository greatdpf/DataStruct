package com.staring.stack;

/**
 * className: StackForArray
 * description: 数组实现栈
 * author: staring
 * createDate: 2022/3/24
 * version: 1.0
 */
public class StackForArray {
    public static class SingleStack {
        public int[] stack;
        public int index;
        public int limit;

        public SingleStack(int limit) {
            this.limit = limit;
            stack = new int[limit];
            index = 0;
        }

        public void add(int value) {
            if (index == limit) {
                throw new RuntimeException("栈已满");
            }
            stack[index++] = value;
        }

        public int get() {
            if (index == 0) {
                throw new RuntimeException("栈已空");
            }
            return stack[--index];
        }

        public boolean isEmpty() {
            return index == 0;
        }

        public boolean isFull() {
            return index == limit;
        }
    }

    public static void main(String[] args) {
        SingleStack singleStack = new SingleStack(2);
        singleStack.add(1);
        System.out.println(singleStack.get());
        singleStack.add(2);
        singleStack.add(3);
        System.out.println(singleStack.get());
        System.out.println(singleStack.get());
        System.out.println(singleStack.get());
    }

}
