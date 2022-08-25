package com.practice.algorithm;

/** 走楼梯 */
public class WalkTheStair {
    /**
     * 题目描述：
     *
     * <p>走楼梯：现在有一截楼梯，根据你的腿长，你一次能走1级或2级楼梯，已知你要走n级楼梯才能走到你的目的楼层
     *
     * <p>请实现一个方法，计算你走到目的楼层的方案数
     *
     * <p>输入描述：输入整数n。(1<=n<=50)
     *
     * <p>输出描述：输出方案数。
     *
     * <p>示例1：输入 5，输出 8
     */
    public static void main(String[] args) {
        // 这道题解决方法有两种，一个是利用斐波那契数列，即递归方法，另一种是利用动态规划方法。
        System.out.println(walkTheStair(5));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(1) */
    public static int walkTheStair(int n) {
        int result = 0;
        int a = 1, b = 2;
        // 如果只有1级或者2级楼梯，则可直接返回结果
        if (n == 1 || n == 2) {
            result = n;
        } else {
            // 楼梯超过两级，可以不断地去累加它的方案，也可以直接使用递归
            for (int i = 2; i < n; i++) {
                result = a + b;
                a = b;
                b = result;
            }
        }
        return result;
    }
}
