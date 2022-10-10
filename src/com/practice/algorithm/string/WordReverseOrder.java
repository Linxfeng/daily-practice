package com.practice.algorithm.string;

import java.util.ArrayList;
import java.util.List;

/** 单词逆序 */
public class WordReverseOrder {
    /**
     * 题目描述：
     *
     * <p>对于一个字符串，请设计一个算法，只在字符串的单词间做逆序调整，也就是说，字符串由一些由空格分隔的部分组成，你需要将这些部分逆序。
     * 给定一个原字符串A，请返回逆序后的字符串。例，输入“I am a boy!” 输出“boy! a am I”
     *
     * <p>输入描述：输入一行字符串str。(1<=len(str)<=10000)
     *
     * <p>输出描述：返回逆序后的字符串。
     *
     * <p>示例 1：输入 It’s a dog!；输出 dog! a It’s
     */
    public static void main(String[] args) {
        System.out.println(solution("It’s a dog!"));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(n) */
    public static List<String> solution(String str) {
        // 由于不确定每个分隔的空格个数，所以此处使用char数组的形式
        char[] chars = str.toCharArray();
        int n = str.length();

        List<String> res = new ArrayList<>();

        int i = 0;
        while (i < n) {
            // 遍历字符数组，遇到空格，跳过
            if (chars[i] == ' ') {
                i++;
                continue;
            }
            // 对于非空格字符，将其连接起来，存入res中
            StringBuilder temp = new StringBuilder();
            while (i < n && chars[i] != ' ') {
                temp.append(chars[i]);
                i++;
            }
            res.add(temp.toString());
        }

        // 将res中的字符串倒序返回
        List<String> result = new ArrayList<>();
        for (int j = res.size() - 1; j >= 0; j--) {
            result.add(res.get(j));
        }
        return result;
    }
}
