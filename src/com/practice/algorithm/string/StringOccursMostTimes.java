package com.practice.algorithm.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 字符串出现次数 */
public class StringOccursMostTimes {
    /**
     * 题目描述：
     *
     * <p>给定很多字符串，请返回出现次数最多的字符串
     *
     * <p>若多个字符串出现次数相同，默认输出第一个
     *
     * <p>输入描述：输入n个字符串。(1<=n<=1000)
     *
     * <p>输出描述：输出出现次数最多的字符串
     *
     * <p>示例 1：输入 red,red,green,green,hen 输出 red
     */
    public static void main(String[] args) {
        System.out.println(solution(Arrays.asList("red", "red", "green", "green", "hen")));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(n) */
    public static String solution(List<String> vector) {
        // 可以使用哈希来存储每个字符串对应的出现次数
        Map<String, Integer> map = new HashMap<>();
        for (String s : vector) {
            int m = 1;
            if (map.containsKey(s)) {
                m += map.get(s);
            }
            map.put(s, m);
        }

        // 找出出现次数最多的字符串
        String result = "";
        int max = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (max < entry.getValue()) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }
}
