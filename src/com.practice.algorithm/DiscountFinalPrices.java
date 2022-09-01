package com.practice.algorithm;

import java.util.Arrays;

/** 商品折扣后的最终价格 */
public class DiscountFinalPrices {
    /**
     * 题目描述：
     *
     * <p>给你一个数组 prices，其中 prices[i]是商店里第i件商品的价格。
     *
     * <p>商店里正在进行促销活动，如果你要买第 i 件商品，那么你可以得到与 prices[j] 相等的折扣，其中 j 是满足 j > i 且 prices[j] <= prices[i]
     * 的最小下标，如果没有满足条件的 j，你将没有任何折扣。
     *
     * <p>请你返回一个数组，数组中第 i 个元素是折扣后你购买商品 i 最终需要支付的价格。
     *
     * <p>示例 1：输入：prices = [8,4,6,2,3]，输出：[4,2,4,2,3]；解释：8-4=4，4-2=2，6-2=4，2 3无折扣
     *
     * <p>示例 2：输入：prices = [1,2,3,4,5]，输出：[1,2,3,4,5]
     *
     * <p>示例 3：输入：prices = [10,1,1,6]，输出：[9,0,1,6]
     *
     * <p>提示：1 <= prices.length <= 500，1 <= prices[i] <= 10^3
     *
     * <p>来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/final-prices-with-a-special-discount-in-a-shop
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(finalPrices(new int[] {8, 4, 6, 2, 3})));
        System.out.println(Arrays.toString(finalPrices(new int[] {1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(finalPrices(new int[] {10, 1, 1, 6})));
    }

    /** 时间复杂度：O(n^2)，空间复杂度：O(1) */
    public static int[] finalPrices(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return prices;
        }
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            // 从i+1开始往后找符合条件的，算出折扣
            int s = 0;
            for (int j = i + 1; j < n; j++) {
                if (prices[j] <= prices[i]) {
                    s = prices[j];
                    break;
                }
            }
            res[i] = prices[i] - s;
        }
        return res;
    }
}
