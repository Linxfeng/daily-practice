package com.practice.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 非降序数组 */
public class NonDescendingArray {
    /**
     * 题目描述：
     *
     * <p>写一个函数，传入两个非降序的整数数组（A, B），将 A, B 合并成一个非降序数组 C，返回 C（不要使用内置 sort 函数）。
     *
     * <p>输入描述：第一行输入两个整数n,m。（1<=n,m<=100000）分别表示数组A,B的大小。 第二行给出n个整数a。(1<=a<=10000)
     * 第三行给出m个整数b。(1<=b<=10000)
     *
     * <p>输出描述：输出合并之后排序好的数组。
     *
     * <p>示例 1：输入 3 3\n 1 9 10\n 3 12 41；输出 1 3 9 10 12 41
     */
    public static void main(String[] args) {
        System.out.println(solution(3, 3, Arrays.asList(1, 9, 10), Arrays.asList(3, 12, 41)));
    }

    /** 时间复杂度：O(n+m)，空间复杂度：O(n+m) */
    public static List<Integer> solution(int n, int m, List<Integer> arr1, List<Integer> arr2) {
        List<Integer> result = new ArrayList<>();
        // 两个数组的下标
        int index1 = 0;
        int index2 = 0;

        // 每次取两个数组中的较小值，取值后下标+1，直至结果集填充满
        while (result.size() < n + m) {
            int a, b;
            // 判断下标边界
            if (index1 == n) {
                a = Integer.MAX_VALUE;
            } else {
                a = arr1.get(index1);
            }
            if (index2 == m) {
                b = Integer.MAX_VALUE;
            } else {
                b = arr2.get(index2);
            }
            // 比较大小，取较小的值
            if (a == b) {
                result.add(a);
                result.add(b);
                index1++;
                index2++;
            } else if (a < b) {
                result.add(a);
                index1++;
            } else {
                result.add(b);
                index2++;
            }
        }
        return result;
    }
}
