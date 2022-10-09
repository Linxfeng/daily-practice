package com.practice.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/** 排列序列 */
public class PermutationSequence {
    /**
     * 题目描述：
     *
     * <p>给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
     *
     * <p>按大小顺序列出所有排列情况，并一一标记。当 n = 3 时, 所有排列如下："123" "132" "213" "231" "312" "321"
     *
     * <p>给定 n 和 k，返回第 k 个排列。
     *
     * <p>示例 1：输入：n = 3, k = 3，输出："213"
     *
     * <p>示例 2：输入：n = 4, k = 9，输出："2314"
     *
     * <p>示例 3：输入：n = 3, k = 1，输出："123"
     *
     * <p>提示：1 <= n <= 9，1 <= k <= n!
     */
    public static void main(String[] args) {
        System.out.println(solution(4, 9));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(n) */
    public static String solution(int n, int k) {
        // n!对应的值
        int[] factorials = new int[n + 1];
        factorials[0] = 1;

        int fact = 1;
        List<Integer> candidates = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            candidates.add(i);
            fact *= i;
            factorials[i] = fact;
        }

        k -= 1;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; --i) {
            int index = k / factorials[i];
            sb.append(candidates.remove(index));
            k -= index * factorials[i];
        }

        return sb.toString();
    }
}
