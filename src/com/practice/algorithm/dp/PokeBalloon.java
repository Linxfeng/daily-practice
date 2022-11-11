package com.practice.algorithm.dp;

/** 戳气球 */
public class PokeBalloon {
    /**
     * 题目描述：
     *
     * <p>有 n 个气球，编号为 0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
     *
     * <p>现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i - 1 和 i + 1
     * 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
     *
     * <p>求所能获得硬币的最大数量。
     *
     * <p>示例 1：输入：nums = [3,1,5,8]；输出：167。
     *
     * <p>解释：nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []，coins = 3*1*5 + 3*5*8 + 1*3*8 +
     * 1*8*1 = 167
     *
     * <p>示例 2：输入：nums = [1,5]；输出：10
     *
     * <p>提示：1 <= nums.length <= 500；0 <= nums[i] <= 100
     */
    public static void main(String[] args) {
        System.out.println(solution(new int[] {3, 1, 5, 8}));
    }

    /** 时间复杂度：O(n^2)，空间复杂度：O(n+2) */
    public static int solution(int[] nums) {
        int n = nums.length;

        // 先将原数组前后补1，得到一个新的数组a
        int[] a = new int[n + 2];
        a[0] = a[n + 1] = 1;
        System.arraycopy(nums, 0, a, 1, n);

        int[][] dp = new int[n + 2][n + 2];

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n - k + 1; i++) {
                int j = i + k - 1;
                for (int x = i; x <= j; x++) {
                    int tmp = dp[i][x - 1] + a[i - 1] * a[x] * a[j + 1] + dp[x + 1][j];
                    dp[i][j] = Math.max(dp[i][j], tmp);
                }
            }
        }
        return dp[1][n];
    }
}
