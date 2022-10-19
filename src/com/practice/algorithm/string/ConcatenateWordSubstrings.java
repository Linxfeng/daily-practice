package com.practice.algorithm.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/** 串联单词子串 */
public class ConcatenateWordSubstrings {
    /**
     * 题目描述：
     *
     * <p>给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
     *
     * <p>注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
     *
     * <p>示例 1：输入：s = "barfoothefoobarman", words = ["foo","bar"]，输出：[0,9]
     *
     * <p>解释：从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar"。输出的顺序不重要, [9,0] 也是有效答案。
     *
     * <p>示例 2：输入： s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]，输出：[]
     */
    public static void main(String[] args) {
        System.out.println(solution("barfoothefoobarman", new String[] {"foo", "bar"}));
    }

    /** 时间复杂度：O(log n)，空间复杂度：O(n) */
    public static List<Integer> solution(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return res;
        }
        // 使用哈希
        HashMap<String, Integer> map = new HashMap<>();
        // 记录每个单词对应出现的次数
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        int firstWordLen = words[0].length();
        for (int i = 0; i < firstWordLen; i++) {
            int left = i, right = i, count = 0;

            HashMap<String, Integer> tmpMap = new HashMap<>();
            while (right + firstWordLen <= s.length()) {
                // 从i往后推第一个单词的长度
                String w = s.substring(right, right + firstWordLen);
                right += firstWordLen;

                // 若不包含此单词，清空并重新开始
                if (!map.containsKey(w)) {
                    count = 0;
                    left = right;
                    tmpMap.clear();
                } else {
                    // 出现此单词时判断是否符合条件
                    tmpMap.put(w, tmpMap.getOrDefault(w, 0) + 1);
                    count++;
                    while (tmpMap.getOrDefault(w, 0) > map.getOrDefault(w, 0)) {
                        String tw = s.substring(left, left + firstWordLen);
                        count--;
                        tmpMap.put(tw, tmpMap.getOrDefault(tw, 0) - 1);
                        left += firstWordLen;
                    }
                    // 符合条件，添加下标位置
                    if (count == words.length) {
                        res.add(left);
                    }
                }
            }
        }
        return res;
    }
}
