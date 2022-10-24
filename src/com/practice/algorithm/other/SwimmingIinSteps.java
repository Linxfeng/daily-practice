package com.practice.algorithm.other;

/** 分步游泳 */
public class SwimmingIinSteps {
    /**
     * 题目描述：
     *
     * <p>小玉开心的在游泳，已知小玉第一步能游2米，她接下来的每一步都只能游出上一步距离的98%。
     *
     * <p>现在小玉想知道，如果要游到距离x米的地方，她需要游多少步呢。请你编程解决这个问题。
     *
     * <p>输入描述：输入一个数字（不一定是整数，小于100m），表示要游的目标距离。
     *
     * <p>输出描述：输出一个整数，表示小玉一共需要游多少步。
     *
     * <p>示例 1：输入 4.3，输出 3
     */
    public static void main(String[] args) {
        System.out.println(solution(4.3f));
    }

    /** 时间复杂度：O(log n)，空间复杂度：O(1) */
    public static int solution(float distance) {
        // 先给定第一步的距离和步长
        int result = 1;
        float sum = 2;
        double step = 2;

        // 循环累计距离，直至超出或等于总距离
        while (sum < distance) {
            // 更新步长和总距离
            step = step * 0.98;
            sum += step;
            result++;
        }

        return result;
    }
}
