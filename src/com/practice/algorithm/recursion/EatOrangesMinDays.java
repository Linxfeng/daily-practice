package com.practice.algorithm.recursion;

import java.util.HashMap;
import java.util.Map;

/** 吃掉 N 个橘子的最少天数 */
public class EatOrangesMinDays {
    private final Map<Integer, Integer> map = new HashMap<>();

    /**
     * 题目描述：
     *
     * <p>厨房里总共有 n 个橘子，你决定每一天选择如下方式之一吃这些橘子：
     *
     * <p>1. 吃掉一个橘子。
     *
     * <p>2. 如果剩余橘子数 n 能被 2 整除，那么你可以吃掉 n/2 个橘子。
     *
     * <p>3. 如果剩余橘子数 n 能被 3 整除，那么你可以吃掉 2*(n/3) 个橘子。
     *
     * <p>每天你只能从以上 3 种方案中选择一种方案。请你返回吃掉所有 n 个橘子的最少天数。
     *
     * <p>示例：输入n = 10，输出4，输入n = 6，输出3，输入n = 56，输出6。
     *
     * <p>来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/minimum-number-of-days-to-eat-n-oranges
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        EatOrangesMinDays eatOrangesMinDays = new EatOrangesMinDays();
        System.out.println(eatOrangesMinDays.minDays(56));
    }

    /** 时间复杂度：O(log^2 n)，空间复杂度：O(log^2 n) */
    public int minDays(int n) {
        if (n <= 1) {
            return n;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        // 使用递归，自顶向下通过map记忆化搜索，得出最优解
        map.put(n, Math.min(n % 2 + minDays(n / 2) + 1, n % 3 + minDays(n / 3) + 1));
        return map.get(n);
    }
}
