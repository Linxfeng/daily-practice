package com.practice.algorithm;

/** 整数最大交换 */
public class IntegerMaxSwap {
    /**
     * 题目描述：
     *
     * <p>给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
     *
     * <p>示例 1：输入: 2736，输出: 7236；解释: 交换数字2和数字7。
     *
     * <p>示例 2：输入: 9973，输出: 9973；解释: 不需要交换。
     *
     * <p>注意：给定数字的范围是 [0, 10^8]
     *
     * <p>来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/maximum-swap
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        // 这道题可以使用贪心算法，从右侧开始，扫描较大的数和左侧较小的数进行交换
        System.out.println(maximumSwap(2736));
    }
    /** 时间复杂度：O(log n)，空间复杂度：O(log n) */
    public static int maximumSwap(int num) {
        // 将数字转化为char数组
        char[] chars = String.valueOf(num).toCharArray();
        int n = chars.length;

        // 最大值的下标
        int maxIdx = n - 1;
        // 用于交换的两个下标
        int idx1 = -1, idx2 = -1;

        // 从右向左
        for (int i = n - 1; i >= 0; i--) {
            if (chars[i] > chars[maxIdx]) {
                maxIdx = i;
            } else if (chars[i] < chars[maxIdx]) {
                // 分别获取到用于交换的数字下标
                idx1 = i;
                idx2 = maxIdx;
            }
        }
        // 有符合条件的交换场景
        if (idx1 >= 0) {
            // 交换
            char temp = chars[idx1];
            chars[idx1] = chars[idx2];
            chars[idx2] = temp;
            return Integer.parseInt(new String(chars));
        } else {
            // 不需要交换
            return num;
        }
    }
}
