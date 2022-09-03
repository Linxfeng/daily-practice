package com.practice.algorithm;

import java.util.Arrays;
import java.util.Comparator;

/** 最长数对链 */
public class LongestPairChain {
    /**
     * 题目描述：
     *
     * <p>给出 n 个数对。在每一个数对中，第一个数字总是比第二个数字小。
     *
     * <p>现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d)才可以跟在(a, b)后面。我们用这种形式来构造一个数对链。
     *
     * <p>给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
     *
     * <p>示例：输入：[[1,2], [2,3], [3,4]]，输出：2；解释：最长的数对链是 [1,2] -> [3,4]
     *
     * <p>提示：给出数对的个数在 [1, 1000] 范围内。
     *
     * <p>来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/maximum-length-of-pair-chain
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        // 此题可使用贪心算法求解
        int[][] pairs = new int[][] {new int[] {2, 3}, new int[] {1, 2}, new int[] {3, 4}};
        System.out.println(findLongestChain(pairs));

        // [[-6,9],[1,6],[8,10],[-1,4],[-6,-2],[-9,8],[-5,3],[0,3]] // 3
        int[][] pairs2 =
                new int[][] {
                    new int[] {-6, 9},
                    new int[] {1, 6},
                    new int[] {8, 10},
                    new int[] {-1, 4},
                    new int[] {-6, -2},
                    new int[] {-9, 8},
                    new int[] {-5, 3},
                    new int[] {0, 3}
                };
        System.out.println(findLongestChain(pairs2));
    }

    /** 时间复杂度：O(n log n)，空间复杂度：O(log n) */
    public static int findLongestChain(int[][] pairs) {
        // 根据数组中第二个数来排序，才能使数对链最长
        Arrays.sort(pairs, Comparator.comparingInt(n -> n[1]));

        int count = 1;
        int index = 0;
        for (int i = 1; i < pairs.length; i++) {
            // 依次寻找符合条件的数对
            if (pairs[index][1] < pairs[i][0]) {
                count++;
                index = i;
            }
        }
        return count;
    }
}
