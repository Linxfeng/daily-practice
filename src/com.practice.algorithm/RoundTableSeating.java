package com.practice.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/** 圆桌座位 */
public class RoundTableSeating {
    /**
     * 题目描述：圆桌座位
     *
     * <p>有N个客人与足够多张的圆桌。主人安排每位客人坐在一个圆桌边，但是每位客人希望自己左右边上分别有一些空座位，不然会觉得害羞。
     *
     * <p>注意，如果一个客人所在的圆桌只有他一个人，那么他左边的空座位数量就是他右边的空座位数量。
     *
     * <p>试问主人需要准备多少个座位，才能让每个客人舒适的坐下。
     *
     * <p>输入描述：第一行输入一个整数N，(1<=N<=10000)，代表客人的数量 接下来N行，每行两个整数li与ri，(1<=i<=N,1<=li<=ri<=1000000000)
     * 代表第i位客人希望左边有li个空座位，右边有ri个空座位。
     *
     * <p>输出描述：输出一个整数，代表主人需要准备的最少座位数量。
     *
     * <p>示例1：输入 3 1 1 1 1 1 1，输出 6，【样例解释】3个人围成一桌，每人左右各一个空位置，一共3个空座位。一个共需要3+3=6座位
     */
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2);
        List<Integer> list2 = Arrays.asList(3, 1);
        List<Integer> list3 = Arrays.asList(2, 3);
        List<List<Integer>> vector = Arrays.asList(list1, list2, list3);
        // 不管是单独坐还是拼桌坐，得出的结果是一样的
        System.out.println(solution(3, vector));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(n) */
    public static int solution(int n, List<List<Integer>> vector) {
        if (n <= 0 || vector.isEmpty()) {
            return 0;
        }

        // 当只有1个人时，左边和右边的空座位数量相等（取最大值）
        if (n == 1) {
            List<Integer> list = vector.get(0);
            return n + Math.max(list.get(0), list.get(1));
        }

        // 当只有2个人的时候，需要各取左右两边的较大值
        if (n == 2) {
            List<Integer> list1 = vector.get(0);
            List<Integer> list2 = vector.get(1);
            int l = Math.max(list1.get(0), list2.get(1));
            int r = Math.max(list1.get(1), list2.get(0));
            return l + r + n;
        }

        // 用于存储每个人 左边和右边的空座位
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        vector.forEach(
                i -> {
                    left.add(i.get(0));
                    right.add(i.get(1));
                });

        // 由大到小分别排序
        left.sort(Comparator.reverseOrder());
        right.sort(Comparator.reverseOrder());

        // 座位总数 = 人数 + 空座位数
        int result = n;

        // 分配空座位，取左边最大和右边最大配对
        int size = vector.size();
        for (int i = 0; i < size; i++) {
            // 依次得到最大空座位数，累计
            result += Math.max(left.get(i), right.get(i));
        }

        return result;
    }
}
