package com.practice.algorithm.integer;

import java.util.Arrays;
import java.util.List;

/** 整数分割 */
public class IntegerSplit {
    /**
     * 题目描述：
     *
     * <p>小Q决定把一个整数 n，分割为 k 个整数。 每个整数必须大于等于 1。小Q有多少方案。
     *
     * <p>输入描述：输入整数 n,k.(1<=n,k<=100)
     *
     * <p>输出描述：输出方案数。答案对 1e9+7 取模。
     *
     * <p>示例 1：输入 3 3；输出 1
     */
    public static void main(String[] args) {
        // 使用动态规划法求解
        System.out.println(solution(Arrays.asList(3, 3)));
    }

    /** 时间复杂度：O(n^2)，空间复杂度：O(n) */
    public static int solution(List<Integer> arr) {
        int n = arr.get(0);
        int k = arr.get(1);

        if (n == 0 || k == 0) {
            return 0;
        }

        // 动态规划
        long[][] dp = new long[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                if (i > j) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - j][j];
                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        // 答案对 1e9+7 取模
        return (int) (dp[n][k] % 1000000007);
    }
}
