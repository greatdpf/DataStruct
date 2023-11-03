package com.greatdpf.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Date 2023/10/26
 * @Author staring
 * @Description 动态数组
 */
public class DynamicArray<T> {
    private Object[] array;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    public DynamicArray(){
        array = new Object[DEFAULT_CAPACITY];
    }
    public DynamicArray(int capacity) {
        array = new Object[capacity];
    }

    public void add(T data){
        if (size >= array.length) {
            addCapacity();
        }
        array[size++] = data;
    }

    private void addCapacity() {
        int oldCapacity = array.length;
        int newCapacity = oldCapacity < DEFAULT_CAPACITY ? DEFAULT_CAPACITY : oldCapacity + (oldCapacity >> 1);
        array = Arrays.copyOf(array, newCapacity);
    }

    @SuppressWarnings("unchecked")
    public T get() {
        return (T) array[size--];
    }

    public void showArray() {
        for (int i = 0;i < size;i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
