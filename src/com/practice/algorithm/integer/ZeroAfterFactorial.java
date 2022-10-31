package com.practice.algorithm.integer;

/** 阶乘后的零 */
public class ZeroAfterFactorial {
    /**
     * 题目描述：
     *
     * <p>给定一个整数 n ，返回 n! 结果中尾随零的数量。
     *
     * <p>提示：n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
     *
     * <p>示例 1：输入：n = 3，输出：0；解释：3! = 6 ，不含尾随 0
     *
     * <p>示例 2：输入：n = 5，输出：1；解释：5! = 120 ，有一个尾随 0
     *
     * <p>示例 3：输入：n = 0，输出：0
     *
     * <p>提示：0 <= n <= 10^4
     *
     * <p>进阶：你可以设计并实现对数时间复杂度的算法来解决此问题吗？
     */
    public static void main(String[] args) {
        System.out.println(solution(3));
        System.out.println(solution(5));
        System.out.println(solution(10));
    }

    /** 时间复杂度：O(log n)，空间复杂度：O(1) */
    public static int solution(int n) {
        int result = 0;

        // 若n<5，则阶乘末尾没有0
        while (n >= 5) {
            result += n / 5;
            n /= 5;
        }

        return result;
    }
}
