package com.practice.algorithm.array;

/** 跳跃游戏 */
public class JumpGames {
    /**
     * 题目描述：
     *
     * <p>给定一个非负整数数组 nums ，你最初位于数组的第一个下标 。
     *
     * <p>数组中的每个元素代表你在该位置可以跳跃的最大长度。
     *
     * <p>判断你是否能够到达最后一个下标。
     *
     * <p>示例 1：输入：nums = [2,3,1,1,4] 输出：true
     *
     * <p>解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     *
     * <p>示例 2：输入：nums = [3,2,1,0,4] 输出：false
     *
     * <p>解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
     *
     * <p>提示：1 <= nums.length <= 3 * 10^4；0 <= nums[i] <= 10^5
     */
    public static void main(String[] args) {
        System.out.println(solution(new int[] {2, 3, 1, 1, 4}));
        System.out.println(solution(new int[] {3, 2, 1, 0, 4}));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(n) */
    public static boolean solution(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return true;
        }

        boolean can = true;
        int stride = 1;

        // 从倒数第二位开始，往前递推
        for (int i = n - 2; i >= 0; i--) {
            // 若当前位置到达不了最后一位
            if (nums[i] < stride) {
                // 则步长+1
                stride++;
                can = false;
            } else {
                // 若可以到达，则步长为1
                stride = 1;
                can = true;
            }
        }
        return can;
    }
}
