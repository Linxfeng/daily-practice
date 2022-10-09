package com.practice.algorithm.array;

import java.util.Stack;

/** 逆波兰记法 */
public class ReversePolishNotation {
    /**
     * 题目描述：
     *
     * <p>逆波兰记法中，操作符置于操作数的后面。例如表达“三加四”时，写作“3 4 +”，而不是“3 + 4”。
     *
     * <p>如果有多个操作符，操作符置于第二个操作数的后面，所以常规中缀记法的“3 - 4 + 5”在逆波兰记法中写作“3 4 - 5 +”：先3减去4，再加上5。
     *
     * <p>使用逆波兰记法的一个好处是不需要使用括号。例如中缀记法中“3 - 4 * 5”与“(3 - 4) * 5”不相同，
     *
     * <p>但后缀记法中前者写做“3 4 5 * -”，无歧义地表示“3 (4 5 *) -”；后者写做“3 4 - 5 *”。
     *
     * <p>输入描述：第一行输入逆波兰记法字符串。
     *
     * <p>输出描述：输出计算后的结果。
     *
     * <p>示例 1：输入 2 1 + 3 *；输出 9
     */
    public static void main(String[] args) {
        // 可使用操作char字符数组形式，借助栈的特性辅助计算
        System.out.println(solution("1 2 +"));
        System.out.println(solution("3 4 5 * -"));
        System.out.println(solution("123 32 + 3 / 4 +"));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(log n) */
    public static int solution(String arr) {
        // 使用栈来计算，操作字符数组
        char[] chars = arr.toCharArray();
        Stack<Integer> p = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (c == ' ') {
                continue;
            }

            // 取出数字，若数字连续，需要连续完整取出
            int num = 0;
            int j = i;
            while (chars[j] >= '0' && chars[j] <= '9') {
                num = num * 10 + (chars[j] - '0');
                j++;
            }
            if (i != j) {
                // 将数字入栈
                p.push(num);
                // 将字符数组下标指向下一位
                i = j - 1;
            }

            // 遇到运算符，即可取出栈中两个数字进行运算
            if (c == '+') {
                int n1 = p.pop();
                int n2 = p.pop();
                p.push(n2 + n1);
            } else if (c == '-') {
                int n1 = p.pop();
                int n2 = p.pop();
                p.push(n2 - n1);
            } else if (c == '*') {
                int n1 = p.pop();
                int n2 = p.pop();
                p.push(n2 * n1);
            } else if (c == '/') {
                int n1 = p.pop();
                int n2 = p.pop();
                p.push(n2 / n1);
            }
        }

        // 返回最终运算结果
        return p.pop();
    }
}
