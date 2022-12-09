package com.practice.algorithm.dp;

/** 不同路径2 */
public class DifferentPaths2 {
    /**
     * 题目描述：
     *
     * <p>一个机器人位于一个 m x n 网格的左上角。机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角。
     *
     * <p>现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     *
     * <p>网格中的障碍物和空位置分别用 1 和 0 来表示。
     *
     * <p>示例 1：输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]；输出：2
     *
     * <p>解释：3x3 网格的正中间有一个障碍物。从左上角到右下角一共有 2 条不同的路径：
     *
     * <p>1. 向右 -> 向右 -> 向下 -> 向下；2. 向下 -> 向下 -> 向右 -> 向右
     *
     * <p>示例 2：输入：obstacleGrid = [[0,1],[0,0]]；输出：1
     *
     * <p>提示：m == obstacleGrid.length；n == obstacleGrid[i].length；
     *
     * <p>1 <= m, n <= 100；obstacleGrid[i][j] 为 0 或 1
     */
    public static void main(String[] args) {
        System.out.println(
                solution(
                        new int[][] {
                            new int[] {0, 0, 0}, new int[] {0, 1, 0}, new int[] {0, 0, 0}
                        }));
        System.out.println(solution(new int[][] {new int[] {0, 1}, new int[] {0, 0}}));
    }

    /** 时间复杂度：O(mn)，空间复杂度：O(mn) */
    public static int solution(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // 起点有障碍则无法到达
        if (obstacleGrid[0][0] == 1) {
            return 0;
        } else if (m == 1 && n == 1) {
            // 只要一格，起点即终点
            return 1;
        }

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                while (i < m) {
                    dp[i][0] = 0;
                    i++;
                }
                break;
            } else {
                dp[i][0] = 1;
            }
        }

        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                while (j < n) {
                    dp[0][j] = 0;
                    j++;
                }
                break;
            } else {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
