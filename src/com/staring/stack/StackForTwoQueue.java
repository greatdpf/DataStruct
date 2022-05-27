package com.staring.stack;

import com.staring.queue.QueueForLink;

import java.util.ArrayDeque;

/**
 * className: StackForTwoQueue
 * description: 两个队列实现栈
 * author: staring
 * createDate: 2022/3/24
 * version: 1.0
 */
public class StackForTwoQueue {
    public static class TwoQueueImplStack {
        public QueueForLink.SingleQueue pushData;
        public QueueForLink.SingleQueue helpData;

        public TwoQueueImplStack() {
            pushData = new QueueForLink.SingleQueue();
            helpData = new QueueForLink.SingleQueue();
        }

        public void push(int value) {
            pushData.add(value);
        }

        public int pop() {
            if (pushData.isEmpty()) {
                throw new RuntimeException("栈已空");
            }
            while (pushData.getSize() > 1) {
                helpData.add(pushData.get());
            }
            QueueForLink.SingleQueue tmp = pushData;
            pushData = helpData;
            helpData = tmp;
            return (int) helpData.get();
        }
    }

    public static void main(String[] args) {
        TwoQueueImplStack twoQueueImplStack = new TwoQueueImplStack();
        twoQueueImplStack.push(1);
        twoQueueImplStack.push(2);
        twoQueueImplStack.push(3);
        twoQueueImplStack.push(4);
        twoQueueImplStack.push(5);
        System.out.println(twoQueueImplStack.pop());
        System.out.println(twoQueueImplStack.pop());
        System.out.println(twoQueueImplStack.pop());
        System.out.println(twoQueueImplStack.pop());
        System.out.println(twoQueueImplStack.pop());
        System.out.println(twoQueueImplStack.pop());
    }

}
