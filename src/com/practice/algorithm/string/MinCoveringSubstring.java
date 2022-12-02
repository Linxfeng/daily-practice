package com.practice.algorithm.string;

/** 最小覆盖子串 */
public class MinCoveringSubstring {
    /**
     * 题目描述：
     *
     * <p>给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
     *
     * <p>如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     *
     * <p>注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
     *
     * <p>示例 1：输入：s = "ADOBECODEBANC", t = "ABC" 输出："BANC"
     *
     * <p>示例 2：输入：s = "a", t = "a" 输出："a"
     *
     * <p>提示：1 <= s.length, t.length <= 10^5；s 和 t 由英文字母组成
     *
     * <p>进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
     */
    public static void main(String[] args) {
        System.out.println(solution("ADOBECODEBANC", "ABC"));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(n) */
    public static String solution(String s, String t) {
        int[] sa = new int[128];
        int[] ta = new int[128];

        int min = Integer.MAX_VALUE;
        String res = "";

        // 转化为字符char数组
        for (int i = 0; i < t.length(); i++) {
            ta[t.charAt(i)]++;
        }

        int count = 0;
        int end = 0;
        int start = 0;

        // 从字符串s中寻找ta
        while (end < s.length()) {
            // 含有字符
            if (ta[s.charAt(end)] != 0) {
                if (sa[s.charAt(end)] < ta[s.charAt(end)]) {
                    count++;
                }
                sa[s.charAt(end)]++;
            }

            if (count == t.length()) {
                while (ta[s.charAt(start)] == 0 || sa[s.charAt(start)] > ta[s.charAt(start)]) {
                    if (sa[s.charAt(start)] > ta[s.charAt(start)]) {
                        sa[s.charAt(start)]--;
                    }
                    start++;
                }

                if (end - start + 1 < min) {
                    res = s.substring(start, end + 1);
                    min = end - start + 1;
                }
            }
            end++;
        }

        return res;
    }
}
