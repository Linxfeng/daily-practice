package com.practice.algorithm;

/** 不同的子序列 */
public class DifferentSubsequences {
    /**
     * 题目描述：
     *
     * <p>给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
     *
     * <p>字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
     *
     * <p>例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是。题目数据保证答案符合 32 位带符号整数范围。
     *
     * <p>示例 1：输入：s = "rabbbit", t = "rabbit"；输出：3
     *
     * <p>解释：有 3 种（依次删除3个不同位置的字母b）可以从 s 中得到 "rabbit" 的方案。
     *
     * <p>示例 2：输入：s = "babgbag", t = "bag"；输出： 5
     *
     * <p>解释：有 5 种可以从 s 中得到 "bag" 的方案。（第一个字符ba+两个g、前两个b和第二个ag、最后一个bag，共5种）
     *
     * <p>提示：0 <= s.length, t.length <= 1000，s 和 t 由英文字母组成
     */
    public static void main(String[] args) {
        // 可以使用动态规划
        System.out.println(solution("rabbbit", "rabbit"));
        System.out.println(solution("babgbag", "bag"));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(1) */
    public static int solution(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();

        // 使用动态规划，用数组dp来存储字符串对应的方案数
        int[][] dp = new int[n1 + 1][n2 + 1];

        // 初始化
        for (int i = 0; i <= n1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                // 如果遇到字符相等，方案数累加
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n1][n2];
    }
}
