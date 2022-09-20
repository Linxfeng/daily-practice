package com.practice.algorithm;

import java.util.Arrays;
import java.util.List;

/** 矩阵最短路径 */
public class MatrixShortestPath {
    /**
     * 题目描述：
     *
     * <p>给定一个包含非负整数的 n * n 的矩阵，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     *
     * <p>说明：每次只能向下或者向右移动一步。
     *
     * <p>输入描述：第一行输入整数n。(1<=n<=100)；以下n行每行有n个整数。(1<=p<=100)
     *
     * <p>输出描述：输出路径上的数字最小总和值。
     *
     * <p>示例 1：输入 3\n 1 3 7\n 6 2 1\n 9 8 0；输出 7
     */
    public static void main(String[] args) {
        System.out.println(
                solution(
                        3,
                        Arrays.asList(
                                Arrays.asList(1, 3, 7),
                                Arrays.asList(6, 2, 1),
                                Arrays.asList(9, 8, 0))));
    }

    /** 时间复杂度：O(n^2)，空间复杂度：O(n^2) */
    public static int solution(int n, List<List<Integer>> vector) {
        // 考虑n为1的情况
        if (n <= 1) {
            return vector.get(0).get(0);
        }

        // 使用动态规划求解，累计到达每个格子的总和
        int[][] dp = new int[n][n];
        dp[0][0] = vector.get(0).get(0);

        // 给第一行赋值
        for (int j = 1; j < n; j++) {
            dp[0][j] = vector.get(0).get(j) + dp[0][j - 1];
        }
        // 给第一列赋值
        for (int i = 1; i < n; i++) {
            dp[i][0] = vector.get(i).get(0) + dp[i - 1][0];
        }

        // 其他每行每列赋值
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                int min = Math.min(dp[i - 1][j], dp[i][j - 1]);
                dp[i][j] = vector.get(i).get(j) + min;
            }
        }

        return dp[n - 1][n - 1];
    }
}
