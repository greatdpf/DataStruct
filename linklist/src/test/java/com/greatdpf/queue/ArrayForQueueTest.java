package com.greatdpf.queue;

/**
 * @Date 2023/10/26
 * @Author staring
 * @Description 数组实现队列测试
 */
public class ArrayForQueueTest {
    public static void main(String[] args) {
        ArrayForQueue<Integer> queue = new ArrayForQueue<>(5);
        queue.add(0);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.println(queue.get());
        queue.add(5);
        System.out.println(queue.get());
        queue.add(6);
        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.get());
    }

}
