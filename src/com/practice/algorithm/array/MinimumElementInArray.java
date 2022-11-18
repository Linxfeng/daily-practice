package com.practice.algorithm.array;

import java.util.Arrays;
import java.util.List;

/** 数组最小元素 */
public class MinimumElementInArray {
    /**
     * 题目描述：
     *
     * <p>给定一个按升序排序的数组，在某个位置进行旋转。（即 [0,1,2,4,5,6,7] 可能变成 [4,5,6,7,0,1,2]）。
     *
     * <p>找出数组中的最小元素。可以假设数组中不存在重复项。
     *
     * <p>输入描述：第一行输入整数n。(1<=n<=10000)表示数组的大小；第二行给出n个整数a.(0<=a<=1e9)
     *
     * <p>输出描述：输出数组中的最小元素
     *
     * <p>示例 1：输入 5\n 3 4 5 1 2；输出 1
     */
    public static void main(String[] args) {
        System.out.println(solution(5, Arrays.asList(3, 4, 5, 1, 2)));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(1) */
    public static int solution(int n, List<Integer> arr) {
        if (n == 1) {
            return arr.get(0);
        }

        // 遍历一次，找到数字开始变小的位置，返回
        int a = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            int b = arr.get(i);
            if (b < a) {
                return b;
            }
            a = b;
        }

        // 若全部都是递增顺序，则返回第一个数字
        return arr.get(0);
    }
}
