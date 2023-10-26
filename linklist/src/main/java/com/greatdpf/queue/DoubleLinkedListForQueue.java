package com.greatdpf.queue;

import com.greatdpf.doubleLinkedList.DoubleLinkedList;

/**
 * @Date 2023/10/26
 * @Author staring
 * @Description 双向链表实现队列
 */
public class DoubleLinkedListForQueue<T> {
    private DoubleLinkedList<T> list;

    public DoubleLinkedListForQueue(T data) {
        list = new DoubleLinkedList<>(data);
    }

    public void add(T data) {
        list.push(data);
    }

    public T get(){
        return list.pop();
    }


}
