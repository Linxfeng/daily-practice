package com.practice.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 四数之和 */
public class SumOfFourNums {
    /**
     * 题目描述：
     *
     * <p>给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c],
     * nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
     *
     * <p>你可以按任意顺序 返回答案。0<=a, b, c, d<n，a、b、c、d互不相同，nums[a]+nums[b]+nums[c]+nums[d]==target
     *
     * <p>示例 1：输入：nums = [1,0,-1,0,-2,2], target = 0，输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
     *
     * <p>示例 2：输入：nums = [2,2,2,2,2], target = 8，输出：[[2,2,2,2]]
     *
     * <p>提示：1 <= nums.length <= 200， -10^9 <= nums[i] <= 10^9， -10^9 <= target <= 10^9
     *
     * <p>来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/4sum 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        SumOfFourNums sumOfFourNums = new SumOfFourNums();
        System.out.println(sumOfFourNums.fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0));
        System.out.println(sumOfFourNums.fourSum(new int[] {2, 2, 2, 2, 2}, 8));
        System.out.println(sumOfFourNums.fourSum(new int[] {0, 1}, 1));
        int[] nums = new int[] {4, -9, -2, -2, -7, 9, 9, 5, 10, -10, 4, 5, 2, -4, -2, 4, -9, 5};
        System.out.println(sumOfFourNums.fourSum(nums, -13));
    }

    /** 时间复杂度：O(n^3)，空间复杂度：O(log n) */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 此题目解法与三数之和类似
        List<List<Integer>> result = new ArrayList<>();
        // 数组不够，直接返回
        if (nums == null || nums.length < 4) {
            return result;
        }
        // 先将数组从小到大进行排序
        Arrays.sort(nums);
        // 只有满足a+b+c+d=target，且a<=b<=c<=d 的情况下，才能满足要求
        int n = nums.length;
        // 遍历第一层a
        for (int a = 0; a < n - 3; a++) {
            // 当第一个值大于target的1/4时，直接跳过
            if (nums[a] > target / 4) {
                break;
            }
            // 遍历时遇到相同的元素直接跳过，保证结果不重复
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            // 遍历第二层b
            for (int b = a + 1; b < n - 2; b++) {
                // 遍历时遇到相同的元素直接跳过，保证结果不重复
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                // 数字a和b有了，c和d需要进行双指针查找
                int left = b + 1;
                int right = n - 1;
                // 双指针查询，保证左指针不能超过右指针
                while (left < right) {
                    // 四数之和
                    int sum = nums[a] + nums[b] + nums[left] + nums[right];
                    if (sum > target) {
                        // 右指针向左移动
                        right--;
                    } else if (sum < target) {
                        // 左指针向右移动
                        left++;
                    } else {
                        // sum == target，满足要求
                        result.add(Arrays.asList(nums[a], nums[b], nums[left], nums[right]));
                        // 跳过相邻的相同数字
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        // 双指针移动，进行下一轮判断
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
