package com.practice.algorithm.find;

/** 搜索旋转排序数组 */
public class SearchRotatedSortedArray {
    /**
     * 题目描述：
     *
     * <p>整数数组 nums 按升序排列，数组中的值互不相同 。
     *
     * <p>在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ...,
     * nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
     *
     * <p>例如，[0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
     *
     * <p>给你旋转后的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。
     *
     * <p>你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
     *
     * <p>示例 1：输入：nums = [4,5,6,7,0,1,2], target = 0；输出：4
     *
     * <p>示例 2：输入：nums = [4,5,6,7,0,1,2], target = 3；输出：-1
     *
     * <p>示例 3：输入：nums = [1], target = 0；输出：-1
     *
     * <p>提示：1 <= nums.length <= 5000；-10^4 <= nums[i] <= 10^4；nums 中的每个值都独一无二
     *
     * <p>题目数据保证 nums 在预先未知的某个下标上进行了旋转；-10^4 <= target <= 10^4
     *
     * <p>来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/search-in-rotated-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        // 使用二分法查找
        System.out.println(solution(new int[] {4, 5, 6, 7, 0, 1, 2}, 0));
    }

    /** 时间复杂度：O(log n)，空间复杂度：O(1) */
    public static int solution(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }

        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }

        // 使用二分法查找
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
