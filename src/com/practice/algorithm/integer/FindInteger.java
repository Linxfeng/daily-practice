package com.practice.algorithm.integer;

import java.util.Arrays;
import java.util.List;

/** 查找整数 */
public class FindInteger {
    /**
     * 题目描述：
     *
     * <p>给定一个非降序的整数数组，数组中包含重复数字（重复数字很多），给定任意整数，对数组进行二分查找，返回数组正确的位置，给出函数实现。
     *
     * <p>a. 连续相同的数字，返回最后一个匹配的位置
     *
     * <p>b. 如果数字不存在返回 -1。
     *
     * <p>输入描述：第一行给定数组长度n,目标值tar。(1<=n,tar<=10000) 第二行给出n个整数a.(1<=a<=10000)
     *
     * <p>输出描述：按题目描述输出。
     *
     * <p>示例 1：输入 7 4\n 1 2 2 3 4 4 10；输出 5
     */
    public static void main(String[] args) {
        // 使用二分法查找，需要递归
        System.out.println(solution(7, 4, Arrays.asList(1, 2, 2, 3, 4, 4, 10)));
    }

    /** 时间复杂度：O(log n)，空间复杂度：O(1) */
    public static int solution(int n, int tar, List<Integer> arr) {
        // 先判断是否能够分割成两份
        if (n <= 0 || arr.isEmpty()) {
            return -1;
        }
        if (n == 1 || arr.size() == 1) {
            if (arr.get(0) == tar) {
                return 0;
            }
            return -1;
        }
        int result = 0;

        // 使用二分法查找
        int i = n / 2;
        int l = n % 2;

        if (arr.get(i) > tar) {
            // 递归继续查询前半段
            result = solution(i, tar, arr.subList(0, i));
        } else if (arr.get(i) < tar) {
            // 递归继续查询后半段，注意n的奇偶
            int index = solution(i, tar, arr.subList(i + l, n));
            // 取后半段时，下标需要累加
            result = index < 0 ? index : (index + i + l);
        } else if (arr.get(i) == tar) {
            // 取最后一个匹配的位置
            while (i < n) {
                if (arr.get(i) == tar) {
                    result = i;
                    i++;
                } else {
                    break;
                }
            }
        }
        return result;
    }
}
