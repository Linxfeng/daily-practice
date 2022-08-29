package com.practice.algorithm;

import java.util.ArrayList;
import java.util.List;

/** 最大数 */
public class MaximumNumber {
    /**
     * 题目描述：最大数
     *
     * <p>给定任意一个数字 m，然后给出数字 n，则需在 m 中去掉 n 位数，保持各位顺序不变的情况下，得到最大数。
     *
     * <p>输入描述：输入整数m，n.(1<=m<=1e100,1<=n<=100)
     *
     * <p>输出描述：输出删除后的最大数。
     *
     * <p>示例1：输入 1234 2，输出 34
     */
    public static void main(String[] args) {
        // 由于题目要求的m和n的范围显然大过整数long的范围，所以此处我们使用字符串处理
        System.out.println(solution("1234", 2));
        System.out.println(solution("343", 1));
        System.out.println(solution("1342141", 5));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(n) */
    public static String solution(String m, int n) {
        if (n < 1 || m.isEmpty()) {
            return m;
        }
        // 数字长度位数
        int len = m.length();
        char[] chars = m.toCharArray();
        // 结果
        char[] res = new char[len - n];

        // 将char数组中的每一位数字进行由小到大排序
        List<Integer> list = new ArrayList<>();
        for (char c : chars) {
            list.add(c - '0');
        }
        list.sort(Integer::compareTo);

        // 截取前n位，代表要去除掉的数字
        list = list.subList(0, n);

        // 依次取值
        int i = 0;
        for (char c : chars) {
            if (list.contains(c - '0')) {
                list.remove(Integer.valueOf(c - '0'));
            } else {
                res[i++] = c;
            }
        }

        return String.valueOf(res);
    }
}
