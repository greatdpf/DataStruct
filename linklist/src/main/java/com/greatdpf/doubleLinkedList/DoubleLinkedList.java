package com.greatdpf.doubleLinkedList;

import java.util.LinkedList;

/**
 * @Date 2023/10/24
 * @Author staring
 * @Description 双向链表
 */
public class DoubleLinkedList<T> {

    /**
     * 双向链表节点
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

    /**
     * 从头部添加数据
     *
     */
    public void addFirst(T data) {
        if (head == null) {
            head = new DoubleNode<>(data, null, null);
            return;
        }
        DoubleNode<T> newNode = new DoubleNode<>(data, null, head);
        head.pre = newNode;
        head = newNode;
    }

    /**
     * 从尾部添加数据
     */
    public void addLast(T data) {
        if (head == null) {
            head = new DoubleNode<>(data, null, null);
            return;
        }
        DoubleNode<T> index = head;
        while (index.next != null) {
            index = index.next;
        }
        index.next = new DoubleNode<>(data, index, null);
    }

    /**
     *  双向链表反转
     */
    public void reverse() {
        if (head == null || head.next == null) {
            return;
        }
        DoubleNode<T> p;
        DoubleNode<T> newHead = null;
        while (head != null) {
            p = head.next;
            head.next = newHead;
            head.pre = p;
            newHead = head;
            head = p;
        }
        head = newHead;
    }

    /**
     * 双向链表实现队列：弹出
     */
    public T pop() {
        if (head == null) {
            throw new NullPointerException("队列为空！");
        }
        T data = head.data;
        head = head.next;
        head.pre = null;
        return data;
    }

    /**
     * 双向链表实现队列：压入
     */
    public void push(T data) {
        addLast(data);
    }

    /**
     * 删除
     */
    public void delete(T data) {
        if (head == null) {
            return;
        }
        while (head != null) {
            if (head.data != data) {
                break;
            }
            head = head.next;
            head.pre = null;
        }
        DoubleNode<T> index = head;
        while (index.next != null) {
            if (index.next.data == data) {
                index.next = index.next.next;
                index.next.pre = index;
            }
            index = index.next;
        }
    }


    public void showList() {
        DoubleNode<T> index = head;
        while (index != null) {
            System.out.print(index.data + " ");
            index = index.next;
        }
        System.out.println();
    }

    public void showListLast() {
        if (head == null) {
            return;
        }
        DoubleNode<T> last = head;
        while (last.next != null) {
            last = last.next;
        }
        while (last!=null) {
            System.out.print(last.data + " ");
            last = last.pre;
        }
        System.out.println();
    }

}
