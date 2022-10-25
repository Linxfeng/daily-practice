package com.practice.algorithm.array;

/** 查找旋转排序数组 */
public class FindRotatedSortedArray {
    /**
     * 题目描述：
     *
     * <p>整数数组 nums 按升序排列，数组中的值互不相同。
     *
     * <p>在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了旋转，使数组变为 [nums[k], nums[k+1], ...,
     * nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标从 0 开始计数）。
     *
     * <p>例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2]。
     *
     * <p>给你旋转后的数组 nums 和一个整数 target，如果 nums 中存在这个目标值 target，则返回它的下标，否则返回-1。
     *
     * <p>示例 1：输入：nums = [4,5,6,7,0,1,2], target = 0；输出：4
     *
     * <p>示例 2：输入：nums = [4,5,6,7,0,1,2], target = 3；输出：-1
     *
     * <p>示例 3：输入：nums = [1], target = 0；输出：-1
     *
     * <p>提示：1 <= nums.length <= 5000；-10^4 <= nums[i] <= 10^4；-10^4 <= target <= 10^4；
     *
     * <p>nums 中的每个值都 独一无二；题目数据保证 nums 在预先未知的某个下标上进行了旋转。
     *
     * <p>进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？
     */
    public static void main(String[] args) {
        // 使用二分法查找
        System.out.println(solution(new int[] {7, 0, 1, 2, 3, 4, 5, 6}, 1));
        System.out.println(solution(new int[] {4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(solution(new int[] {4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(solution(new int[] {1}, 1));
    }

    /** 时间复杂度：O(log n)，空间复杂度：O(1) */
    public static int solution(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        // 使用二分法查找
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // 判断目标值是否在中间
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[start] <= nums[mid]) {
                // 目标值在左半段
                if (target >= nums[start] && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    // 目标值在右半段
                    start = mid + 1;
                }
            }
            if (nums[mid] <= nums[end]) {
                // 目标值在右半段
                if (target >= nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    // 目标值在左半段
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
