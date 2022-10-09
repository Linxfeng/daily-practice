package com.practice.algorithm.array;

import java.util.HashSet;
import java.util.Set;

/** 最长连续序列 */
public class LongestContinuousSequence {
    /**
     * 题目描述：
     *
     * <p>给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     *
     * <p>请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
     *
     * <p>输入描述：输入未排序的整数数组 nums。
     *
     * <p>输出描述：输出x的最小值。
     *
     * <p>示例 1：输入：nums = [100,4,200,1,3,2]；输出：4。解释：最长数字连续序列是[1, 2, 3, 4]。它的长度为 4。
     *
     * <p>示例 2：输入：nums = [0,3,7,2,5,8,4,6,0,1]；输出：9
     *
     * <p>提示：0 <= nums.length <= 10^5，-10^9 <= nums[i] <= 10^9
     */
    public static void main(String[] args) {
        // 利用HashSet求连续序列
        System.out.println(solution(new int[] {0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(n) */
    public static int solution(int[] nums) {
        // 先使用HashSet存储所有数字
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int res = 0;
        for (int num : numSet) {
            // 找到具有连续的数字
            if (numSet.contains(num + 1)) {
                int currentNum = num;
                int currentStreak = 1;
                // 不断寻找连续的数字，取最长的连续区间
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                res = Math.max(res, currentStreak);
            }
        }
        return res;
    }
}
