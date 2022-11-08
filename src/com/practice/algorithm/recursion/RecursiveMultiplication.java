package com.practice.algorithm.recursion;

/** 递归乘法 */
public class RecursiveMultiplication {
    /**
     * 题目描述：
     *
     * <p>递归乘法。写一个递归函数，不使用 * 运算符，实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。
     *
     * <p>示例 1：输入：A = 1, B = 10；输出：10
     *
     * <p>示例 2：输入：A = 3, B = 4；输出：12
     *
     * <p>提示：保证乘法范围不会溢出
     *
     * <p>来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/recursive-mulitply-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        System.out.println(solution(3, 4));
    }

    /** 时间复杂度：O(1)，空间复杂度：O(1) */
    public static int solution(int a, int b) {
        // 先判断b是否为0，如果为0则直接返回0
        // 从0阶(A*(B&1)*2^0)开始，每次算当前阶(A*(B&1)*2^n)的乘法并累加起来,算到B为0为止。
        // 如果B的最后一位是1
        // 把B的阶放到A上去，递归算B的倒数第2位和A的乘法,然后求和+A。
        // 把B的阶放到A上去，递归算B的倒数第2位和A的乘法,然后求和+0。
        return b != 0 ? solution(a << 1, b >> 1) + ((b & 1) == 1 ? a : 0) : 0;
    }
}
