package com.greatdpf.doubleLinkedList;

/**
 * @Date 2023/10/26
 * @Author staring
 * @Description 测试双向链表
 */
public class DoubleLinkedListTest {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> head = new DoubleLinkedList<>(1);
        head.addFirst(2);
        head.addLast(3);
        head.addLast(4);
        head.addLast(5);
        head.addLast(6);
        head.showList();
        head.showListLast();
        head.reverse();
        head.showList();
        head.showListLast();

    }
}
