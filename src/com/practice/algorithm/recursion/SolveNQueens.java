package com.practice.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/** N 皇后 */
public class SolveNQueens {
    /**
     * 题目描述：
     *
     * <p>n 皇后问题，研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     *
     * <p>给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
     *
     * <p>每一种解法包含一个不同的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
     *
     * <p>示例 1：输入：n = 4；输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]。解释：4
     * 皇后问题存在两个不同的解法。
     *
     * <p>示例 2：输入：n = 1；输出：[["Q"]]
     *
     * <p>提示：1 <= n <= 9；皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
     */
    public static void main(String[] args) {
        // 使用回溯法（递归）
        System.out.println(solution(4));
    }

    /** 时间复杂度：O(n log n)，空间复杂度：O(n) */
    public static List<List<String>> solution(int n) {
        List<List<String>> res = new ArrayList<>();
        int[] queenList = new int[n];
        placeQueen(queenList, 0, n, res);
        return res;
    }

    private static void placeQueen(int[] queenList, int row, int n, List<List<String>> res) {
        if (row == n) {
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringBuilder str = new StringBuilder();
                for (int col = 0; col < n; col++) {
                    if (queenList[i] == col) {
                        str.append("Q");
                    } else {
                        str.append(".");
                    }
                }
                list.add(str.toString());
            }
            res.add(list);
        }
        for (int col = 0; col < n; col++) {
            if (isValid(queenList, row, col)) {
                queenList[row] = col;
                placeQueen(queenList, row + 1, n, res);
            }
        }
    }

    private static boolean isValid(int[] queenList, int row, int col) {
        for (int i = 0; i < row; i++) {
            int pos = queenList[i];
            if (pos == col) {
                return false;
            }
            if (pos + row - i == col) {
                return false;
            }
            if (pos - row + i == col) {
                return false;
            }
        }
        return true;
    }
}
