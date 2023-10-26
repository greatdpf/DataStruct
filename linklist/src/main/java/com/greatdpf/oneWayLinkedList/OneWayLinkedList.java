package com.greatdpf.oneWayLinkedList;

/**
 * @author staring
 * Date 2023/10/24
 * description 单向链表节点
 */
public class OneWayLinkedList<T> {
    /**
     * 单向链表泛型节点
     */
    private static class Node<T> {
        T data;
        Node<T> next;
        Node (T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * 头节点
     */
    private Node<T> head;


    public OneWayLinkedList(T data) {
        this.head = new Node<>(data, null);
    }


    /**
     * 添加单向链表节点
     * 1. 找到最后一个节点
     * 2. 添加节点
     */
    public void add(T data) {
        if (head == null) {
            head = new Node<>(data, null);
            return;
        }
        Node<T> indexNode = head;
        // 1. 找到最后一个节点
        while (indexNode.next != null) {
            indexNode = indexNode.next;
        }
        // 2. 添加节点
        indexNode.next = new Node<>(data, null);
    }

    /**
     * 单向链表反转
     * 注：链表反转：相当于从头开始新建链表
     * 1. 定义两个节点：
     * p 标记头节点的下一个节点，避免丢失；newHead 标记建立好后的新节点
     * 2. 循环，直到 head 找到最后一个 null节点
     */
    public void reverse() {
        // 如果头节点为null，或者只有一个头节点，无需反转
        if (head == null || head.next == null) {
            return;
        }
        // 标记头节点的下一个节点
        Node<T> p;
        // 新的头部节点，用于记录新头部
        Node<T> newHead = null;
        while (head != null) {
            // 先记录head的下一个指针，防止后续链表丢失
            p = head.next;
            // 将 head 指向新链表的头节点，这样就实现了原来前面的节点变成后面的节点
            // head  head.next           newNode    head   p
            //   A  ->   B   ->   c   ;    null  <-  A     B ->  C
            head.next = newHead;
            // 移动头部节点
            newHead = head;
            // 移动 head 节点到下一个准备反转的节点，直到头节点为 null
            head = p;
        }
        head = newHead;
    }

    /**
     * 删除节点
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
        }
        Node<T> index = head;
        while (index.next != null) {
            if (index.next.data == data) {
                index.next = index.next.next;
            }
            index = index.next;
        }
    }

    public void showList() {
        if (head == null) {
            System.out.println("空列表！");
            return;
        }
        Node<T> indexNode = head;
        while (indexNode != null) {
            System.out.print(indexNode.data + " ");
            indexNode = indexNode.next;
        }
        System.out.println();
    }
}
