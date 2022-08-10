package com.practice.algorithm;

/** 求解方程 */
public class SolveTheEquation {

    /**
     * 题目描述：
     *
     * <p>求解一个给定的方程，将x以字符串"x=#value"的形式返回。该方程仅包含'+'，'-'操作，变量x和其对应系数。
     *
     * <p>如果方程没有解，请返回"No solution"。如果方程有无限解，则返回"Infinite solutions"。
     *
     * <p>题目保证，如果方程中只有一个解，则'x'的值是一个整数。
     *
     * <p>示例 1：输入: equation = "x+5-3+x=6+x-2"，输出: "x=2"
     *
     * <p>示例 2: 输入: equation = "x=x"，输出: "Infinite solutions"
     *
     * <p>示例 3: 输入: equation = "2x=x"，输出: "x=0"
     *
     * <p>提示: 3 <= equation.length <= 1000，equation只有一个'='，equation方程由整数组成，其绝对值在[0,
     * 100]范围内，不含前导零和变量'x'。
     *
     * <p>来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/solve-the-equation
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        SolveTheEquation solveTheEquation = new SolveTheEquation();
        // x=2
        System.out.println(solveTheEquation.solveEquation("x+5-3+x=6+x-2"));
        // Infinite solutions
        System.out.println(solveTheEquation.solveEquation("x=x"));
        // x=0
        System.out.println(solveTheEquation.solveEquation("2x=x"));
        // No solution
        System.out.println(solveTheEquation.solveEquation("2x=x+1+x"));
        // x=-1
        System.out.println(solveTheEquation.solveEquation("2x+3x-6x=x+2"));
        // x=22
        System.out.println(solveTheEquation.solveEquation("3x=33+22+11"));
        // x=1
        System.out.println(solveTheEquation.solveEquation("99x=99"));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(1) */
    public String solveEquation(String equation) {
        // 数字之和
        int numSum = 0;
        // 变量x个数
        int xSum = 0;
        // 符号，=左侧为1，右侧为-1
        int sign1 = 1;
        // 运算符号
        int sign2 = 1;

        int n = equation.length();
        for (int i = 0; i < n; i++) {
            char c = equation.charAt(i);
            // 处理符号
            if (c == '+') {
                sign2 = 1;
            } else if (c == '-') {
                sign2 = -1;
            }
            // 处理=号，右侧为-1
            else if (c == '=') {
                sign1 = -1;
                sign2 = 1;
            }
            // 处理x
            else if (c == 'x') {
                if (sign1 * sign2 == 1) {
                    xSum++;
                } else {
                    xSum--;
                }
            }
            // 处理数字
            else {
                int num = 0;
                int j = i;
                while (j < n && Character.isDigit(equation.charAt(j))) {
                    num = equation.charAt(j) - '0' + num * 10;
                    j++;
                }
                i = j - 1;
                num = num * sign1 * sign2;
                // 判断这些数字是不是x的系数
                if (j < n && equation.charAt(j) == 'x') {
                    xSum += num;
                    i++;
                } else {
                    numSum += num;
                }
            }
        }

        // 当x的个数为0时，数字之和不为0则无解，数字之和为0则无穷多解
        if (xSum == 0) {
            if (numSum == 0) {
                return "Infinite solutions";
            }
            return "No solution";
        } else {
            // 当x个数不为0时，x的解为-数字之和/x的个数
            return "x=" + (-numSum / xSum);
        }
    }
}
