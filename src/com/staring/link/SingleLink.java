package com.staring.link;

/**
 * className: SingleLink
 * description: 单链表
 * author: staring
 * createDate: 2022/3/18
 * version: 1.0
 */
public class SingleLink {
    /**
     * 单节点
     */
    public static class SingleNode {
        // 值
        public int value;
        // 下一个节点
        public SingleNode next;

        public SingleNode(int data) {
            value = data;
        }
    }

    /**
     * 单链表
     */
    public static class SingleLinkedList {
        public SingleNode head;

        public SingleLinkedList(int value) {
            head = new SingleNode(value);
        }

        /**
         * 添加节点：
         * 1、先记录 head 头节点 p
         * 2、遍历到尾部节点
         * 3、将末尾节点指向新节点即可
         *
         * @param value
         * @return
         */
        public boolean add(int value) {
            SingleNode newNode = new SingleNode(value);
            SingleNode p = head;
            while(p.next != null) {
                p = p.next;
            }
            p.next = newNode;
            return true;
        }

        /**
         * 输出单链表
         */
        public void show() {
            SingleNode p = head;
            while (p != null) {
                System.out.print(p.value + " ");
                p = p.next;
            }
            System.out.println();
        }

        /**
         * 单链表反转
         * 1、创建两个记录节点，用于记录正在反转的两个节点；如：1-2   1 2
         * 2、记录当前 head 节点的下一个节点，next
         * 3、记录后，便可以将 head 的下一个节点，指向上一个节点 previous
         * 4、记录当前 head 节点，previous（新的头部节点）
         * 5、将 head 节点移动到 next 节点
         * 6、重复步骤 2-5，直到 head 节点为 null ，说明所有节点都遍历完成并且指向反转
         * 7、返回新的头部节点 previous
         * @return
         */
        public SingleNode reversalLink() {
            // 记录，当 head 节点移向 next 节点后，记录原 head 节点
            SingleNode previous = null;
            // 记录，当 head 节点指向上一个节点后，记录原 next 节点
            SingleNode next = null;
            while (head != null) {
                next = head.next;
                head.next = previous;
                previous = head;
                head = next;
            }
            return previous;
        }

        /**
         * 删除单链表中出现的所有 value 值
         *
         * 2、
         * @param value
         * @return
         */
        public void remove(int value) {
            // 记录 已经检测 的 最后一个 不等于 value 的节点
            SingleNode lastChecked = null;
            // 记录 正准备检测 的 第一个节点
            SingleNode firstChecking = null;
            // 判断头部节点是否需要删除，如果需要，则进行删除
            while (head != null) {
                if (head.value != value) {
                    break;
                } else {
                    head = head.next;
                }
            }
            // 让已经检测的头节点赋值给 lastChecked;
            // lastChecked = head;
            // 将头节点赋值给 firstChecking
            // （实际上应该将 头节点的下一个赋值给 firstChecking,但考虑到 头节点 可能为 null）
            firstChecking = head;
            // 删除内部的 value 值，当正在检测的节点为空时，说明，整个链表遍历完成
            while(firstChecking != null) {
                /**
                 * 正在检测的节点是否需删除
                 * 如果需要，则将其删除
                 * 删除操作：
                 * 将 已经检测 的最后一个节点的 下一个节点 指向 删除的 下一个节点
                 * lastChecked.next = firstChecking.next
                 * 如果不需要，说明正在检测的符合要求，变为已经检测后的最后一个
                 * lastChecked = firstChecking;
                 *
                 */
                if (firstChecking.value == value) {
                    lastChecked.next = firstChecking.next;
                } else {
                    lastChecked = firstChecking;
                }
                // 检查下一个
                firstChecking = firstChecking.next;
            }
        }
    }




    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList(4);
        singleLinkedList.add(4);
        singleLinkedList.add(4);
        singleLinkedList.add(4);
        singleLinkedList.add(4);
        singleLinkedList.add(4);
        singleLinkedList.add(4);
        singleLinkedList.add(4);
        singleLinkedList.head = singleLinkedList.reversalLink();
        singleLinkedList.show();
        singleLinkedList.remove(4);
        singleLinkedList.show();


    }

}
