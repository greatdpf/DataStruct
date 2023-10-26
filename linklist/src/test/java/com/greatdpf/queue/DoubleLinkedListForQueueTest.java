package com.greatdpf.queue;

import com.greatdpf.doubleLinkedList.DoubleLinkedList;

/**
 * @Date 2023/10/26
 * @Author staring
 * @Description 双向链表实现队列测试
 */
public class DoubleLinkedListForQueueTest {
    public static void main(String[] args) {
        DoubleLinkedListForQueue<Integer> queue = new DoubleLinkedListForQueue<>(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.get());


    }
}
