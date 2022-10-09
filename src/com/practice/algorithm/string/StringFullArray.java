package com.practice.algorithm.string;

import java.util.*;

/** 字符串全排列 */
public class StringFullArray {
    /**
     * 题目描述：
     *
     * <p>对K个不同字符的全排列组成的数组, 面试官从中随机拿走了一个, 剩下的数组作为输入, 请帮忙找出这个被拿走的字符串?
     *
     * <p>输入描述：第一行输入整数n，表示给定n个字符串。(n == x!-1,2<=x<=10) 以下n行每行输入一个字符串。
     *
     * <p>输出描述：输出全排列缺少的字符串。
     *
     * <p>示例1：输入 5 ABC ACB BAC CAB CBA，输出 BCA
     */
    public static void main(String[] args) {
        // 这道题显然不能直接对给定的字符做全排列
        List<String> list = Arrays.asList("ABC", "ACB", "BAC", "CAB", "CBA");
        // 可以找出全排列的规律，例如我们可以对给定数组中每个字符串的对应下标找出缺失的字符
        System.out.println(stringFullArray(5, list));
        System.out.println(stringFullArray(1, Collections.singletonList("AB")));
    }

    /** 时间复杂度：O(log^2 n)，空间复杂度：O(n) */
    public static String stringFullArray(int n, List<String> list) {
        if (list.isEmpty() || list.size() != n) {
            return "";
        }
        // 获取字符串的长度
        int length = list.get(0).length();

        // 存储结果的字符
        char[] res = new char[length];

        // 如果只有两位，则直接取反
        if (length == 2) {
            String s = list.get(0);
            res[0] = s.charAt(1);
            res[1] = s.charAt(0);
            return new String(res);
        }

        // 我们使用一个哈希来存储每个字符串的对应下标位置的字符和对应出现的次数
        Map<Character, Integer> map = new HashMap<>();

        // 字符串下标
        int index = 0;
        while (index < length) {
            // 找出每个下标位置的字符的出现次数
            for (String s : list) {
                char c = s.charAt(index);
                int i = 1;
                if (map.containsKey(c)) {
                    i += map.get(c);
                }
                map.put(c, i);
            }
            // 找出次数缺失的那个字符
            char c = '0';
            int t = length;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                // 出现最少的次数时，给c赋值
                int i = entry.getValue();
                if (i < t) {
                    t = i;
                    c = entry.getKey();
                }
            }
            // 给结果赋值，下标+1，切记一定要清空这个map，否则会影响下一轮下标字符的查找
            res[index] = c;
            map.clear();
            index++;
        }

        return new String(res);
    }
}
