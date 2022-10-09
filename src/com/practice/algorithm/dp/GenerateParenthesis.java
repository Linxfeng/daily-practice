package com.practice.algorithm.dp;

import java.util.ArrayList;
import java.util.List;

/** 括号生成 */
public class GenerateParenthesis {
    /**
     * 题目描述：
     *
     * <p>数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且有效的括号组合。
     *
     * <p>示例 1：输入：n = 3；输出：["((()))","(()())","(())()","()(())","()()()"]
     *
     * <p>示例 2：输入：n = 1；输出：["()"]
     *
     * <p>提示：1 <= n <= 8
     *
     * <p>来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/generate-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        // 可使用回溯法求解
        System.out.println(solution(3));
    }

    /** 时间复杂度：O(4^n/√n)，空间复杂度：O(n) */
    public static List<String> solution(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    public static void backtrack(
            List<String> ans, StringBuilder cur, int open, int close, int max) {
        // 当左右括号的数量之和为2n时，已经生成完毕
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        // 当左括号数量小于n时，可添加一个左括号
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            // 删掉最后一位，回溯
            cur.deleteCharAt(cur.length() - 1);
        }
        // 当右括号数量小于左括号时，可添加一个右括号
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            // 删掉最后一位，回溯
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
