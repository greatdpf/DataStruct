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
        heapInsert(index);
        heapSize++;
        return true;
    }

    /**
     * 删除堆中最大值，并保持堆结构
     * @return
     */
    public int remove() {
        if (heapSize <= 0) {
            throw new RuntimeException("堆已空");
        }
        swap(array, 0, heapSize - 1);
        heapSize--;
        int i = 0;
        heapIfy(i);
        return array[heapSize];
    }


    /**
     * 元素上浮，维持大根堆结构
     * @param index
     */
    public void heapInsert(int index) {
        int up = (index - 1) >> 1;
        while(up >= 0 && array[index] > array[up]) {
            swap(array, index, up);
            index = up;
            up = (index - 1) >> 1;
        }
    }

    /**
     * 元素下沉，维持大根堆结构
     * @param index
     */
    public void heapIfy(int index) {
        int leftDown = 2 * index + 1;
        int rightDown = 2 * index + 2;
        while (leftDown < heapSize && rightDown < heapSize) {
            int maxIndex = array[leftDown] > array[rightDown] ? leftDown : rightDown;
            if (array[index] < array[maxIndex]) {
                swap(array, index, maxIndex);
                index = maxIndex;
                leftDown = 2 * index + 1;
                rightDown = 2 * index + 2;
            } else {
                break;
            }
        }
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
        heapArray.add(11);
        heapArray.add(4);
        heapArray.add(7);
        heapArray.add(0);
        heapArray.add(2);
        heapArray.add(1);
        heapArray.add(11);
        heapArray.print();
        System.out.println(heapArray.remove());
        System.out.println(heapArray.remove());
    }


}
