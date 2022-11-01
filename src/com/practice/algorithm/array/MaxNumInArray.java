package com.practice.algorithm.array;

import java.util.Arrays;

/** 拼接数组最大数 */
public class MaxNumInArray {
    /**
     * 题目描述：
     *
     * <p>给定长度分别为 m 和 n 的两个数组，其元素由 0-9 构成，表示两个自然数各位上的数字。
     *
     * <p>现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
     *
     * <p>求满足该条件的最大数。结果返回一个表示该最大数的长度为 k 的数组。
     *
     * <p>说明: 请尽可能地优化你算法的时间和空间复杂度。
     *
     * <p>示例 1：输入: nums1 = [3, 4, 6, 5]，nums2 = [9, 1, 2, 5, 8, 3]，k = 5；输出: [9, 8, 6, 5, 3]
     *
     * <p>示例 2：输入: nums1 = [6, 7]，nums2 = [6, 0, 4]，k = 5；输出: [6, 7, 6, 0, 4]
     *
     * <p>示例 3：输入: nums1 = [3, 9]，nums2 = [8, 9]，k = 3；输出: [9, 8, 9]
     */
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(solution(new int[] {3, 4, 6, 5}, new int[] {9, 1, 2, 5, 8, 3}, 5)));
    }

    /** 时间复杂度：O(n log n)，空间复杂度：O(n) */
    public static int[] solution(int[] nums1, int[] nums2, int k) {
        int[] res = null;
        int i = Math.max(k - nums2.length, 0);
        int min = Math.min(nums1.length, k);

        while (i <= min) {
            // 将每次合并后的数组和res数组比较，取较大的数组
            int[] merge = merge(maxInNums(nums1, i), maxInNums(nums2, k - i));
            res = (res == null || greater(merge, 0, res, 0)) ? merge : res;
            i++;
        }

        return res;
    }

    /** 从数组nums中找出k个最大的数，按照数组的顺序返回 */
    private static int[] maxInNums(int[] nums, int k) {
        int[] max = new int[k];
        int len = nums.length;

        for (int i = 0, j = 0; i < len; ++i) {
            while (j > 0 && k - j < len - i && max[j - 1] < nums[i]) {
                --j;
            }
            if (j < k) {
                max[j++] = nums[i];
            }
        }
        return max;
    }

    /** 合并两个数组，按顺序将最大的值合并为一个数组 */
    private static int[] merge(int[] nums1Max, int[] nums2Max) {
        int lenCurRes = nums1Max.length + nums2Max.length;
        int[] curRes = new int[lenCurRes];

        for (int i = 0, j = 0, m = 0; m < lenCurRes; ++m) {
            curRes[m] = greater(nums1Max, i, nums2Max, j) ? nums1Max[i++] : nums2Max[j++];
        }
        return curRes;
    }

    /** 比较数组中的数字大小，判断nums1Max是否比nums2Max大 */
    private static boolean greater(int[] nums1Max, int i, int[] nums2Max, int j) {
        int lenNums1Max = nums1Max.length;
        int lenNums2Max = nums2Max.length;

        // 如果对应的数字相等，则继续往后比较
        while (i < lenNums1Max && j < lenNums2Max && nums1Max[i] == nums2Max[j]) {
            ++i;
            ++j;
        }
        // 判断nums1Max是否比nums2Max大
        return j == lenNums2Max || (i < lenNums1Max && nums1Max[i] > nums2Max[j]);
    }
}
