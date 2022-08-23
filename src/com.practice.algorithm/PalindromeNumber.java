package com.practice.algorithm;

/** 回文数 */
public class PalindromeNumber {
    /**
     * 题目描述：
     *
     * <p>给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     *
     * <p>回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
     *
     * <p>示例 1：输入：x = 121，输出：true
     *
     * <p>示例 2：输入：x = -121，输出：false，解释：从左向右读,为-121。从右向左读，为121-，因此它不是一个回文数。
     *
     * <p>示例 3：输入：x = 10 输出：false 解释：从右向左读, 为 01 。因此它不是一个回文数。
     *
     * <p>提示：-2^31<= x <= 2^31 - 1，你能不将整数转为字符串来解决这个问题吗
     *
     * <p>来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/palindrome-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        // 这道题不能将数字转化为字符串来处理，我们可以通过%10和/10来逐位反转来比对
        System.out.println(isPalindrome(123454321));
        System.out.println(isPalindrome(123455321));
    }

    /** 时间复杂度：O(log n)，空间复杂度：O(1) */
    public static boolean isPalindrome(int x) {
        // 当 x < 0 时，有负号，不是回文数。如果x最后一位为0且x、不为0，则不是回文数
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        // 当原始数字小于或等于反转后的数字时，就已经处理了一半位数的数字了
        int revertedNumber = 0;
        while (x > revertedNumber) {
            // 不断将原始数字除以10，然后给反转后的数字乘上10
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为偶数时，x == revertedNumber。
        // 当数字长度为奇数时，x == revertedNumber / 10，因为中位的数字与它自己相等。
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
