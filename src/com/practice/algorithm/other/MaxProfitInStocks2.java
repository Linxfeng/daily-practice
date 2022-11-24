package com.practice.algorithm.other;

/** 股票最大收益2 */
public class MaxProfitInStocks2 {
    /**
     * 题目描述：
     *
     * <p>给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     *
     * <p>设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
     *
     * <p>注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * <p>示例 1：输入：prices = [3,3,5,0,0,3,1,4] 输出：6
     *
     * <p>解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。 随后，在第 7 天（股票价格 =
     * 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
     *
     * <p>示例 2：输入：prices = [1,2,3,4,5] 输出：4
     *
     * <p>解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *
     * <p>注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     *
     * <p>示例 3：输入：prices = [7,6,4,3,1] 输出：0。解释：在这个情况下, 没有交易完成, 所以最大利润为 0。
     *
     * <p>示例 4：输入：prices = [1] 输出：0
     *
     * <p>提示：1 <= prices.length <= 10^5；0 <= prices[i] <= 10^5
     */
    public static void main(String[] args) {
        System.out.println(solution(new int[] {3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(solution(new int[] {1, 2, 3, 4, 5}));
    }

    /** 时间复杂度：O(n log n)，空间复杂度：O(n) */
    public static int solution(int[] prices) {
        int result = 0;
        int n = prices.length;

        if (n == 0) {
            return result;
        }

        // 找出第二次买入的时机
        int secondDealSell = n - 1;
        while (secondDealSell > 0) {
            if (prices[secondDealSell - 1] < prices[secondDealSell]) {
                break;
            }
            secondDealSell--;
        }

        // 找出第一次买入的时机
        int firstDealSell = 1;
        while (firstDealSell < n) {
            while (firstDealSell + 1 < n && prices[firstDealSell + 1] >= prices[firstDealSell]) {
                firstDealSell++;
            }

            // 第一次买入的收益
            int result1 = maxProfit(prices, 0, firstDealSell);
            // 第二次买入的收益
            int result2 = maxProfit(prices, firstDealSell + 1, secondDealSell);

            if (result1 + result2 > result) {
                result = result1 + result2;
            }
            firstDealSell++;
        }

        return result;
    }

    /** 返回指定区间的最大收益 */
    private static int maxProfit(int[] prices, int left, int right) {
        int result = 0;
        if (right - left < 1) {
            return result;
        }
        int minPrice = prices[left];
        for (int i = left + 1; i <= right; i++) {
            result = Math.max(result, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return result;
    }
}
