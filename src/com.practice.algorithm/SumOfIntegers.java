package com.practice.algorithm;

/** 非负整数求和 */
public class SumOfIntegers {
    /**
     * 题目描述：
     *
     * <p>给定两个字符串形式的非负整数 num1 和 num2 ，计算它们的和。
     *
     * <p>注意：
     *
     * <p>1、 num1 和 num2 的长度都小于 5100.
     *
     * <p>2、 num1 和 num2 都只包含数字 0-9.
     *
     * <p>3、 num1 和 num2 都不包含任何前导零。
     *
     * <p>4、你不能使用任何內建 BigInteger 库，也不能直接将输入的字符串转换为整数形式。
     *
     * <p>输入描述：输入整数num1,num2。(0<=num1,num2<=1e100)
     *
     * <p>输出描述：输出整数num1,num2的加和。
     *
     * <p>示例1：输入 234 222，输出 456
     */
    public static void main(String[] args) {
        // 这道题考察的是对字符串的处理，显然需要通过操作字符串来实现大数相加的逻辑
        System.out.println(add("234", "222"));
        // 字符串实现大数相加
        System.out.println(add("23894515638153183184", "348167848545687974841858585"));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(n) */
    public static String add(String num1, String num2) {
        // 采用char数组的形式，实现逐位相加，满10进1
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();

        int len1 = arr1.length;
        int len2 = arr2.length;

        char[] res;
        // 防止进位，结果集数组长度+1
        if (len1 < len2) {
            res = new char[len2 + 1];
        } else {
            res = new char[len1 + 1];
        }

        // 进位标志
        int carry = 0;
        int index = res.length - 1;
        len1--;
        len2--;

        // 从最低位开始相加，直到其中一个数已经处理完
        while (len1 >= 0 && len2 >= 0) {
            int sum = (arr1[len1] - '0') + (arr2[len2] - '0') + carry;
            if (sum >= 10) {
                carry = 1;
                res[index] = (char) (sum - 10 + '0');
            } else {
                carry = 0;
                res[index] = (char) (sum + '0');
            }
            len1--;
            len2--;
            index--;
        }

        // 如果两个字符串长度相等，需要考虑进位
        if (len1 == len2) {
            if (carry == 1) {
                res[index] = '1';
            }
        }
        // 若两字符串长度不等，则需要将加剩下的赋值
        else if (len1 > len2) {
            while (len1 >= 0 && index >= 0) {
                int sum = (arr1[len1] - '0') + carry;
                if (sum >= 10) {
                    carry = 1;
                    res[index] = (char) (sum - 10 + '0');
                } else {
                    carry = 0;
                    res[index] = (char) (sum + '0');
                }
                len1--;
                index--;
            }
        } else {
            while (len2 >= 0 && index >= 0) {
                int sum = (arr2[len2] - '0') + carry;
                if (sum >= 10) {
                    carry = 1;
                    res[index] = (char) (sum - 10 + '0');
                } else {
                    carry = 0;
                    res[index] = (char) (sum + '0');
                }
                len2--;
                index--;
            }
        }

        String result = new String(res).trim();

        // 处理首位前导零的情况
        if (result.charAt(0) == '0') {
            result = result.substring(1);
        }

        return result;
    }
}
