package com.practice.algorithm.dp;

/** 接雨水 */
public class CatchRainwater {
    /**
     * 题目描述：
     *
     * <p>给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     *
     * <p>示例 1：输入：height = [0,1,0,2,1,0,1,3,2,1,2,1] 输出：6
     *
     * <p>解释：[1,0,2]可接住1个单位，[2,1,0,1,3]可接住4个单位，[2,1,2]可接住1个单位，一共可以接 6 个单位的雨水。
     *
     * <p>示例 2：输入：height = [4,2,0,3,2,5] 输出：9
     *
     * <p>提示：n == height.length；1 <= n <= 2 * 10^4；0 <= height[i] <= 10^5
     *
     * <p>来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/trapping-rain-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        System.out.println(solution(new int[] {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(solution(new int[] {4, 2, 0, 3, 2, 5}));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(n) */
    public static int solution(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }
}
