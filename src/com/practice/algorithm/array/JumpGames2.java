package com.practice.algorithm.array;

/** 跳跃游戏2 */
public class JumpGames2 {
    /**
     * 题目描述：
     *
     * <p>给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
     *
     * <p>数组中的每个元素代表你在该位置可以跳跃的最大长度。 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     *
     * <p>假设你总是可以到达数组的最后一个位置。
     *
     * <p>示例 1：输入: nums = [2,3,1,1,4]，输出: 2
     *
     * <p>解释: 跳到最后一个位置的最小跳跃数是 2。从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。
     *
     * <p>示例 2：输入: nums = [2,3,0,1,4]，输出: 2
     *
     * <p>提示：1 <= nums.length <= 10^4；0 <= nums[i] <= 1000
     *
     * <p>来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/jump-game-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        System.out.println(solution(new int[] {2, 3, 1, 1, 4}));
        System.out.println(solution(new int[] {2, 3, 0, 1, 4}));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(1) */
    public static int solution(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
