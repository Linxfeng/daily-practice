package com.practice.algorithm.find;

/** 搜索旋转排序数组2 */
public class SearchRotatedSortedArray2 {
    /**
     * 题目描述：
     *
     * <p>已知存在一个按非降序排列的整数数组 nums ，数组中的值可能会存在相同。
     *
     * <p>在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ...,
     * nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
     *
     * <p>例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
     *
     * <p>给你旋转后的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。
     *
     * <p>如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
     *
     * <p>示例 1：nums = [2,5,6,0,0,1,2], target = 0；输出：true
     *
     * <p>示例 2：nums = [2,5,6,0,0,1,2], target = 3；输出：false
     *
     * <p>提示：1 <= nums.length <= 5000；-10^4 <= nums[i] <= 10^4；-10^4 <= target <= 10^4
     *
     * <p>题目数据保证 nums 在预先未知的某个下标上进行了旋转；数组 nums 中可能包含重复元素。
     */
    public static void main(String[] args) {
        // 使用二分法查找
        System.out.println(solution(new int[] {2, 5, 6, 0, 0, 1, 2}, 0));
        System.out.println(solution(new int[] {2, 5, 6, 0, 0, 1, 2}, 3));
    }

    /** 时间复杂度：O(n log n)，空间复杂度：O(1) */
    public static boolean solution(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return nums[0] == target;
        }

        int l = 0;
        int r = n - 1;

        while (l <= r) {
            // 往中间递进到不同的数字
            while (l < r && nums[l] == nums[l + 1]) {
                l++;
            }
            while (l < r && nums[r] == nums[r - 1]) {
                r--;
            }

            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return true;
            }

            if (nums[mid] >= nums[0] && (target > nums[mid] || target < nums[0])) {
                l = mid + 1;
            } else if (nums[mid] < nums[0] && target > nums[mid] && target < nums[0]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
