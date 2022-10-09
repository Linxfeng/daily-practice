package com.practice.algorithm.array;

import java.util.ArrayDeque;
import java.util.Deque;

/** 验证栈序列 */
public class ValidateStackSequences {
    /**
     * 题目描述：
     *
     * <p>给定 pushed 和 popped 两个序列，每个序列中的值都不重复
     *
     * <p>只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则返回 false
     *
     * <p>示例 1：输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]，输出：true
     *
     * <p>解释：可以按以下顺序执行：push(1),push(2),push(3),push(4),pop()->4,push(5),pop()->5,pop()->3,pop()->2,pop()->1
     *
     * <p>示例 2：输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]，输出：false。解释：1 不能在 2 之前弹出。
     *
     * <p>提示：1 <= pushed.length <= 1000；0 <= pushed[i] <= 1000；pushed的所有元素互不相同；
     *
     * <p>popped.length == pushed.length；popped 是 pushed 的一个排列
     *
     * <p>来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/validate-stack-sequences
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        // 这道题可以使用模拟入栈和出栈来验证
        System.out.println(
                validateStackSequences(new int[] {1, 2, 3, 4, 5}, new int[] {4, 5, 3, 2, 1}));
        System.out.println(
                validateStackSequences(new int[] {1, 2, 3, 4, 5}, new int[] {4, 3, 5, 1, 2}));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(n) */
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        // 模拟一个栈
        Deque<Integer> stack = new ArrayDeque<>();
        int j = 0;
        for (int p : pushed) {
            // 将pushed数组依次入栈
            stack.push(p);
            // 当栈顶与popped数组当前值相等时，出栈
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        // 入栈和出栈结束后，若栈为空则验证通过返回true
        return stack.isEmpty();
    }
}
