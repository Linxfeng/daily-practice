package com.practice.algorithm.array;

import java.util.Arrays;
import java.util.List;

/** 最长递增区间 */
public class LongestIncreasingInterval {
    /**
     * 题目描述：
     *
     * <p>给定一个无序数组，求最长递增的区间长度。（严格递增）
     *
     * <p>如：[5, 2, 3, 8, 1, 9] 最长递增区间 2, 3, 8 长度为3
     *
     * <p>输入描述：第一行输入整数n (1<=n<=10000)，表示数组的大小。第二行给出n个整数a.(-1e9<=a<=1e9)
     *
     * <p>输出描述：输出最长递增的区间长度。
     *
     * <p>示例1：输入 6\n 5 2 3 8 9；输出 3
     */
    public static void main(String[] args) {
        System.out.println(solution(6, Arrays.asList(5, 2, 3, 8, 1, 9)));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(1) */
    public static int solution(int n, List<Integer> arr) {
        // 考虑只有一个数字的情况
        if (n == 1 || arr.size() == 1) {
            return 1;
        }
        // 依次判断数字是否严格递增
        int result = 0;
        int temp = 1;
        for (int i = 1; i < arr.size(); i++) {
            // 符合递增条件，区间长度+1
            if (arr.get(i) > arr.get(i - 1)) {
                temp++;
            } else {
                // 不符合条件，区间重置，重新开始计算
                temp = 1;
            }
            // 取出最大的递增区间
            result = Math.max(result, temp);
        }
        return result;
    }
}
