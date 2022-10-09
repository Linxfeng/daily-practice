package com.practice.algorithm.array;

import java.util.Arrays;
import java.util.List;

/** 倒置子序列 */
public class InversionSubsequence {
    /**
     * 题目描述：
     *
     * <p>已知存在一个长度为n的整数序列A。A中所有元素按照从小到达的顺序进行排序。现在执行操作倒置一段序列。请找到A序列里的倒置子序列。
     *
     * <p>输入描述：第一行输入整数n.(1<=n<=1000)。第二行输入n个整数。(1<=num<=10000)
     *
     * <p>输出描述：输出被倒置的数列的左值，右值。如果没有则输出0 0
     *
     * <p>示例 1：输入 4\n 1 3 2 4；输出 2 3
     */
    public static void main(String[] args) {
        System.out.println(solution(4, Arrays.asList(1, 3, 2, 4)));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(1) */
    public static List<Integer> solution(int n, List<Integer> arr) {
        // 考虑数字小于等于2的情况
        if (n <= 1 || arr.size() <= 1) {
            return Arrays.asList(0, 0);
        } else if (n == 2 || arr.size() == 2) {
            // 第二个数字倒置
            if (arr.get(1) < arr.get(0)) {
                return Arrays.asList(arr.get(1), arr.get(1));
            }
            return Arrays.asList(0, 0);
        }
        // 定义左右两个值
        int left = 0;
        int right = 0;
        boolean hasLeft = false;
        for (int i = 1; i < arr.size(); i++) {
            // 当第一次出现非递增时，取左值
            if (!hasLeft && arr.get(i) < arr.get(i - 1)) {
                left = arr.get(i - 1);
                hasLeft = true;
            }
            // 已经有左值的情况下，第一次出现非递减时，取右值
            if (hasLeft && arr.get(i) > arr.get(i - 1)) {
                right = arr.get(i - 1);
                break;
            }
        }
        // 返回倒置的左右值
        return Arrays.asList(right, left);
    }
}
