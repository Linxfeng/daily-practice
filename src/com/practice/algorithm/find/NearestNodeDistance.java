package com.practice.algorithm.find;

import java.util.Arrays;
import java.util.List;

/** 节点距离最近 */
public class NearestNodeDistance {
    /**
     * 题目描述：
     *
     * <p>存在n个节点，目标节点在m。每个节点有自己的权值a。在权值k内选择一个权值非0节点且与目标节点距离最近。节点i与节点j的距离为abs(i-j)。
     *
     * <p>输入描述：第一行输入整数n,m,k.(1<=n,m,k<=100)；第二行输入n个整数的权值。(1<=a<=1000)
     *
     * <p>输出描述：输出最小距离
     *
     * <p>示例 1：输入 7\n 3\n 50 62 0 0 0 99 33 22，输出 3
     */
    public static void main(String[] args) {
        // 可以采用双指针从目标节点m处向左右两边扩散寻找
        System.out.println(solution(7, 3, 50, Arrays.asList(62, 0, 0, 0, 99, 33, 22)));
    }

    /** 时间复杂度：O(log n)，空间复杂度：O(1) */
    public static int solution(int n, int m, int k, List<Integer> arr) {
        // 采用双指针，从下标m-1开始，分别向左右两边寻找
        int left = m - 2;
        int right = m;

        // 判断是否越界
        if (left < 0) {
            left = 0;
        }
        if (right > n - 1) {
            right = n - 1;
        }

        // 判断自身是否符合条件
        int result = 0;
        if (arr.get(m - 1) <= k && arr.get(m - 1) > 0) {
            return result;
        }

        // 双指针向左右两边寻找
        while (left >= 0 && right <= n - 1) {
            if (arr.get(left) <= k && arr.get(left) > 0) {
                result = m - 1 - left;
                break;
            }
            if (arr.get(right) <= k && arr.get(right) > 0) {
                result = right + 1 - m;
                break;
            }
            // 左右都到达边界，则跳出
            if (left == 0 && right == n - 1) {
                break;
            }
            // 移动左右指针
            if (left > 0) {
                left--;
            }
            if (right < n - 1) {
                right++;
            }
        }

        // 取绝对值
        if (result < 0) {
            result *= -1;
        }
        return result;
    }
}
