package com.practice.algorithm.string;

/** 交换后的二进制串 */
public class SwappedBinaryString {
    /**
     * 题目描述：
     *
     * <p>给定两组长度为 n 的二进制串，请问有多少种方法在第一个串中交换两个不同位置上的数字，使得这两个二进制串“或”的结果发生改变？
     *
     * <p>输入描述：输入一个整数n (2≤n≤10^5) 接下来两行。两个长度是 n 的二进制01字符串，分别是题目描述的第一个串与第二个串
     *
     * <p>输出描述：输出一个数字，方案数量。
     *
     * <p>示例 1：输入 5 01011 11001；输出 4
     */
    public static void main(String[] args) {
        System.out.println(solution(5, "01011", "11001"));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(1) */
    public static int solution(int n, String str1, String str2) {
        // 设str1中有a个0，b个1。str2中为0位置上对应str1中0的个数为q，1的个数为p，则总的交换方案数就是ap + bq - qp。
        int a = 0, b = 0, q = 0, p = 0;

        // 仅当str2对应位置为0时，str1的两数不相等交换才能满足条件
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == '0') {
                a++;
            } else {
                b++;
            }
            if (str2.charAt(i) == '0') {
                if (str1.charAt(i) == '0') {
                    q++;
                } else {
                    p++;
                }
            }
        }

        // 总的交换方案数为 ap + bq - qp
        return a * p + b * q - q * p;
    }
}
