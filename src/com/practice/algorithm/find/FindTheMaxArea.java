package com.practice.algorithm.find;

/** 盛最多水的容器 */
public class FindTheMaxArea {
    /**
     * 题目描述：
     *
     * <p>给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i])。
     *
     * <p>找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     *
     * <p>返回容器可以储存的最大水量。说明：你不能倾斜容器。
     *
     * <p>示例 1：输入：[1,8,6,2,5,4,8,3,7] 输出：49
     *
     * <p>示例 2：输入：height = [1,1] 输出：1
     *
     * <p>提示：n == height.length；2 <= n <= 10^5；0 <= height[i] <= 10^4
     *
     * <p>来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/container-with-most-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        // 这道题可以使用双指针求解
        System.out.println(maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(1) */
    public static int maxArea(int[] height) {
        int res = 0;

        // 使用双指针向中间逼近
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            // 容量区域 = x坐标间隔 * 较小值
            int area = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, area);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}
