package com.practice.algorithm.dp;

import java.util.Stack;

/** 括号染色 */
public class ColorBrackets {
    /**
     * 题目描述：
     *
     * <p>有一个字符串 s，这个字符串是一个完全匹配的括号序列。在这个完全匹配的括号序列里，每个括号都有一个和它匹配的括号
     *
     * <p>你现在可以给这个匹配的括号序列中的括号染色，且有三个要求：
     *
     * <p>1、只有三种上色方案，不上色，上红色，上蓝色。
     *
     * <p>2、每对括号只有一个上色。
     *
     * <p>3、相邻的两个括号不能上相同的颜色，但是可以都不上色。
     *
     * <p>问给括号染色有多少种方案？答案对1000000007取模。
     *
     * <p>输入描述：输入括号序列s。(2<=|s|<=700)
     *
     * <p>输出描述：输出方案数。
     *
     * <p>示例 1：输入 (()) 输出 12
     */
    public static void main(String[] args) {
        // 这道题需要用动态规划，用dp[L][R][u][v]表示区间L, R在括号s[L]涂u色，s[R]涂v色的涂色方案。
        System.out.println(solution("(())"));
    }

    public static int solution(String s) {
        // 总共有3种上色方案
        int len = 3;
        int n = s.length();

        int[] match = new int[n];
        getMatch(s.toCharArray(), match);

        // 用dp[L][R][u][v]表示区间L, R在括号s[L]涂u色，s[R]涂v色的涂色方案
        int[][][][] dp = new int[n][n][len][len];
        dfs(0, n - 1, dp, match);

        int result = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                result = (result + dp[0][n - 1][i][j]) % 1000000007;
            }
        }

        return result;
    }

    private static void dfs(int l, int r, int[][][][] dp, int[] match) {
        int mod = 1000000007;
        // 元区间
        if (l + 1 == r) {
            dp[l][r][0][1] = 1;
            dp[l][r][1][0] = 1;
            dp[l][r][2][0] = 1;
            dp[l][r][0][2] = 1;
            return;
        }
        int len = 3;
        // 为一对匹配的括号，方案数相加
        if (match[l] == r) {
            dfs(l + 1, r - 1, dp, match);
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if (j != 1) {
                        dp[l][r][0][1] = (dp[l + 1][r - 1][i][j] + dp[l][r][0][1]) % mod;
                    }
                    if (j != 2) {
                        dp[l][r][0][2] = (dp[l + 1][r - 1][i][j] + dp[l][r][0][2]) % mod;
                    }
                    if (i != 1) {
                        dp[l][r][1][0] = (dp[l + 1][r - 1][i][j] + dp[l][r][1][0]) % mod;
                    }
                    if (i != 2) {
                        dp[l][r][2][0] = (dp[l + 1][r - 1][i][j] + dp[l][r][2][0]) % mod;
                    }
                }
            }
        } else {
            // 括号不匹配，则方案数相乘
            int mid = match[l];
            dfs(l, mid, dp, match);
            dfs(mid + 1, r, dp, match);
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    for (int k = 0; k < len; k++) {
                        for (int m = 0; m < len; m++) {
                            boolean km1 = k == 1 && m == 1;
                            boolean km2 = k == 2 && m == 2;
                            if (!km1 && !km2) {
                                int t =
                                        dp[l][r][i][j]
                                                + (dp[l][mid][i][k] * dp[mid + 1][r][m][j]) % mod;
                                dp[l][r][i][j] = t % mod;
                            }
                        }
                    }
                }
            }
        }
    }

    /** 利用栈的性质得到括号的匹配数组 */
    private static void getMatch(char[] chars, int[] match) {
        Stack<Integer> q = new Stack<>();
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] == '(') {
                q.push(i);
            } else {
                int temp = q.pop();
                match[i] = temp;
                match[temp] = i;
            }
        }
    }
}
