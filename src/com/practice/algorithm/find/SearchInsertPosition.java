package com.practice.algorithm.find;

/** 搜索插入位置 */
public class SearchInsertPosition {
    /**
     * 题目描述：
     *
     * <p>给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * <p>你可以假设数组中无重复元素。
     *
     * <p>示例 1：输入: [1,3,5,6], 5 输出: 2
     *
     * <p>示例 2：输入: [1,3,5,6], 2 输出: 1
     *
     * <p>示例 3：输入: [1,3,5,6], 7 输出: 4
     *
     * <p>示例 4：输入: [1,3,5,6], 0 输出: 0
     */
    public static void main(String[] args) {
        // 使用二分法查找
        System.out.println(solution(new int[] {1, 3, 5, 6}, 5));
        System.out.println(solution(new int[] {1, 3, 5, 6}, 7));
    }

    /** 时间复杂度：O(log n)，空间复杂度：O(1) */
    public static int solution(int[] nums, int target) {
        int n = nums.length;

        // 左右下标
        int left = 0;
        int right = n - 1;

        // 若比最小值小，则返回0
        if (target < nums[left]) {
            return 0;
        }

        // 若比最大值大，则返回n
        if (target > nums[right]) {
            return n;
        }

        // 二分法查找
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return left;
    }
}
