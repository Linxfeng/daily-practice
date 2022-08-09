package com.practice.algorithm;

import java.util.Scanner;

/** 小鱼的航程(改进版) */
public class VoyageOfTheFish {

    /**
     * 题目描述：
     *
     * <p>有一只小鱼，它平日每天游泳250公里，周末休息（实行双休日)。假设从周x开始算起，过了n天以后，小鱼一共累计游泳了多少公里呢？
     *
     * <p>输入格式：输入两个正整数 x, n，表示从周 x 算起，经过 n 天。
     *
     * <p>输出格式：输出一个整数，表示小鱼累计游泳了多少公里。
     *
     * <p>数据保证，1 <= x <= 7, 1 <= n <= 10^6 。
     *
     * <p>示例：输入3 10，输出2000
     *
     * <p>来源：洛谷 P1424 小鱼的航程(改进版) 链接：https://www.luogu.com.cn/problem/P1424
     */
    public static void main(String[] args) {

        // 这题想简单点，就将经过的n天挨个去计算累加每天的航程即可
        System.out.print("请输入:");
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int n = scanner.nextInt();

        // 时间复杂度：O(n)，空间复杂度：O(n)
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (x != 6 && x != 7) {
                sum += 250;
            }
            // 每过一天，周x+1，当周x加到周日时，再+1则为周一
            if (x == 7) {
                x = 1;
            } else {
                x++;
            }
        }
        // 经过n天，航程sum就累加出来了
        System.out.println(sum);
        scanner.close();
    }
}
