package com.practice.algorithm.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/** 两数之和 */
public class SumOfTwoNums {
    /**
     * 题目描述：
     *
     * <p>给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值 target 的那两个整数，并返回它们的数组下标。
     *
     * <p>你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。你可以按任意顺序返回答案。
     *
     * <p>示例 1：输入：nums = [2,7,11,15], target = 9，输出：[0,1]
     *
     * <p>示例 2：输入：nums = [3,3], target = 6，输出：[0,1]
     *
     * <p>提示：2 <= nums.length <= 10^4，-10^9 <= nums[i] <= 10^9，-10^9 <= target <= 10^9，只会存在一个有效答案
     *
     * <p>进阶：你可以想出一个时间复杂度小于 O(n^2) 的算法吗？
     *
     * <p>来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/two-sum 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] {2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[] {3, 2, 4, 4}, 6)));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(n) */
    public static int[] twoSum(int[] nums, int target) {
        // 这道题可以使用哈希表来解，降低时间复杂度
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历数组，将不满足条件的值和对应的下标放入map中
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                // 满足条件，直接返回
                return new int[] {map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[0];
    }
}
