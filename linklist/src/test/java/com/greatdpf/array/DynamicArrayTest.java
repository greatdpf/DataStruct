package com.greatdpf.array;

/**
 * @Date 2023/10/27
 * @Author staring
 * @Description 测试动态数组
 */
public class DynamicArrayTest {
    public static void main(String[] args) {
        DynamicArray<Integer> array = new DynamicArray<>(2);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.showArray();
    }
}
