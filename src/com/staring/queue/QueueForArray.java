package com.staring.queue;

import com.sun.jmx.remote.internal.ArrayQueue;

/**
 * className: ArrayQueue
 * description: 数组实现队列
 * author: staring
 * createDate: 2022/3/20
 * version: 1.0
 */
public class QueueForArray {


    /**
     * 数组实现单向队列：先进先出
     *
     */
    public static class SingleQueue {
        /**
         * 数组队列
         */
        public Object[] queue;
        /**
         * 队列的大小
         */
        public int limit;
        /**
         * 队列中的元素个数
         */
        public int size;

        /**
         * 队列中最后一个元素的位置
         */
        public int lastIndex;

        /**
         * 队列中第一个元素的位置
         */
        public int firstIndex;


        public SingleQueue(int limit) {
            queue = new Object[limit];
            this.limit = limit;
            size = 0;
            lastIndex = 0;
            firstIndex = 0;
        }


        /**
         * 向队列中添加元素
         * @param value
         */
        public void add(int value) {
            /**
             * 根据元素个数，判断队列是否已满
             */
            if (size + 1 > limit) {
                throw new RuntimeException("队列已满，无法添加");
            }
            /**
             * 如果元素位置超过下标，使其回头
             */
            if (lastIndex + 1 > limit) {
                lastIndex = 0;
            }
            // 添加元素
            queue[lastIndex++] = value;
            // 元素个数 +1；
            size++;
        }

        /**
         * 从队列中取出元素
         * @return
         */
        public Object get() {
            if (size <= 0) {
                throw new RuntimeException("队列已空，无法取出");
            }
            if (firstIndex + 1 >limit) {
                firstIndex = 0;
            }
            size--;
            return queue[firstIndex++];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }

    }

    public static void main(String[] args) {
        SingleQueue arrayQueue = new SingleQueue(2);
        arrayQueue.add(1);
        System.out.println(arrayQueue.size);
        arrayQueue.add(2);
        System.out.println(arrayQueue.get());
        System.out.println(arrayQueue.size);
        arrayQueue.add(3);
        System.out.println(arrayQueue.size);
        System.out.println(arrayQueue.get());
        System.out.println(arrayQueue.get());
        System.out.println(arrayQueue.get());

    }

}
