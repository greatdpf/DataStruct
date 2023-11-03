package com.greatdpf.queue;

/**
 * @Date 2023/10/26
 * @Author staring
 * @Description 数组实现队列
 */
public class ArrayForQueue<T> {

    private Object[] array;

    /**
     * 队列中元素的数量
     */
    private int size = 0;
    private int start = 0;
    private int end = 0;

    public ArrayForQueue(int capacity) {
        array = new Object[capacity];
    }

    public void add(T data) {
        if (isFull()) {
            throw new RuntimeException("队列已满！");
        }
        if (end >= array.length) {
            end = 0;
        }
        array[end++] = data;
        size++;
    }

    public T get() {
        if (isNone()) {
            throw new RuntimeException("队列已空！");
        }
        if (start >= array.length) {
            start = 0;
        }
        size--;
        return classConvert();
    }

    @SuppressWarnings("unchecked")
    private T classConvert() {
        return (T) array[start++];
    }

    public boolean isFull() {
        return size >= array.length;
    }
    public boolean isNone() {
        return size <= 0;
    }


}
