package com.staring.heap;

/**
 * description：堆结构
 * 数组实现堆结构：大根堆或者小根堆
 *
 * @author staring
 * @date 2022/7/25
 */
public class HeapArray {

    private int[] array;
    private int heapSize = 0;

    public HeapArray() {
        array = new int[10];
    }
    public HeapArray(int length) {
        array = new int[length];
    }

    public boolean add(int value) {
        if (heapSize == array.length) {
            return false;
        }
        array[heapSize] = value;
        int index = heapSize;
        // 大根堆
        while (index > 0 && array[index] > array[(index - 1) >> 1]) {
            swap(array, index, (index - 1) >> 1);
            index = (index - 1) >> 1;
        }
        heapSize++;
        return true;
    }

    public void swap(int[] array, int a, int b) {
        int t = array[a];
        array[a] = array[b];
        array[b] = t;
    }

    public void print() {
        for (int i = 0;i < heapSize;i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        HeapArray heapArray = new HeapArray();
        heapArray.add(5);
        heapArray.add(3);
        heapArray.add(8);
        heapArray.add(9);
        heapArray.add(6);
        heapArray.add(4);
        heapArray.add(7);
        heapArray.add(0);
        heapArray.add(2);
        heapArray.add(1);
        heapArray.add(11);
        heapArray.print();
    }


}
