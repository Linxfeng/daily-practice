package com.practice.algorithm.other;

/** 小鱼的航程(改进版) */
public class VoyageOfTheFish {
    /**
     * 题目描述：
     *
     * <p>有一只小鱼，它平日每天游泳250公里，周末休息（实行双休日)。假设从周x开始算起，过了n天以后，小鱼一共累计游泳了多少公里呢？
     *
     * <p>输入格式：输入两个正整数 x, n，表示从周 x 算起，经过 n 天。
     *
     * <p>输出格式：输出一个整数，表示小鱼累计游泳了多少公里。
     *
     * <p>数据保证，1 <= x <= 7, 1 <= n <= 10^6 。
     *
     * <p>示例：输入3 10，输出2000
     *
     * <p>来源：洛谷 P1424 小鱼的航程(改进版) 链接：https://www.luogu.com.cn/problem/P1424
     */
    public static void main(String[] args) {
        System.out.println(solution(2, 10));
    }

    /** 时间复杂度：O(1)，空间复杂度：O(1) */
    public static long solution(int x, long n) {
        // 一周工作5天
        int r = 5;
        // 工作日每天游250公里
        int s = 250;

        // 累计游泳的公里数
        long result = 0;
        int sum;

        // 计算周x在开始游泳之前，若满勤则多出来多少公里
        if (x > r) {
            sum = s * r;
        } else {
            sum = s * (x - 1);
        }

        // 满勤几周，每周5天，总的公里数
        long week = (x + n - 1) / 7;
        if (week > 0) {
            result = week * r * s;
        }

        // 最后一周剩余几天，游的公里数
        long left = (x + n - 1) % 7;
        if (left > r) {
            result += s * r;
        } else {
            result += s * left;
        }

        // 结果 = 总公里数 - 第一周开始游泳之前满勤的公里数
        return result - sum;
    }
}
