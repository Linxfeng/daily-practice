package com.practice.algorithm.array;

/** 寻找正序数组的中位数 */
public class FindMedianSortedArrays {
    /**
     * 题目描述：
     *
     * <p>给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数 。
     *
     * <p>算法的时间复杂度应该为 O(log (m+n)) 。
     *
     * <p>示例 1：输入：nums1 = [1,3], nums2 = [2]；输出：2.00000；解释：合并数组 = [1,2,3] ，中位数 2
     *
     * <p>示例 2：输入：nums1 = [1,2], nums2 = [3,4]；输出：2.50000；解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     *
     * <p>提示：nums1.length == m，nums2.length == n，0 <= m,n <= 1000，-10^6 <= nums1[i],nums2[i] <= 10^6
     *
     * <p>来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/median-of-two-sorted-arrays
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        // 按照示例，直接合并数组，得到中位数即可
        System.out.println(findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4}));
    }

    /** 时间复杂度：O(log (m+n))，空间复杂度：O(1) */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int s = m + n;

        if (s == 0) {
            return 0;
        }

        // 获取中位数的下标
        int index1, index2;

        // 数组长度为偶数
        if (s % 2 == 0) {
            index1 = s / 2 - 1;
            index2 = index1 + 1;
        } else {
            //  数组长度为奇数
            index1 = s / 2;
            index2 = index1;
        }

        // 考虑其中一个数组为空的情况
        if (m == 0) {
            double res = nums2[index1] + nums2[index2];
            return res / 2;
        }
        if (n == 0) {
            double res = nums1[index1] + nums1[index2];
            return res / 2;
        }

        // 合并数组，得到一个正序的数组(不需要合并完，只需合并到中位数下标即可)
        int res1 = 0, res2 = 0;
        int temp;
        int i = 0, j = 0, k = 0;
        while (i <= index2) {
            // 考虑下标越界情况
            int a;
            if (j < m) {
                a = nums1[j];
            } else {
                a = Integer.MAX_VALUE;
            }
            int b;
            if (k < n) {
                b = nums2[k];
            } else {
                b = Integer.MAX_VALUE;
            }
            // 取较小值
            if (a < b) {
                temp = a;
                j++;
            } else {
                temp = b;
                k++;
            }
            // 取中位数的两个对应值
            if (i == index1) {
                res1 = temp;
            }
            if (i == index2) {
                res2 = temp;
            }
            i++;
        }

        return (double) (res1 + res2) / 2;
    }
}
