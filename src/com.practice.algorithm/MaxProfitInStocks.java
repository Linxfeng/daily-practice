package com.practice.algorithm;

import java.util.Arrays;
import java.util.List;

/** 股票最大收益 */
public class MaxProfitInStocks {
    /**
     * 题目描述：
     *
     * <p>已知 n 天的股票行情，现在已有的本金是 m，规定只能入手一次股票和抛售一次股票。最大收益是？
     *
     * <p>输入描述：第一行输入整数n，m。(1<=n<=1000,1<=m<=10000)；第二行输入n个整数表示某股票单股价格p。(1<=p<=1000)
     *
     * <p>输出描述：输出最大收益（包含本金）。
     *
     * <p>示例 1：输入 2 4 3 7；输出 8
     */
    public static void main(String[] args) {
        // 根据示例得知，本题买入时需要取整
        System.out.println(solution(2, 4, Arrays.asList(3, 7)));
        System.out.println(solution(4, 4, Arrays.asList(3, 7, 8, 2)));
        System.out.println(solution(3, 4, Arrays.asList(3, 2, 1)));
        System.out.println(solution(6, 2, Arrays.asList(3, 9, 1, 7, 2, 8)));
    }

    /** 时间复杂度：O(n^2)，空间复杂度：O(1) */
    public static int solution(int n, int m, List<Integer> arr) {
        // 无收益时返回本金
        if (n <= 1 || arr.isEmpty()) {
            return m;
        }
        // 买入的下标
        int index = 0;
        // 每天的净值增长
        int incr = 0;
        int res = -1;
        for (int i = 1; i < arr.size(); i++) {
            // 若昨日净增长大于0，则今日的总增长=昨日+今日
            if (incr >= 0) {
                incr = arr.get(i) - arr.get(i - 1) + incr;
                // 昨日买入
                if (index < 0) {
                    index = i - 1;
                }
            } else {
                // 否则，从今天重新开始计算
                incr = arr.get(i) - arr.get(i - 1);
                index = i - 1;
            }
            // 取最大总增长
            res = Math.max(res, incr);
        }

        // 买入股份取整
        int k = arr.get(index);
        int p = m / k;
        // 一份都买不起的情况需要单独计算
        if (p == 0) {
            int idx = -1;
            int diff = 0;
            for (int i = 0; i < arr.size(); i++) {
                if (m >= arr.get(i)) {
                    // 买得起
                    idx = i;
                }
                // 从买得起一份的下标开始往后计算
                if (idx >= 0) {
                    int j = idx;
                    // 找到当前下标i后面的最大值
                    int temp = 0;
                    while (j < arr.size()) {
                        temp = Math.max(temp, arr.get(j));
                        j++;
                    }
                    // 总收益
                    int p1 = m / arr.get(idx);
                    int r = p1 * (temp - arr.get(idx));
                    diff = Math.max(diff, r);
                    idx = -1;
                }
            }
            // 买得起的最大收益diff
            return m + diff;
        }
        // 收益为负，则返回本金
        int r = p * res;
        if (r < 0) {
            return m;
        }
        // 返回本金+收益
        return m + r;
    }
}
