package com.practice.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 莫名其妙的键盘 */
public class InexplicableKeyboard {
    /**
     * 题目描述：
     *
     * <p>有一个神奇的键盘，你可以用它输入a到z的字符，然而每当你输入一个元音字母(a,e,i,o,u其中之一)的时候，已输入的字符串会发生一次反转！
     *
     * <p>比方说，当前输入了tw，此时再输入一个o，此时屏幕上的字符串two会反转成owt。现给出一个字符串，若用该键盘输入，有多少种方法可以得到？
     *
     * <p>输入描述：输入一个字符串，长度不超过200，全部是由小写字母组成。
     *
     * <p>输出描述：输出一个整数，代表方案数量
     *
     * <p>示例 1：输入 ac，输出 2
     *
     * <p>提示：我们可以先输入a，然后输入c，得到ac 也可以先输入c，在输入a，此时字符串ca发生了反转，成了ac
     */
    public static void main(String[] args) {
        // 本题可以采用循环分类递归求解
        System.out.println(solution("ac"));
    }

    /** 时间复杂度：O(log n)，空间复杂度：O(1) */
    public static int solution(String str) {
        List<Character> vowel = Arrays.asList('a', 'e', 'i', 'o', 'u');
        char[] chars = str.toCharArray();
        int n = chars.length;

        // 记录输入字符串各字符是元音还是辅音
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            // 记录元音为1，辅音为0；
            if (vowel.contains(chars[i])) {
                a[i] = 1;
            } else {
                a[i] = 0;
            }
        }

        // 记录所有得到最终字符串的情况
        Set<String> res = new HashSet<>();

        // 递归处理 chars[i ~ j]，f 表示正序或逆序，tmp 记录字符顺序
        dfs(chars, 0, n - 1, true, a, "", res);

        // 返回方案数
        return res.size();
    }

    /** 分类递归字串：正序输入、开头是元音、末尾不是元音；逆序输入、开头不是元音、末尾是元音 */
    public static void dfs(
            char[] chars, int i, int j, boolean f, int[] a, String tmp, Set<String> res) {
        if (i > j) {
            // 字符处理完毕，将最终字符串添加到集合中
            res.add(tmp);
            return;
        }
        // 正序输入剩余字符
        if (f) {
            // 末尾不是元音
            if (a[j] == 0) {
                // 递归：要正序输入 chars[i ~ j-1]
                dfs(chars, i, j - 1, true, a, tmp + chars[j], res);
            }
            // 开头是元音
            if (a[i] == 1) {
                // 递归：要逆序输入 chars[i+1 ~ j]
                dfs(chars, i + 1, j, false, a, tmp + chars[i], res);
            }
        }
        // 逆序输入剩余字符
        else {
            // 开头不是元音
            if (a[i] == 0) {
                // 递归：要逆序输入 chars[i+1 ~ j]
                dfs(chars, i + 1, j, false, a, tmp + chars[i], res);
            }
            // 末尾是元音
            if (a[j] == 1) {
                // 递归：要正序输入 chars[i ~ j-1]
                dfs(chars, i, j - 1, true, a, tmp + chars[j], res);
            }
        }
    }
}
