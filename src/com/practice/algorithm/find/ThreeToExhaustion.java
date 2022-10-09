package com.practice.algorithm.find;

/** 三而竭 */
public class ThreeToExhaustion {
    /**
     * 题目描述：
     *
     * <p>一鼓作气再而衰三而竭。小艺总是喜欢把任务分开做。小艺接到一个任务，任务的总任务量是n。
     *
     * <p>第一天小艺能完成x份任务。第二天能完成x/k……，第t天能完成x/(k^(t-1))。小艺想知道自己第一天至少完成多少才能完成最后的任务。
     *
     * <p>输入描述：第一行输入整数n,k。(1<=n<=1e9,2<=k<=10)
     *
     * <p>输出描述：输出x的最小值。
     *
     * <p>示例 1：输入 59 9；输出 54
     */
    public static void main(String[] args) {
        // 有题目可知：1<=x<=n，可使用二分法直接查找符合要求的x的最小值，复杂的并不高。
        System.out.println(solution(59, 9));
    }

    /** 时间复杂度：O(log n)，空间复杂度：O(1) */
    public static int solution(int n, int k) {
        // 1<= x <=n，使用二分法求符合要求的x最小值
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 判断是否能完成任务
            if (canFinished(n, k, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 返回能完成任务的最小x值
        return left;
    }

    /** 传入x，判断是否能完成任务 */
    private static boolean canFinished(int n, int k, int x) {
        int sum = 0;
        while (x > 0) {
            sum += x;
            x /= k;
        }
        return sum >= n;
    }
}
