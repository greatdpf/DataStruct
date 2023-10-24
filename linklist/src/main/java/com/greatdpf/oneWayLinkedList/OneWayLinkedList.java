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
