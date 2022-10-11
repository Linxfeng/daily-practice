package com.practice.algorithm.string;

import java.util.HashMap;
import java.util.Map;

/** 同构字符串 */
public class IsomorphicString {
    /**
     * 题目描述：
     *
     * <p>给定两个字符串 s 和 t，判断它们是否是同构的。如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
     *
     * <p>每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。
     *
     * <p>不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
     *
     * <p>示例 1：输入：s = "egg", t = "add"；输出：true
     *
     * <p>示例 2：输入：s = "foo", t = "bar"；输出：false
     *
     * <p>示例 3：输入：s = "paper", t = "title"；输出：true
     *
     * <p>提示：可以假设 s 和 t 长度相同。
     */
    public static void main(String[] args) {
        // 可以使用哈希对两个字符串的对应位置的字符作映射
        System.out.println(solution("foo", "bar"));
        System.out.println(solution("paper", "title"));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(n) */
    public static boolean solution(String s, String t) {
        // 字符串长度若不相等，则无法同构
        if (s.length() != t.length()) {
            return false;
        }
        // 使用哈希存储字符串中对应位置的字符
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            // 对应相同下标中，字符串s对应字符作为key，字符串t对应字符作为value
            char key = s.charAt(i);
            char value = t.charAt(i);
            if (map.get(key) != null) {
                if (map.get(key) != value) {
                    return false;
                }
            } else {
                if (map.containsValue(value)) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }
}
