package com.practice.algorithm.dp;

import java.util.Arrays;

/** 不同的子序列2 */
public class DifferentSubsequences2 {
    /**
     * 题目描述：
     *
     * <p>给定一个字符串 s，计算 s 的 不同非空子序列 的个数。因为结果可能很大，所以返回答案需要对 10^9 + 7 取余 。
     *
     * <p>字符串的 子序列 是经由原字符串删除一些（也可能不删除）字符但不改变剩余字符相对位置的一个新字符串。
     *
     * <p>例如，"ace" 是 "abcde" 的一个子序列，但 "aec" 不是。
     *
     * <p>示例 1：输入：s = "abc"，输出：7。解释：7 个不同的子序列分别是 "a", "b", "c", "ab", "ac", "bc", 以及 "abc"。
     *
     * <p>示例 2：输入：s = "aba"，输出：6。解释：6 个不同的子序列分别是 "a", "b", "ab", "ba", "aa" 以及 "aba"。
     *
     * <p>示例 3：输入：s = "aaa" 输出：3。解释：3 个不同的子序列分别是 "a", "aa" 以及 "aaa"。
     *
     * <p>提示：1 <= s.length <= 2000；s 仅由小写英文字母组成。
     *
     * <p>来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/distinct-subsequences-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        // 使用动态规划
        System.out.println(solution("abc"));
        System.out.println(solution("aba"));
        System.out.println(solution("aaa"));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(n) */
    public static int solution(String s) {
        // 用 dp[i] 表示以 s[i] 为最后一个字符的子序列的数目。
        int n = s.length();
        int[] dp = new int[n];

        // 初始化：如果子序列中只有 s[i] 这一个字符，那么有一种方案
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // 用 last[k] 记录第 k (0≤k<26) 个小写字母最后一次出现的位置。
        int[] last = new int[26];
        // 如果对应字母还没有出现过，则 last[k]=−1
        Arrays.fill(last, -1);

        int mod = 1000000007;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                if (last[j] != -1) {
                    dp[i] = (dp[i] + dp[last[j]]) % mod;
                }
            }
            // 字母出现位置赋值
            last[s.charAt(i) - 'a'] = i;
        }

        int result = 0;
        for (int i = 0; i < 26; i++) {
            if (last[i] != -1) {
                result = (result + dp[last[i]]) % mod;
            }
        }

        return result;
    }
}
