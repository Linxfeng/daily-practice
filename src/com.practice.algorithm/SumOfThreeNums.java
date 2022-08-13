package com.practice.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 三数之和 */
public class SumOfThreeNums {
    /**
     * 题目描述：
     *
     * <p>给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     *
     * <p>注意：答案中不可以包含重复的三元组。
     *
     * <p>示例 1：输入：nums = [-1,0,1,2,-1,-4] 输出：[[-1,-1,2],[-1,0,1]]
     *
     * <p>示例 2：输入：nums = [] 输出：[]
     *
     * <p>示例 3：输入：nums = [0] 输出：[]
     *
     * <p>提示：0 <= nums.length <= 3000， -10^5 <= nums[i] <= 10^5
     *
     * <p>来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/3sum 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        SumOfThreeNums sumOfThreeNums = new SumOfThreeNums();
        System.out.println(sumOfThreeNums.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
        System.out.println(sumOfThreeNums.threeSum(new int[] {0}));
        System.out.println(sumOfThreeNums.threeSum(new int[0]));
    }

    /** 时间复杂度：O(n^2)，空间复杂度：O(log n) */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 先将数组从小到大进行排序
        Arrays.sort(nums);
        // 只有满足a + b+ c = 0，且a < b < c的情况下，才能满足三数之和的要求
        int n = nums.length;
        // 遍历第一层a，下面两次循环可以使用双指针
        for (int a = 0; a < n; a++) {
            // 遍历时遇到相同的元素直接跳过，保证结果不重复
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            // 目标值，b + c = -a
            int target = -nums[a];
            // c的指针从最右侧开始
            int c = n - 1;
            // 遍历第二层b，从a的右侧开始遍历
            for (int b = a + 1; b < n; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                // 移动指针c，保证指针c在b的右侧
                while (b < c && nums[b] + nums[c] > target) {
                    c--;
                }
                // 随着指针b的增加，当指针重合时，后面的数不会满足要求，跳出b循环
                if (b == c) {
                    // 这个判断为什么要写到判断结果的前面，是为了避免当指针相等时，数组中的数字被重复使用
                    break;
                }
                // 如果b + c = -a，则找到了一个结果
                if (nums[b] + nums[c] == target) {
                    result.add(Arrays.asList(nums[a], nums[b], nums[c]));
                }
            }
        }
        return result;
    }
}
