package com.practice.algorithm.string;

/** 消除字符串分身 */
public class EliminateStringDouble {
    /**
     * 题目描述：
     *
     * <p>已知字符串str包含字符’x’,’y’。如果相邻的两个字符不同，消除两个字符，优先从左边进行消除。xyyx - > yx -> ""
     *
     * <p>输入描述： 输入多个字符。(1<=len<=1e5)
     *
     * <p>输出描述： 输出最后的分身
     *
     * <p>示例 1：输入 xyyyy；输出 yyy
     */
    public static void main(String[] args) {
        // 字符串依次消除可能不能得出结果，需要使用递归
        System.out.println(solution("xyyyyxx"));
    }

    /** 时间复杂度：O(n log n)，空间复杂度：O(1) */
    public static String solution(String str) {
        if (str.length() <= 1) {
            return str;
        }
        char[] chars = str.toCharArray();

        // 判断字符串中是否所有字符都一样
        boolean same = true;
        char temp = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (temp != chars[i]) {
                same = false;
                break;
            }
        }
        if (same) {
            return str;
        }
        // 若只有两个不同的字符，直接消除后返回
        if (str.length() == 2) {
            return "";
        }

        // 消除不一样的字符
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                // 消除两个字符
                ++i;
                // 还剩最后一个字符了，追加上
            } else {
                result.append(chars[i - 1]);
            }
            if (i == chars.length - 1) {
                result.append(chars[i]);
            }
        }

        // 递归，继续消除
        return solution(result.toString());
    }
}
