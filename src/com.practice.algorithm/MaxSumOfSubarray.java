package com.practice.algorithm;

import java.util.Arrays;
import java.util.List;

/** 连续子数组的最大和 */
public class MaxSumOfSubarray {
    /**
     * 题目描述：
     *
     * <p>给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * <p>输入描述：第一行输入整数数组的大小n。(1<=n<=1000) 第二行给出n个整数a。(-1e5<=a<=1e5)
     *
     * <p>输出描述：输出答案。
     *
     * <p>示例 1：输入 9 -2 1 -3 4 -1 2 1 -5 4；输出 6
     */
    public static void main(String[] args) {
        // 解题思路：遍历一次，当前一个元素大于0时，当前元素则等于它本身加上前一个元素，返回最大值
        System.out.println(solution(9, Arrays.asList(-2, 1, -3, 4, -1, 2, 1, -5, 4)));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(1) */
    public static int solution(int n, List<Integer> arr) {
        if (arr.isEmpty()) {
            return 0;
        }
        if (n == 1) {
            return arr.get(0);
        }

        // 当前元素临时值
        int temp = arr.get(0);
        int result = 0;
        for (int i = 1; i < n; i++) {
            // 前一个元素大于0时，当前元素temp则等于它本身加上前一个元素
            if (temp > 0) {
                temp = temp + arr.get(i);
            } else {
                // 否则，当前元素temp从当前元素重新开始计算
                temp = arr.get(i);
            }
            // 取最大值
            result = Math.max(result, temp);
        }
        return result;
    }
}
