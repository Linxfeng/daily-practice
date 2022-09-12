package com.practice.algorithm;

/** 字符串转换整数 (a2i) */
public class StringToInteger {
    /**
     * 题目描述：
     *
     * <p>请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
     *
     * <p>函数 myAtoi(string s) 的算法如下：
     *
     * <p>1.读入字符串并丢弃无用的前导空格
     *
     * <p>2.检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
     *
     * <p>3.读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
     *
     * <p>4.将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
     *
     * <p>5.如果整数数超过 32 位有符号整数范围 [−2^31, 2^31 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −2^31 的整数应该被固定为 −2^31
     * ，大于 2^31 − 1 的整数应该被固定为 2^31 − 1。
     *
     * <p>6.返回整数作为最终结果。
     *
     * <p>注意：本题中的空白字符只包括空格字符 ' '。 除前导空格或数字后的其余字符串外，请勿忽略任何其他字符。
     *
     * <p>示例 1：输入：s = "42" 输出：42
     *
     * <p>示例 2：输入：s = " -42" 输出：-42
     *
     * <p>示例 3：输入：s = "4193 with words" 输出：4193
     *
     * <p>来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/string-to-integer-atoi
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        System.out.println(a2i("  -4193 with words 1"));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(1) */
    public static int a2i(String s) {
        if (s.trim().length() == 0) {
            return 0;
        }
        char[] chars = s.trim().toCharArray();
        int len = chars.length;

        // 如果出现符号字符，仅第 1 个有效，并记录正负
        int sign = 1;
        int index = 0;
        char firstChar = chars[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }

        // 将后续出现的数字字符进行转换，不能使用 long 类型
        int res = 0;
        while (index < len) {
            char c = chars[index];
            // 取出数字
            if (c > '9' || c < '0') {
                break;
            }

            // 需要提前判断乘以 10 以后是否越界
            if (res > Integer.MAX_VALUE / 10
                    || (res == Integer.MAX_VALUE / 10 && (c - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10
                    || (res == Integer.MIN_VALUE / 10 && (c - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            res = res * 10 + sign * (c - '0');
            index++;
        }
        return res;
    }
}
