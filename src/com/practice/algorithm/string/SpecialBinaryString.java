package com.practice.algorithm.string;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/** 特殊的二进制序列 */
public class SpecialBinaryString {
    /**
     * 题目描述：
     *
     * <p>特殊的二进制序列是具有以下两个性质的二进制序列： 1. 0的数量与1的数量相等。 2.二进制序列的每一个前缀码中1的数量要大于等于0的数量。
     *
     * <p>给定一个特殊的二进制序列S ，以字符串形式表示。定义一个操作为首先选择S的两个连续且非空的特殊的子串，然后将它们交换。
     * （两个子串为连续的当且仅当第一个子串的最后一个字符恰好为第二个子串的第一个字符的前一个字符。)
     *
     * <p>在任意次数的操作之后，交换后的字符串按照字典序排列的最大的结果是什么？
     *
     * <p>示例 1：输入: S = "11011000" 输出: "11100100"
     *
     * <p>解释: 将子串"10"（在S[1]出现）和"1100"（在S[3]出现）进行交换。这是在进行若干次操作后按字典序排列最大的结果。
     *
     * <p>说明: 1. S的长度不超过50。 2. S保证为一个满足上述定义的特殊的二进制序列。
     *
     * <p>来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/special-binary-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        SpecialBinaryString sbs = new SpecialBinaryString();
        String s = sbs.makeLargestSpecial("11011000");
        System.out.println(s);
    }

    /** 时间复杂度：O(n^2)，空间复杂度：O(n) */
    public String makeLargestSpecial(String s) {
        // 当字符串<=2时，只能是10或者空，直接返回
        if (s.length() <= 2) {
            return s;
        }
        List<String> sub = new ArrayList<>();
        // 计数器，从头遍历字符串，遇到1计数器+1，遇到0计数器-1
        int count = 0, left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ++count;
            } else {
                --count;
            }
            // 当计数器为0时，我们就拆分出了一个整体的特殊序列
            if (count == 0) {
                String substring = makeLargestSpecial(s.substring(left + 1, i));
                // 递归，继续拆分
                sub.add("1" + substring + "0");
                left = i + 1;
            }
        }

        // 按照字典顺序进行降序排序，将最大结果返回
        sub.sort(Comparator.reverseOrder());
        StringBuilder str = new StringBuilder();
        sub.forEach(str::append);
        return str.toString();
    }
}
