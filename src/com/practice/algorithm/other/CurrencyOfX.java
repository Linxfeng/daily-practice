package com.practice.algorithm.other;

/** X 国货币 */
public class CurrencyOfX {
    /**
     * 题目描述：
     *
     * <p>X国发行货币最高面额为n。 次高面额为n的因子。 以此类推。 X国最多发行多少种货币。
     *
     * <p>输入描述：输入整数n。(1<=n<=1000000)表示货币的最大面额
     *
     * <p>输出描述：输出货币的种类。
     *
     * <p>示例 1：输入 10，输出 3
     */
    public static void main(String[] args) {
        System.out.println(solution(10));
    }

    /** 时间复杂度：O(log n)，空间复杂度：O(1) */
    public static int solution(int n) {
        if (n <= 2) {
            return n;
        }
        // 返回整数n的因子数+1(自身)
        return 1 + getFx(n);
    }

    /** 获取整数n的因子数 */
    public static int getFx(int n) {
        int res = 0;
        for (int i = n - 1; i > 0; i--) {
            // 能被i整除，i即为n的一个因子
            if (n % i == 0) {
                res++;
                // 若i不为1，则求i的因子数，递归
                if (i != 1) {
                    return res + getFx(i);
                }
                break;
            }
        }
        // 返回整数n的因子数
        return res;
    }
}
