package com.practice.algorithm.other;

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
        // 根据示例得知，本题买入时需要取整，并且返回的最大收益需要加上本金
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
        // 单股最小值
        int min = arr.get(0);
        // 单股最大收益
        int maxDiff = 0;

        for (int i = 1; i < arr.size(); i++) {
            // 寻找最小值，最后一个最小值舍去
            int minTemp = min;
            if (arr.get(i - 1) < min) {
                minTemp = arr.get(i - 1);
                // 每次取最小值时，都需要重新计算一遍最大值
                int j = i;
                while (j < arr.size()) {
                    // 如果再次遇到比当前最小值更小的值，则终止计算最大值
                    int a = arr.get(j);
                    if (a < minTemp) {
                        break;
                    }
                    int currentDiff = a - minTemp;
                    if (currentDiff >= maxDiff) {
                        // 取得最大收益和最小值
                        maxDiff = currentDiff;
                        min = minTemp;
                    }
                    j++;
                }
            } else {
                // 最小值未刷新，取最大值
                int currentDiff = arr.get(i) - minTemp;
                if (currentDiff >= maxDiff) {
                    maxDiff = currentDiff;
                }
            }
        }

        // 买入股份取整
        int p = m / min;
        // 计算收益
        int res = p * maxDiff;

        // 返回本金+收益
        return m + res;
    }
}
