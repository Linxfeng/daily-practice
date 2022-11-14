package com.practice.algorithm.find;

import java.util.Arrays;

/** 最大矩阵面积 */
public class MaximumMatrixArea {
    /**
     * 题目描述：
     *
     * <p>给定一个仅包含 0 和 1 、大小为 n * m 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
     *
     * <p>输入描述：输入n*m矩阵.(0<=n,m<=200)
     *
     * <p>输出描述：输出一个整数，矩阵最大面积。
     *
     * <p>示例 1：
     *
     * <p>输入：matrix=[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]；
     * 输出：6。解释：最大矩形面积取
     * matrix[1][2],matrix[1][3],matrix[1][4],matrix[2][2],matrix[2][3],matrix[2][4]。
     *
     * <p>示例 2：输入：matrix = []；输出：0
     *
     * <p>示例 3：输入：matrix = [["0"]]；输出：0
     *
     * <p>示例 4：输入：matrix = [["1"]]；输出：1
     *
     * <p>示例 5：输入：matrix = [["0","0"]]；输出：0
     *
     * <p>提示：matrix[i][j] 为 '0' 或 '1'。
     */
    public static void main(String[] args) {
        System.out.println(
                solution(
                        new char[][] {
                            new char[] {'1', '0', '1', '0', '0'},
                            new char[] {'1', '0', '1', '1', '1'},
                            new char[] {'1', '1', '1', '1', '1'},
                            new char[] {'1', '0', '0', '1', '0'}
                        }));
    }

    /** 时间复杂度：O(nm)，空间复杂度：O(n) */
    public static int solution(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int res = 0;
        int n = matrix[0].length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        // 都为1的高度
        int[] height = new int[n];

        for (char[] chars : matrix) {
            int curLeft = 0;
            int curRight = n;
            // 为height和left赋值
            for (int i = 0; i < n; i++) {
                if (chars[i] == '1') {
                    height[i]++;
                    left[i] = Math.max(left[i], curLeft);
                } else {
                    height[i] = 0;
                    left[i] = 0;
                    curLeft = i + 1;
                }
            }
            // 倒序遍历，为right赋值
            for (int i = n - 1; i >= 0; i--) {
                if (chars[i] == '1') {
                    right[i] = Math.min(right[i], curRight);
                } else {
                    right[i] = n;
                    curRight = i;
                }
            }
            // 计算面积，取最大面积
            for (int i = 0; i < n; i++) {
                res = Math.max(res, (right[i] - left[i]) * height[i]);
            }
        }
        return res;
    }
}
