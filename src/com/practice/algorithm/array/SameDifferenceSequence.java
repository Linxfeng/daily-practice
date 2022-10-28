package com.practice.algorithm.array;

import java.util.Arrays;
import java.util.List;

/** 等差数列 */
public class SameDifferenceSequence {
    /**
     * 题目描述：
     *
     * <p>一个等差数列是一个能表示成a, a+b, a+2b,..., a+nb (n=0,1,2,3,...)的数列。在这个问题中a是一个非负的整数，b是正整数。
     *
     * <p>现给出三个整数，分别表示等差数列的第一项a、最后一项和公差b，求该数列的和。
     *
     * <p>输入描述：输入三个整数，之间用空格隔开。第1个数作为首项，第2个数作为末项，第3个数作为公差.
     *
     * <p>输出描述：输出占一行，包含一个整数，为该等差数列的和。如果所给三个整数，不能构成等差数列，则返回-1。
     *
     * <p>示例 1： 输入 2 11 3；输出 26
     */
    public static void main(String[] args) {
        // 利用等差数列前n项和公式：Sn = n * (a1 + an) / 2
        System.out.println(solution(Arrays.asList(2, 11, 3)));
    }

    /** 时间复杂度：O(1)，空间复杂度：O(1) */
    public static int solution(List<Integer> arr) {
        if (arr.size() < 3) {
            return -1;
        }

        int a1 = arr.get(0);
        int an = arr.get(1);
        int b = arr.get(2);

        // 根据an = a1 + (n-1)*b，求出n
        int n = (an - a1) / b + 1;

        // 验证等差数列合法性
        if (b * (n - 1) + a1 != an) {
            return -1;
        }

        // 根据等差数列前n项和公式返回结果
        return n * (a1 + an) / 2;
    }
}
