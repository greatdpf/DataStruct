package com.staring.queue;

import com.staring.stack.StackForLink;

/**
 * className: QueueForTwoStack
 * description: 两个栈实现队列结构
 * author: staring
 * createDate: 2022/3/24
 * version: 1.0
 */
public class QueueForTwoStack {
    public static class TwoStackImplQueue {
        public StackForLink.SingleStack pushData;
        public StackForLink.SingleStack popData;

        public TwoStackImplQueue() {
            pushData = new StackForLink.SingleStack();
            popData = new StackForLink.SingleStack();
        }

        public void push(int value) {
            pushData.add(value);
        }

        public int pop() {
            if (popData.isEmpty()) {
                while (!pushData.isEmpty()) {
                    popData.add(pushData.get());
                }
            }
            return popData.get();
        }
    }

    public static void main(String[] args) {
        TwoStackImplQueue twoStackImplQueue = new TwoStackImplQueue();
        twoStackImplQueue.push(1);
        twoStackImplQueue.push(2);
        twoStackImplQueue.push(3);
        twoStackImplQueue.push(4);
        System.out.println(twoStackImplQueue.pop());
        System.out.println(twoStackImplQueue.pop());
        twoStackImplQueue.push(5);
        System.out.println(twoStackImplQueue.pop());
        System.out.println(twoStackImplQueue.pop());
        System.out.println(twoStackImplQueue.pop());
        System.out.println(twoStackImplQueue.pop());
    }

}
