package com.greatdpf.doubleLinkedList;

/**
 * @Date 2023/10/24
 * @Author staring
 * @Description 双链表
 */
public class DoubleLinkedList<T> {

    /**
     * 双链表节点
     * @param <T>
     */
    private static class DoubleNode<T> {
        T data;
        DoubleNode<T> pre;
        DoubleNode<T> next;
        DoubleNode(T data, DoubleNode<T> pre, DoubleNode<T> next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }
    }

    private DoubleNode<T> head;

    public DoubleLinkedList(T data) {
        this.head = new DoubleNode<>(data, null, null);
    }


}
