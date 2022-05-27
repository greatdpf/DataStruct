package com.staring.link;

/**
 * className: DoubleLink
 * description: 双链表
 * author: staring
 * createDate: 2022/3/20
 * version: 1.0
 */
public class DoubleLink {
    /**
     * 双节点
     */
    public static class DoubleNode {
        // 值
        public int value;
        // 下一个节点
        public DoubleNode next;
        // 上一个节点
        public DoubleNode previous;

        public DoubleNode(int value) {
            this.value = value;
        }
    }

    /**
     * 双链表
     */
    public static class DoubleLinkedList {
        public DoubleNode head;

        public DoubleLinkedList(int value) {
            head = new DoubleNode(value);
        }

        /**
         * 添加节点
         * @param value
         */
        public void add(int value) {
            DoubleNode newNode = new DoubleNode(value);
            DoubleNode p = head;
            if (head == null) {
                head = newNode;
                return;
            }
            while ( p.next != null) {
                p = p.next;
            }
            p.next = newNode;
            newNode.previous = p;
        }

        /**
         * 正向输出
         */
        public void positiveShow() {
            DoubleNode p = head;
            while (p != null) {
                System.out.print(p.value + " ");
                p = p.next;
            }
            System.out.println();
        }

        /**
         * *************************** 待定
         * 逆向输出
         */
        public void reverseShow() {
            if (head == null)
                return;
            DoubleNode p = head;
            while (p.next != null) {
                p = p.next;
            }
            while (p != null) {
                System.out.print(p.value + " ");
                p = p.previous;
            }
            System.out.println();
        }

        /**
         * 反转双链表
         */
        public void reverseLink() {
            DoubleNode n = null;
            DoubleNode p = null;
            while(head != null) {
                n= head.next;
                head.next = p;
                head.previous = n;
                p = head;
                head = n;
            }
            head = p;
        }

        /**
         * 删除
         * @param value
         */
        public void remove (int value) {
            DoubleNode lastChecked = null;
            DoubleNode firstChecking = null;

            while (head != null) {
                if (head.value != value) {
                    break;
                }
                head = head.next;
                head.previous = null;
            }

            // lastChecked = head;
            firstChecking = head;

            while (firstChecking != null) {
                if (firstChecking.value == value) {
                    firstChecking.previous = null;
                    lastChecked.next = firstChecking.next;
                } else {
                    firstChecking.previous = lastChecked;
                    lastChecked = firstChecking;
                }
                firstChecking = firstChecking.next;
            }
        }
    }


    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList(1);
        doubleLinkedList.add(1);
        doubleLinkedList.add(3);
        doubleLinkedList.add(1);
        doubleLinkedList.add(2);
        doubleLinkedList.add(1);
        doubleLinkedList.positiveShow();
        //doubleLinkedList.reverseShow();
        //doubleLinkedList.reverseLink();
        //doubleLinkedList.positiveShow();
        //doubleLinkedList.add(1);
        //doubleLinkedList.positiveShow();
        System.out.println("删除操作");
        doubleLinkedList.remove(1);
        doubleLinkedList.positiveShow();
        doubleLinkedList.reverseShow();
    }

}
