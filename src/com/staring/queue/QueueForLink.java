package com.staring.queue;

/**
 * className: QueueForLink
 * description: 链表实现队列
 * author: staring
 * createDate: 2022/3/20
 * version: 1.0
 */
public class QueueForLink {
    /**
     * 单向队列节点
     */
    public static class SingleQueueNode<E> {
        public E value;
        public SingleQueueNode<E> next;

        public SingleQueueNode(E value) {
            this.value = value;
        }
    }

    /**
     * 单向队列：先进先出，只能从一段进入，另一端出来
     */
    public static class SingleQueue<E> {
        public SingleQueueNode<E> head;
        public SingleQueueNode<E> last;
        public int size;

        public SingleQueue(){
            size = 0;
        }

        public SingleQueue(E value) {
            head = new SingleQueueNode<>(value);
            last = head;
            size = 1;
        }

        /**
         * 向队列中添加元素
         * @param value
         */
        public void add(E value) {
            SingleQueueNode newNode = new SingleQueueNode(value);
            if (head == null) {
                head = newNode;
                last = newNode;
            } else {
                last.next = newNode;
                last = newNode;
            }
            size++;
        }

        /**
         * 从队列中取出元素
         * @return
         */
        public E get() {
            if (head == null) {
                return null;
            }
            E v;
            v = head.value;
            if (head == last) {
                head = null;
                last = null;
            } else {
                head = head.next;
            }
            size--;
            return v;
        }

        /**
         * 遍历
         */
        public void show() {
            SingleQueueNode q = head;
            while (q != null) {
                System.out.print(q.value + " ");
                q = q.next;
            }
            System.out.println();
        }

        public boolean isEmpty() {
            return head == null;
        }

        public int getSize() {
            return size;
        }

    }

    /**
     * 双向队列节点
     * @param <E>
     */
    public static class DoubleQueueNode<E> {
        public E value;
        public DoubleQueueNode<E> previous;
        public DoubleQueueNode<E> next;

        public DoubleQueueNode(E value) {
            this.value = value;
        }
    }

    /**
     * 双向队列：任意两端均可进可出
     * @param <E>
     */
    public static class DoubleQueue<E> {
        public DoubleQueueNode<E> head;
        public DoubleQueueNode<E> last;

        public DoubleQueue(E value) {
            head = new DoubleQueueNode(value);
            last = head;
        }

        /**
         * 从头部添加节点
         * @param value
         */
        public void addToHead(E value) {
            DoubleQueueNode newNode = new DoubleQueueNode(value);
            if (head == null) {
                head = newNode;
                last = head;
            } else {
                newNode.next = head;
                head.previous = newNode;
                head = newNode;
            }
        }

        /**
         * 从尾部添加节点
         * @param value
         */
        public void addToLast(E value) {
            DoubleQueueNode newNode = new DoubleQueueNode(value);
            if (head == null) {
                head = newNode;
                last = head;
            } else {
                newNode.previous = last;
                last.next = newNode;
                last = newNode;
            }
        }

        /**
         * 从头部取出节点
         * @return
         */
        public E getToHead() {
            E v;
            if (head == null) {
                return null;
            }
            v = head.value;
            if (head == last) {
                head = null;
                last = null;
            } else {
                head = head.next;
                head.previous = null;
            }
            return v;
        }

        /**
         * 从尾部取出节点
         * @return
         */
        public E getToLast() {
            E v;
            if (head == null) {
                return null;
            }
            v = last.value;
            if (head == last) {
                head = null;
                last = null;
            } else {
                last = last.previous;
                last.next = null;
            }
            return v;
        }

        public void show() {
            DoubleQueueNode p = head;
            while (p != null) {
                System.out.print(p.value + " ");
                p = p.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("--------单向队列--------");
        SingleQueue singleQueue = new SingleQueue(1);
        singleQueue.show();
        System.out.println(singleQueue.get());
        singleQueue.add(2);
        singleQueue.add(3);
        singleQueue.add(4);
        singleQueue.add(5);
        singleQueue.show();

        System.out.println("--------双向队列--------");
        DoubleQueue doubleQueue = new DoubleQueue(1);
        doubleQueue.show();
        System.out.println(doubleQueue.getToHead());
        doubleQueue.addToHead(2);
        doubleQueue.addToHead(3);
        doubleQueue.addToHead(4);
        doubleQueue.addToHead(5);
        doubleQueue.show();
        doubleQueue.addToLast(6);
        doubleQueue.addToLast(7);
        doubleQueue.addToLast(8);
        doubleQueue.show();
        System.out.println(doubleQueue.getToLast());
        doubleQueue.show();
    }



}
