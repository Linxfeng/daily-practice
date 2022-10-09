package com.practice.algorithm.dp;

/** 硬币划分 */
public class DivideCoins {
    /**
     * 题目描述：
     *
     * <p>有1分，2分，5分，10分四种硬币，每种硬币数量无限，给定n分钱(n<100000)，有多少中组合可以组成n分钱？
     *
     * <p>输入描述：输入整数n.(1<=n<=100000)
     *
     * <p>输出描述：输出组合数，答案对1e9+7取模。
     *
     * <p>示例 1：输入 13；输出 16
     */
    public static void main(String[] args) {
        // 典型的动态规划案例
        System.out.println(solution(13));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(n) */
    public static int solution(int n) {
        // 一共有4种硬币
        int[] coins = {1, 2, 5, 10};
        int[] array = new int[n + 1];

        // 只使用1分硬币只有一种方案
        array[0] = 1;

        // 4层循环，分别计算使用1、1-2、1-2-5、1-2-5-10组成n的方案数
        for (int i : coins) {
            for (int j = i; j <= n; j++) {
                array[j] = (array[j] + array[j - i]) % 1000000007;
            }
        }
        return array[n];
    }
}
