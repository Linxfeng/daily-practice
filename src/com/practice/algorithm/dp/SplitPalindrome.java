package com.practice.algorithm.dp;

import java.util.ArrayList;
import java.util.List;

/** 分割回文串 */
public class SplitPalindrome {
    /**
     * 题目描述：
     *
     * <p>给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
     *
     * <p>回文串是正着读和反着读都一样的字符串。
     *
     * <p>示例 1：输入：s = "aab"；输出：[["a","a","b"],["aa","b"]]
     *
     * <p>示例 2：输入：s = "a"；输出：[["a"]]
     *
     * <p>提示：1 <= s.length <= 16；s 仅由小写英文字母组成
     */
    public static void main(String[] args) {
        // 使用动态规划求解
        System.out.println(solution("aab"));
    }

    /** 时间复杂度：O(n log n)，空间复杂度：O(n) */
    public static List<List<String>> solution(String s) {
        // 使用动态规划，dp[i][j]表示在位置i和位置j的字符是否相等
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i <= s.length() - len; i++) {
                // 赋初始值，当字符串长度为1时，必是回文
                if (len == 1) {
                    dp[i][i] = true;
                } else if (s.charAt(i) == s.charAt(i + len - 1)
                        && (len == 2 || dp[i + 1][i + len - 2])) {
                    // 对称位置字符相等时，也是回文
                    dp[i][i + len - 1] = true;
                }
            }
        }
        // 使用递归从0开始，将符合条件的字符串子串找出返回
        return solution(s, 0, dp);
    }

    public static List<List<String>> solution(String s, int start, boolean[][] dp) {
        List<List<String>> list = new ArrayList<>();
        if (start == s.length()) {
            List<String> li = new ArrayList<>();
            list.add(li);
            return list;
        }
        for (int i = start; i < s.length(); i++) {
            if (dp[start][i]) {
                String first = s.substring(start, i + 1);
                for (List<String> li : solution(s, i + 1, dp)) {
                    li.add(0, first);
                    list.add(li);
                }
            }
        }
        return list;
    }
}
