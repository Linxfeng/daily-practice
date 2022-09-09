package com.practice.algorithm;

import java.util.HashSet;
import java.util.Set;

/** 不重复字符最长子串 */
public class LongestSubstring {
    /**
     * 题目描述：
     *
     * <p>给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
     *
     * <p>示例 1：输入: s = "abcabcbb"；输出: 3。解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     * <p>示例 2：输入: s = "bbbbb"；输出: 1。解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     *
     * <p>示例 3：输入: s = "pwwkew"；输出: 3。解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *
     * <p>请注意，你的答案必须是子串的长度，"pwke" 是一个子序列，不是子串。
     *
     * <p>提示：0 <= s.length <= 5 * 104；s 由英文字母、数字、符号和空格组成
     *
     * <p>来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        // 使用滑动窗口，从左至右依次找出最长不重复的字符串长度即可
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(∣Σ∣) */
    public static int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        int res = 0;
        // 右指针，初始值为 -1
        int rk = -1;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个无重复字符子串
            res = Math.max(res, rk - i + 1);
        }
        return res;
    }
}
