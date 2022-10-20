package com.practice.algorithm.string;

/** 最短回文 */
public class ShortestPalindrome {
    /**
     * 题目描述：
     *
     * <p>给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
     *
     * <p>示例 1：输入：s = "aacecaaa"；输出："aaacecaaa"
     *
     * <p>示例 2：输入：s = "abcd"；输出："dcbabcd"
     *
     * <p>提示：0 <= s.length <= 5 * 10^4；s 仅由小写英文字母组成
     */
    public static void main(String[] args) {
        System.out.println(shortestPalindrome("aacecaaa"));
        System.out.println(shortestPalindrome("abcd"));
    }

    /** 时间复杂度：O(log n)，空间复杂度：O(2n) */
    public static String shortestPalindrome(String s) {
        StringBuilder r = new StringBuilder(s).reverse();
        String str = s + "#" + r;
        int[] next = next(str);
        // 获取要添加的前缀
        String prefix = r.substring(0, r.length() - next[str.length()]);
        // 返回结果的回文串
        return prefix + s;
    }

    private static int[] next(String s) {
        int[] next = new int[s.length() + 1];
        next[0] = -1;
        int k = -1;
        int i = 1;
        while (i < next.length) {
            if (k == -1 || s.charAt(k) == s.charAt(i - 1)) {
                next[i++] = ++k;
            } else {
                k = next[k];
            }
        }
        return next;
    }
}
