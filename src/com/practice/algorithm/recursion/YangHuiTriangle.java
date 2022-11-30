package com.practice.algorithm.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 杨辉三角 */
public class YangHuiTriangle {
    /**
     * 题目描述：
     *
     * <p>给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
     *
     * <p>在「杨辉三角」中，每个数是它左上方和右上方的数的和。
     *
     * <p>示例 1：输入: numRows = 5 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
     *
     * <p>示例 2：输入: numRows = 1 输出: [[1]]
     *
     * <p>提示：1 <= numRows <= 30
     */
    public static void main(String[] args) {
        List<List<Integer>> list = solution(5);
        for (List<Integer> nums : list) {
            System.out.println(Arrays.toString(nums.toArray()));
        }
    }

    /** 时间复杂度：O(n log n)，空间复杂度：O(n) */
    public static List<List<Integer>> solution(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }

        // 递归
        for (int i = 0; i < numRows; ++i) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; ++j) {
                temp.add(getNum(i, j));
            }
            res.add(temp);
        }
        return res;
    }

    public static int getNum(int i, int j) {
        if (j == 0 || i == j) {
            return 1;
        } else {
            return (getNum(i - 1, j - 1) + getNum(i - 1, j));
        }
    }
}
