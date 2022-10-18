package com.practice.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 数组子集全排列 */
public class SubsetPermutation {
    /**
     * 题目描述：
     *
     * <p>给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
     *
     * <p>解集不能包含重复的子集。返回的解集中，子集可以按任意顺序排列。
     *
     * <p>示例 1：输入：nums = [1,2,2]；输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
     *
     * <p>示例 2：输入：nums = [0]；输出：[[],[0]]
     *
     * <p>提示：1 <= nums.length <= 10；-10 <= nums[i] <= 10
     */
    public static void main(String[] args) {
        // 使用回溯法
        System.out.println(solution(new int[] {1, 2, 2}));
    }

    /** 时间复杂度：O(n 2^n)，空间复杂度：O(n) */
    public static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 排序
        Arrays.sort(nums);
        // 回溯法
        backTrace(nums, 0, new ArrayList<>(), res);
        return res;
    }

    public static void backTrace(
            int[] nums, int index, List<Integer> tmp, List<List<Integer>> res) {
        // 添加子集
        res.add(new ArrayList<>(tmp));

        // 继续遍历index至结束
        for (int i = index; i < nums.length; ++i) {
            // 剔除重复元素
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            // 添加当前子集的元素
            tmp.add(nums[i]);
            // 继续回溯
            backTrace(nums, i + 1, tmp, res);
            // 移除上一个元素，继续遍历
            tmp.remove(tmp.size() - 1);
        }
    }
}
