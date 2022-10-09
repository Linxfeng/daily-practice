package com.practice.algorithm.integer;

/** 整数计数 */
public class IntegerCount {
    /**
     * 题目描述：
     *
     * <p>试计算在区间 1 到 n 的所有整数中，数字 x(0 ≤ x ≤ 9) 共出现了多少次？
     *
     * <p>例如，在 1 到 11 中，即在 1,2,3,4,5,6,7,8,9,10,11 中，数字 1 出现了 4 次。
     *
     * <p>输入描述：输入 2 个整数 n,x，之间用一个空格隔开。
     *
     * <p>输出描述：输出 1 个整数，表示 x 出现的次数。
     *
     * <p>示例 1：输入 11 1，输出 4
     */
    public static void main(String[] args) {
        System.out.println(solution(11, 1));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(1) */
    public static int solution(int n, int x) {
        // 将数字x(0 ≤ x ≤ 9)转化为字符串和字符char
        String xs = String.valueOf(x);
        char xc = xs.toCharArray()[0];

        int result = 0;
        // 从1开始遍历到数字n
        for (int i = 1; i <= n; i++) {
            String s = String.valueOf(i);
            // 若当前数字含有数字x
            if (s.contains(xs)) {
                // 只有一位数字，出现次数+1，继续循环
                if (s.length() == 1) {
                    result++;
                    continue;
                }
                // 当前数字有多位，需要每一位进行匹配
                char[] chars = s.toCharArray();
                for (char c : chars) {
                    if (c == xc) {
                        result++;
                    }
                }
            }
        }
        // 返回数字x出现的次数
        return result;
    }
}
