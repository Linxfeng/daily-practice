package com.practice.algorithm.other;

/** 求素数和 */
public class FindPrimesSum {
    /**
     * 题目描述：
     *
     * <p>求第 m 个到第 n 个素数之间的素数和。
     *
     * <p>输入描述：输入整数 m,n. (1<=m,n<=200)
     *
     * <p>输出描述：输出 m,n 之间（不含第m个，包含第n个）的素数之和。
     *
     * <p>示例 1：输入 6 12；输出 132。
     *
     * <p>解释：第 6 个素数是 11 ，第 12 个素数是31，它们之间素数之和 sum = 13+17+19+23+29+31 = 132
     */
    public static void main(String[] args) {
        System.out.println(solution(6, 12));
    }

    /** 时间复杂度：O(log n)，空间复杂度：O(n) */
    public static int solution(int m, int n) {
        // 先列出前n个素数
        int[] primes = new int[n];

        int index = 0;
        int num = 1;
        // 取够n个素数即可
        while (index < n) {
            boolean isPrime = true;
            // 除了1和自身之外，都无法被其他数整除则为素数
            for (int k = 2; k < num; k++) {
                if (num % k <= 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes[index++] = num;
            }
            num++;
        }

        // 累加从m到n之间的所有素数之和
        int sum = 0;
        for (int i = m; i < n; i++) {
            sum += primes[i];
        }

        return sum;
    }
}
