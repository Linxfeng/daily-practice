package com.practice.algorithm.array;

/** 长度最小的子数组 */
public class MinSubArrayLength {
    /**
     * 题目描述：
     *
     * <p>给定一个含有 n 个正整数的数组和一个正整数 target 。
     *
     * <p>找出该数组中满足其和 ≥ target 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
     *
     * <p>示例 1：输入：target = 7, nums = [2,3,1,2,4,3]，输出：2；解释：子数组[4,3]是该条件下的长度最小的子数组。
     *
     * <p>示例 2：输入：target = 4, nums = [1,4,4]，输出：1
     *
     * <p>示例 3：输入：target = 11, nums = [1,1,1,1,1,1,1,1]，输出：0
     *
     * <p>提示：1 <= target <= 10^9，1 <= nums.length <= 10^5，1 <= nums[i] <= 10^5
     *
     * <p>来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/minimum-size-subarray-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        // 可使用滑动窗口法求解
        System.out.println(solution(7, new int[] {2, 3, 1, 2, 4, 3}));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(1) */
    public static int solution(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        // 是否找到满足条件的子数组
        boolean flag = false;
        // 子数组最小长度
        int res = n;
        // 左右指针
        int left = 0, right = 0;

        // 子数组之和
        int sum = 0;
        while (right < n) {
            sum += nums[right];
            while (sum >= target) {
                res = Math.min(res, right - left + 1);
                flag = true;
                sum -= nums[left];
                left++;
            }
            right++;
        }
        // 未找到满足条件的组数组，返回0
        if (!flag) {
            res = 0;
        }
        return res;
    }
}
