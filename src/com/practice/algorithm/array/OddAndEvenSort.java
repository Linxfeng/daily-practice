package com.practice.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 奇偶排序 */
public class OddAndEvenSort {
    /**
     * 题目描述：
     *
     * <p>给定一个存放整数的数组，重新排列数组使得数组左边为奇数，右边为偶数。
     *
     * <p>输入描述：第一行输入整数 n(1<=n<=1000) 表示数组大小。第二行输入n个整数a.(1<=a<=100)
     *
     * <p>输出描述：输出重排之后的数组。
     *
     * <p>示例 1：输入 6\n 3 34 67 89 90 58；输出 3 67 89 34 90 58
     *
     * <p>示例 2：输入 7\n 4 3 9 2 13 50 7；输出 3 9 13 7 4 2 50
     */
    public static void main(String[] args) {
        System.out.println(solution(7, Arrays.asList(4, 3, 9, 2, 13, 50, 7)));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(n) */
    public static List<Integer> solution(int n, List<Integer> arr) {
        // 若只有1个数字，直接返回
        if (n == 1) {
            return arr;
        }
        // 将奇数和偶数分别收集起来
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();

        for (Integer m : arr) {
            if (m % 2 == 0) {
                even.add(m);
            } else {
                odd.add(m);
            }
        }

        // 组合数组，奇数在前，偶数在后
        odd.addAll(even);

        return odd;
    }
}
