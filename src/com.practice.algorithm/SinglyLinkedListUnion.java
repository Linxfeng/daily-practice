package com.practice.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/** 单向链表求并集 */
public class SinglyLinkedListUnion {
    /**
     * 题目描述：
     *
     * <p>输出两个单向有序链表的并集。如链表A{1 -> 2 -> 5 -> 7}，链表B{3 -> 5 -> 7 -> 8}，输出:{1 -> 2 ->3 -> 5 -> 7 -> 8}
     *
     * <p>输入描述：第一行给出A链表所包含元素(1<=a<=1000)，第二行给出B链表所包含元素(1<=b<=1000)
     *
     * <p>输出描述：输出两个单向有序链表的并集
     *
     * <p>示例1：输入 1 2 5 7，3 5 7 8，输出 1 2 3 5 7 8
     */
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 5, 7);
        List<Integer> list2 = Arrays.asList(3, 5, 7, 8);

        List<Integer> result = union(list1, list2);
        System.out.print(result.get(0));
        for (int i = 1; i < result.size(); i++) {
            System.out.print(" " + result.get(i));
        }
    }

    /** 时间复杂度：O(n^2)，空间复杂度：O(n) */
    public static List<Integer> union(List<Integer> list1, List<Integer> list2) {
        Set<Integer> result = new HashSet<>();
        // 最简单迅速的方法就是直接使用Set集合接收两个列表，再排个序
        result.addAll(list1);
        result.addAll(list2);
        return result.stream().sorted().collect(Collectors.toList());
    }
}
