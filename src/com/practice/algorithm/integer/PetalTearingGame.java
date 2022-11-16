package com.practice.algorithm.integer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 撕花瓣游戏 */
public class PetalTearingGame {
    /**
     * 题目描述：
     *
     * <p>小艺酱走到一个花之占卜店中。店员小Q看到小艺酱可怜的样子，允许小艺酱免费占卜一次。
     *
     * <p>花瓣占卜： 1. 一瓣“在一起”，一瓣“不在一起”；开始的花瓣表示“在一起”。 2. 直到最后一个花瓣落地游戏结束。 3. 可以选择多朵花，选择撕一朵花就必须撕完。
     *
     * <p>输入描述：第一行输入花的数量n。(1<=n<=1000)；第二行输入每朵花的花瓣数量。(1<=a<=1e5)
     *
     * <p>输出描述：输出最多撕下了多少花瓣的结果还是在一起。
     *
     * <p>示例 1：输入 2\n 1 1；输出 1
     *
     * <p>示例 2：输入 3\n 2 2 1；输出 5
     */
    public static void main(String[] args) {
        System.out.println(solution(2, Arrays.asList(1, 1)));
        System.out.println(solution(3, Arrays.asList(2, 2, 1)));
        System.out.println(solution(4, Arrays.asList(673, 978, 637, 934)));
    }

    /** 时间复杂度：O(n log n)，空间复杂度：O(n) */
    public static int solution(int n, List<Integer> arr) {
        if (n == 1) {
            int a = arr.get(0);
            return a % 2 == 0 ? 0 : a;
        }
        int result = 0;

        // 将所有花瓣数量，偶数直接累加，奇数挑选出来
        List<Integer> odd = new ArrayList<>();
        for (Integer a : arr) {
            if (a % 2 == 1) {
                odd.add(a);
            } else {
                result += a;
            }
        }

        // 如果没有奇数，则直接返回0
        if (odd.isEmpty()) {
            return 0;
        }

        // 这里必须选择最大的奇数个数字，若size为偶数，则需要移除最小的那个数字
        if (odd.size() % 2 == 0) {
            // 从小到大排序，移除第一个
            odd.sort(Integer::compareTo);
            odd.remove(0);
        }

        // 累加
        for (Integer a : odd) {
            result += a;
        }

        return result;
    }
}
