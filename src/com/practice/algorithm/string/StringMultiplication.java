package com.practice.algorithm.string;

/** 字符串相乘 */
public class StringMultiplication {
    /**
     * 题目描述：
     *
     * <p>给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     *
     * <p>示例 1：输入: num1 = "2", num2 = "3"；输出: "6"
     *
     * <p>示例 2：输入: num1 = "123", num2 = "456"；输出: "56088"
     *
     * <p>说明：num1 和 num2 的长度小于110。num1 和 num2 只包含数字 0-9。num1 和 num2 均不以零开头，除非是数字 0 本身。
     * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
     */
    public static void main(String[] args) {
        // 将字符串转为char数组，依次处理
        System.out.println(solution("123", "456"));
    }

    /** 时间复杂度：O(n^2)，空间复杂度：O(n) */
    public static String solution(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        int[] intRes = new int[m + n - 1];

        // 用 num1 的每一位去乘 num2 的每一位
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                intRes[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
            }
        }
        // 从后往前，依次进位
        for (int i = intRes.length - 1; i > 0; i--) {
            if (intRes[i] >= 10) {
                intRes[i - 1] += intRes[i] / 10;
                intRes[i] %= 10;
            }
        }

        // 将intRes数组转化为字符串返回
        StringBuilder res = new StringBuilder();
        for (int i : intRes) {
            res.append(i);
        }
        return res.toString();
    }
}
