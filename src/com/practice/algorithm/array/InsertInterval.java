package com.practice.algorithm.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/** 插入区间 */
public class InsertInterval {
    /**
     * 题目描述：
     *
     * <p>给你一个无重叠的按照区间起始端点排序的区间列表。
     *
     * <p>在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
     *
     * <p>示例 1：输入：intervals = [[1,3],[6,9]], newInterval = [2,5]；输出：[[1,5],[6,9]]
     *
     * <p>示例 2：输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval =
     * [4,8]；输出：[[1,2],[3,10],[12,16]]。解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
     *
     * <p>示例 3：输入：intervals = [], newInterval = [5,7]；输出：[[5,7]]
     *
     * <p>示例 4：输入：intervals = [[1,5]], newInterval = [2,3]；输出：[[1,5]]
     *
     * <p>示例 5：输入：intervals = [[1,5]], newInterval = [2,7]；输出：[[1,7]]
     *
     * <p>提示：0 <= intervals.length <= 10^4；intervals[i].length == 2；0 <= intervals[i][0] <=
     * intervals[i][1] <= 10^5； intervals 根据 intervals[i][0] 按升序排列；newInterval.length == 2；0 <=
     * newInterval[0] <= newInterval[1] <= 10^5
     */
    public static void main(String[] args) {
        System.out.println(
                Arrays.deepToString(
                        solution(
                                new int[][] {new int[] {1, 3}, new int[] {6, 9}},
                                new int[] {2, 5})));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(n) */
    public static int[][] solution(int[][] intervals, int[] newInterval) {
        int[][] newIntervals = new int[intervals.length + 1][];
        System.arraycopy(intervals, 0, newIntervals, 0, intervals.length);

        newIntervals[intervals.length] = newInterval;
        Arrays.sort(newIntervals, Comparator.comparingInt(a -> a[0]));

        Stack<int[]> stack = new Stack<>();
        for (int[] num : newIntervals) {
            if (stack.isEmpty()) {
                stack.push(num);
                continue;
            }
            int[] arr = stack.peek();
            if (arr[1] > num[0]) {
                int[] combine = {arr[0], Math.max(arr[1], num[1])};
                stack.pop();
                stack.push(combine);
            } else {
                stack.push(num);
            }
        }
        return stack.toArray(new int[0][]);
    }
}
