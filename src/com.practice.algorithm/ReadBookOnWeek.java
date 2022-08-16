package com.practice.algorithm;

import java.util.Arrays;
import java.util.List;

/** 周几读完书 */
public class ReadBookOnWeek {
    /**
     * 题目描述：
     *
     * <p>一本n页的书，每周的每天多读几页或者少读几页，会在周几读完。
     *
     * <p>输入描述：第一行输入n(1<=n<=1000)；第二行输入7个整数，分别表示周一到周日的读书页数p(0<=p<=1000)。（不考虑7个整数都为0的情况）
     *
     * <p>输出描述：输出答案，周几读完这本书。（1~7）
     *
     * <p>示例：输入100 \n 15 20 20 15 10 30 45， 输出6
     */
    public static void main(String[] args) {
        ReadBookOnWeek obj = new ReadBookOnWeek();
        System.out.println(obj.readBookOnWeek(100, Arrays.asList(15, 20, 20, 15, 10, 30, 45)));
        System.out.println(obj.readBookOnWeek(10, Arrays.asList(1, 2, 0, 1, 5, 4, 0)));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(1) */
    public int readBookOnWeek(int n, List<Integer> pages) {
        int sum = 0;
        // 先计算一周的读书总页数
        for (Integer page : pages) {
            sum += page;
        }
        // 对总页数取余
        int left = n % sum;
        // 计算不足一周时，周几能读完
        for (int i = 0; i < pages.size(); i++) {
            // 剩余页数-每天读的页数，判断读完没有
            left -= pages.get(i);
            if (left <= 0) {
                // 读完之和，返回周几
                return i + 1;
            }
        }
        return 0;
    }
}
