package com.practice.algorithm.dp;

import java.util.Arrays;
import java.util.List;

/** 一和零的最大子集 */
public class MaxSubsetOneAndZero {
    /**
     * 题目描述：
     *
     * <p>给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
     *
     * <p>请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
     *
     * <p>示例 1：输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3；输出：4。
     *
     * <p>解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。其他满足题意但较小的子集包括 {"0001","1"} 和
     * {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
     *
     * <p>示例 2：输入：strs = ["10", "0", "1"], m = 1, n = 1；输出：2。解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
     *
     * <p>提示：1 <= strs.length <= 600；1 <= strs[i].length <= 100；strs[i]仅由'0'和'1'组成 1 <= m,n <= 100
     *
     * <p>来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/ones-and-zeroes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        // 可使用三维动态规划求解，三个维度分别是字符串、0的容量和1的容量。
        System.out.println(solution(Arrays.asList("10", "0001", "111001", "1", "0"), 5, 3));
    }

    /** 时间复杂度：O(lmn)，空间复杂度：O(mn) */
    public static int solution(List<String> strs, int m, int n) {
        // dp[j][k] 表示使用 j 个 0 和 k 个 1 的情况下最多可以得到的字符串数量
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            // 获取每个字符串str中0和1的数量
            int[] zerosOnes = getZerosOnes(str);
            int zeros = zerosOnes[0];
            int ones = zerosOnes[1];
            // 数组赋值
            for (int j = m; j >= zeros; j--) {
                for (int k = n; k >= ones; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - zeros][k - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

    /** 获取字符串str中0和1的数量 */
    private static int[] getZerosOnes(String str) {
        int[] zerosOnes = new int[2];
        for (int i = 0; i < str.length(); i++) {
            zerosOnes[str.charAt(i) - '0']++;
        }
        return zerosOnes;
    }
}
