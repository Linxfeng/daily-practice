package com.practice.algorithm;

import java.util.ArrayList;
import java.util.List;

/** Z 字形变换 */
public class ZTransform {
    /**
     * 题目描述：将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
     *
     * <p>比如输入字符串为 "PAYPALISHIRING"，行数为 3 时，排列如下：
     *
     * <p>P A H N
     *
     * <p>A P L S I I G
     *
     * <p>Y I R
     *
     * <p>之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
     *
     * <p>请你实现这个将字符串进行指定行数变换的函数：string convert(string s, int numRows);
     *
     * <p>示例 1：输入：s = "PAYPALISHIRING", numRows = 3，输出："PAHNAPLSIIGYIR"
     *
     * <p>示例 2：输入：s = "PAYPALISHIRING", numRows = 4，输出："PINALSIGYAHRPI"
     *
     * <p>示例 3：输入：s = "A", numRows = 1，输出："A"
     *
     * <p>提示：1 <= s.length <= 1000，s由英文字母（小写和大写）、','和'.'组成，1 <= numRows <= 1000
     *
     * <p>来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/zigzag-conversion
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        // 这道题解决方法有两种，一个是利用斐波那契数列，即递归方法，另一种是利用动态规划方法。
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(n) */
    public static String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        // 建立行索引，每行需要存储对应的字符
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            // 把每个字符填入对应索引位置
            rows.get(i).append(c);
            // 到达转折点，反向
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        // 按行拼接结果
        StringBuilder res = new StringBuilder();
        rows.forEach(res::append);
        return res.toString();
    }
}
