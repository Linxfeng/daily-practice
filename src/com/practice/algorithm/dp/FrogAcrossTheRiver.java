package com.practice.algorithm.dp;

import java.util.Arrays;
import java.util.List;

/** 青蛙过河 */
public class FrogAcrossTheRiver {
    /**
     * 题目描述：
     *
     * <p>在河上有一座独木桥，一只青蛙想沿着独木桥从河的一侧跳到另一侧。在桥上有一些石子，青蛙很讨厌踩在这些石子上。
     *
     * <p>我们可以把独木桥上青蛙可能到达的点看成数轴上的一串整点：0,1,⋯,L（其中 L 是桥的长度）。
     *
     * <p>青蛙从桥的起点开始，不停的向终点方向跳跃。题目给出独木桥的长度 L，青蛙跳跃的距离范围 S,T，桥上石子的位置。
     *
     * <p>求青蛙要想过河，最少需要踩到的石子数。
     *
     * <p>输入描述：第一行输入1个整数L(1<=L<=1e9)。第二行输入3个整数：s、t、m(1<=s<=t<=10，1<=m<=100)。
     * 第三行输入m个不同的整数，表示m个石子在数轴上的分布位置。
     *
     * <p>输出描述：输出青蛙过河最少会踩到的石子数量。
     *
     * <p>示例 1：输入 10\n 2 3 5\n 2 3 5 6 7;输出 2
     *
     * <p>提示 1、起点坐标为0，终点坐标为L。2、保证起点终点没有石子。3、最后一步可以越过河岸，到达大于L的位置
     */
    public static void main(String[] args) {
        // 可使用动态规划求解，需要注意空间溢出
        System.out.println(solution(10, Arrays.asList(2, 3, 5), Arrays.asList(2, 3, 5, 6, 7)));
    }

    /** 时间复杂度：O(n log n)，空间复杂度：O(n log n) */
    public static int solution(int l, List<Integer> arr1, List<Integer> arr2) {
        int result = 0;
        if (arr2.size() == 0) {
            return result;
        }

        // 最小/最大跳跃距离
        int min = arr1.get(0);
        int max = arr1.get(1);

        // 特判最小最大距离相等的情况
        if (min == max) {
            int i = 0;
            while (i <= l) {
                if (arr2.contains(i * min)) {
                    result++;
                }
                i++;
            }
            return result;
        }

        arr2.sort(Integer::compareTo);
        int n = arr2.size();

        // vis[i]标记坐标为i的位置是否有石子
        boolean[] vis = new boolean[l];

        // d[i]标识第i个石头所在的坐标位置
        int[] d = new int[n];
        d[0] = arr2.get(0);
        vis[d[0]] = true;

        // 裴蜀定理：对于任意的x和y都能够找到a和b使得a*x+b*y=gcd(x,y)成立
        // 设最小跳跃距离为s，则当两个石子之间的距离大于s*(s+1)时，我们就可以把他们之间的距离变为s*(s+1)
        int p = min * (min + 1);

        for (int i = 1; i < n; i++) {
            int c = arr2.get(i) - arr2.get(i - 1);
            if (c > p) {
                d[i] = d[i - 1] + p;
            } else {
                d[i] = d[i - 1] + c;
            }
            // 标识石头坐标
            vis[d[i]] = true;
        }

        // 最后一步跳的距离不肯能超过最大距离
        int maxL = d[n - 1] + max;

        // dp[i]表示跳到坐标i的位置时所踩到的最少石子数
        int[] dp = new int[maxL];

        for (int i = 1; i < maxL; i++) {
            dp[i] = n;
        }
        dp[0] = 0;

        for (int i = min; i < maxL; i++) {
            for (int j = min; j <= Math.min(max, i); j++) {
                int v = vis[i] ? 1 : 0;
                dp[i] = Math.min(dp[i], dp[i - j] + v);
            }
        }

        result = l;
        for (int i = d[n - 1]; i < maxL; i++) {
            result = Math.min(result, dp[i]);
        }

        return result;
    }
}
