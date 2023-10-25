package com.greatdpf.oneWayLinkedList;

/**
 * @Date 2023/10/24
 * @Author staring
 * @Description 单向链表测试
 */
public class OneWayLinkedListTest {
    public static void main(String[] args) {
        OneWayLinkedList<Integer> head = new OneWayLinkedList<>(1);
        head.add(2);
        head.add(3);
        head.add(4);
        head.add(5);
        head.add(6);
        head.add(7);
        head.add(8);
        head.add(9);
        head.showList();
        head.reverse();
        head.showList();
        head.reverse();
        head.showList();
    }
}
