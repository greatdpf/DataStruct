package com.greatdpf.stack;

/**
 * description：获取最小值
 *
 * @author staring
 * @date 2023/11/5
 */
public class GetStackMinTest {
    public static void main(String[] args) {
        GetStackMin getStackMin = new GetStackMin();
        getStackMin.push(9);
        System.out.println(getStackMin.getMin());
        getStackMin.push(5);
        System.out.println(getStackMin.getMin());
        getStackMin.push(2);
        System.out.println(getStackMin.getMin());
        getStackMin.push(8);
        System.out.println(getStackMin.getMin());
        getStackMin.push(6);
        System.out.println(getStackMin.getMin());


    }
}
