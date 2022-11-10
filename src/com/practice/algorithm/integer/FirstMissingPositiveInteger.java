package com.practice.algorithm.integer;

/** 缺失的第一个正整数 */
public class FirstMissingPositiveInteger {
    /**
     * 题目描述：
     *
     * <p>给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
     *
     * <p>示例 1：输入：nums = [1,2,0]；输出：3
     *
     * <p>示例 2：输入：nums = [3,4,-1,1]；输出：2
     *
     * <p>示例 3：输入：nums = [7,8,9,11,12]；输出：1
     *
     * <p>提示：0 <= nums.length <= 300；-2^31 <= nums[i] <= 2^31 - 1
     *
     * <p>进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？
     */
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 2, 0}));
        System.out.println(solution(new int[] {3, 4, -1, 1}));
        System.out.println(solution(new int[] {7, 8, 9, 11, 12}));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(1) */
    public static int solution(int[] nums) {
        // 先找出数组中是否含有数字1
        int res = 0;
        for (int i : nums) {
            if (i == 1) {
                res = 1;
                break;
            }
        }
        // 若不含数字1，则直接返回最小正整数1
        if (res == 0) {
            return 1;
        }

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 若数字存在非1-n范围内，则必然会有比n小的正整数缺失
            if ((nums[i] <= 0) || (nums[i] > n)) {
                // 将非1-n范围的数全部赋值为1
                nums[i] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            // 必有a > 0 && a <= n，假设数组nums中数字按照1-n的顺序排列好
            int a = Math.abs(nums[i]);
            // 则有当前位置i对应的数字a则将取反，将下标位置为a-1的数置为负数
            nums[a - 1] = -Math.abs(nums[a - 1]);
        }
        // 那么剩余的第一个正数的位置，则为1-n的数字对应的位置
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                // 对应的最小正整数为下标位置+1
                return i + 1;
            }
        }
        // 若刚好数组nums中的数字为1-n，则最小正整数为n+1
        return n + 1;
    }
}
