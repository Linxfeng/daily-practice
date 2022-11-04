package com.practice.algorithm.recursion;

/** 消除游戏 */
public class EliminateLastRemaining {
    /**
     * 题目描述：
     *
     * <p>列表 arr 由在范围 [1, n] 中的所有整数组成，并按严格递增排序。请你对 arr 应用下述算法：
     *
     * <p>从左到右，删除第一个数字，然后每隔一个数字删除一个，直到到达列表末尾。
     *
     * <p>重复上面的步骤，但这次是从右到左。也就是，删除最右侧的数字，然后剩下的数字每隔一个删除一个。
     *
     * <p>不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。 给你整数 n ，返回 arr 最后剩下的数字。
     *
     * <p>示例 1：输入：n = 9，输出：6；解释：arr=[1, 2, 3, 4, 5, 6, 7, 8, 9]，arr=[2, 4, 6, 8]，arr=[2, 6]，arr=[6]
     *
     * <p>示例 2：输入：n = 1，输出：1
     *
     * <p>提示：1 <= n <= 10^9
     *
     * <p>来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/elimination-game
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        // 每次都将整数列表进行间隔删除，因此每次删除后剩余的整数列表都是等差数列
        System.out.println(solution(9));
    }

    /** 时间复杂度：O(log n)，空间复杂度：O(1) */
    public static int solution(int n) {
        // 设第 k 次删除后的等差数列的首元素为 a1，末尾元素为 an，公差为 step ，元素数目为 cnt
        int a1 = 1;
        int k = 0, cnt = n, step = 1;

        while (cnt > 1) {
            // 如果 k 是偶数，则从左向右删除
            if (k % 2 == 0) {
                a1 = a1 + step;
            } else {
                // 如果 k 是奇数，则从右向左删除
                a1 = (cnt % 2 == 0) ? a1 : a1 + step;
            }
            k++;
            cnt = cnt >> 1;
            step = step << 1;
        }

        return a1;
    }
}
