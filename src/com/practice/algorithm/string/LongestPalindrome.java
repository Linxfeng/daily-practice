package com.practice.algorithm.string;

/** 最长回文 */
public class LongestPalindrome {
    /**
     * 题目描述：
     *
     * <p>给你一个字符串 s，找到 s 中最长的回文子串。
     *
     * <p>示例 1：输入：s = "babad"， 输出："bab"， "aba" 同样是符合题意的答案。
     *
     * <p>示例 2：输入：s = "cbbd"， 输出："bb"
     *
     * <p>提示：1 <= s.length <= 1000， s 仅由数字和英文字母组成
     *
     * <p>来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/longest-palindromic-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        LongestPalindrome obj = new LongestPalindrome();
        // 此题目我们可以使用中心扩散法和动态规划法解决，此处我们使用中心扩散法
        System.out.println(obj.longestPalindrome("babad"));
        System.out.println(obj.longestPalindrome("cbbd"));
    }

    /** 时间复杂度：O(n^2)，空间复杂度：O(1) */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int left = i;
            int right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            int len1 = right - left - 1;

            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            int len2 = right - left - 1;

            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
}
