package com.practice.algorithm;

/** 整数反转 */
public class IntegerReverse {
    /**
     * 题目描述：
     *
     * <p>给你一个32位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     *
     * <p>如果反转后整数超过32位的有符号整数的范围 [−2^31, 2^31 − 1] ，就返回 0。
     *
     * <p>假设环境不允许存储 64 位整数（有符号或无符号）。
     *
     * <p>示例 1：输入：x = 123，输出：321
     *
     * <p>示例 2：输入：x = -123，输出：-321
     *
     * <p>示例 3：输入：x = 120，输出：21
     *
     * <p>示例 4：输入：x = 0，输出：0
     *
     * <p>提示：-2^31 <= x <= 2^31 - 1
     *
     * <p>来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/reverse-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        System.out.println(reverse(120));
        System.out.println(reverse(Integer.MAX_VALUE));
    }

    /** 时间复杂度：O(log|x|)，空间复杂度：O(n) */
    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            // 将数字取模，每次取最后一位
            int tmp = x % 10;
            // 判断是否大于最大32位整数
            if (result > Integer.MAX_VALUE / 10 || (result == 214748364 && tmp > 7)) {
                return 0;
            }
            // 判断是否小于最小32位整数
            if (result < Integer.MIN_VALUE / 10 || (result == -214748364 && tmp < -8)) {
                return 0;
            }
            // 更新结果
            result = result * 10 + tmp;
            x = x / 10;
        }
        return result;
    }
}
