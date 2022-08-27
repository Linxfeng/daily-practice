package com.practice.algorithm;

/** 两数相除 */
public class DivideTwoNumbers {
    /**
     * 题目描述：两数相除
     *
     * <p>给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
     *
     * <p>返回被除数 dividend 除以除数 divisor 得到的商。结果应当截去其小数部分
     *
     * <p>示例1：输入: dividend = 10, divisor = 3，输出: 3
     *
     * <p>示例2：输入: dividend = 7, divisor = -3，输出: -2
     *
     * <p>提示：被除数和除数均为32位有符号整数，除数不为0。
     *
     * <p>假设我们的环境只能存储32位有符号整数，其数值范围是[−2^31, 2^31 − 1]。本题中，如果除法结果溢出，则返回2^31 − 1。
     *
     * <p>来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/divide-two-integers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        // 这道题可以使用二分查找
        System.out.println(divide(11, 3));
    }

    /** 时间复杂度：O(log^2 n)，空间复杂度：O(1) */
    public static int divide(int dividend, int divisor) {
        // 考虑被除数为最小值的情况
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return Integer.MIN_VALUE;
            }
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
        }
        // 考虑除数为最小值的情况
        if (divisor == Integer.MIN_VALUE) {
            return dividend == Integer.MIN_VALUE ? 1 : 0;
        }
        // 考虑被除数或除数为 0 的情况
        if (dividend == 0 || divisor == 0) {
            return 0;
        }

        // 将所有的正数取相反数，这样就只需要考虑一种情况
        boolean rev = false;
        if (dividend > 0) {
            dividend = -dividend;
            rev = true;
        }
        if (divisor > 0) {
            divisor = -divisor;
            rev = !rev;
        }

        // 使用二分法查找，直到找到成立的结果
        int left = 1, right = Integer.MAX_VALUE, ans = 0;
        while (left <= right) {
            // 注意溢出，并且不能使用除法
            int mid = left + ((right - left) >> 1);
            boolean check = quickAdd(divisor, mid, dividend);
            if (check) {
                ans = mid;
                // 注意溢出
                if (mid == Integer.MAX_VALUE) {
                    break;
                }
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return rev ? -ans : ans;
    }

    /** 判断 z * y >= x 是否成立 */
    public static boolean quickAdd(int y, int z, int x) {
        // x 和 y 是负数，z 是正数
        int result = 0, add = y;
        while (z != 0) {
            if ((z & 1) != 0) {
                // 需要保证 result + add >= x
                if (result < x - add) {
                    return false;
                }
                result += add;
            }
            if (z != 1) {
                // 需要保证 add + add >= x
                if (add < x - add) {
                    return false;
                }
                add += add;
            }
            // 不能使用除法
            z >>= 1;
        }
        return true;
    }
}
