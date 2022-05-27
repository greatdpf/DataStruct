package com.staring.stack;

/**
 * className: SpecialStack
 * description: 特殊的栈：pop，push，getMin 等方法，都是O（1）
 * 两种方式：
 * 1. 实现两个大小相等的栈，一个数据栈，一个最小栈（当前元素和最小栈的栈顶元素进行比较），同步弹出和加入
 * 2. 实现两个栈，一个数据栈，一个最小栈，只有当添加的元素<=最小栈的值的时候，才弹出
 *
 * author: staring
 * createDate: 2022/3/24
 * version: 1.0
 */
public class SpecialStack {
    public static class SpecialStackForLink {
        public StackForLink.SingleStack saveData;
        public StackForLink.SingleStack saveMinData;

        public SpecialStackForLink(int value) {
            saveData = new StackForLink.SingleStack(value);
            saveMinData = new StackForLink.SingleStack(value);
        }

        public int pop() {
            saveMinData.get();
            return saveData.get();
        }

        public boolean push(int value) {
            saveData.add(value);
            int minData = saveMinData.isEmpty()?value:saveMinData.peek();
            if (value > minData) {
                saveMinData.add(minData);
            } else {
                saveMinData.add(value);
            }
            return true;
        }

        public int getMin() {
            return saveMinData.peek();
        }
    }

    public static void main(String[] args) {
        SpecialStackForLink specialStackForLink = new SpecialStackForLink(10);
        specialStackForLink.push(6);
        specialStackForLink.push(7);
        specialStackForLink.push(5);
        specialStackForLink.push(4);
        System.out.println(specialStackForLink.getMin());
        System.out.println(specialStackForLink.pop());
        System.out.println(specialStackForLink.getMin());
        System.out.println(specialStackForLink.pop());
        System.out.println(specialStackForLink.getMin());
        System.out.println(specialStackForLink.pop());
        System.out.println(specialStackForLink.pop());
        System.out.println(specialStackForLink.pop());
        System.out.println(specialStackForLink.pop());
    }

}
