package com.practice.algorithm.recursion;

import java.util.Arrays;

/** 交换链表中的节点 */
public class SwapNodesInLinkedList {
    /**
     * 题目描述：
     *
     * <p>给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     *
     * <p>你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     *
     * <p>示例 1：输入：head = [1,2,3,4] 输出：[2,1,4,3]
     *
     * <p>示例 2：输入：head = [] 输出：[]
     *
     * <p>示例 3：输入：head = [1] 输出：[1]
     *
     * <p>提示：链表中节点的数目在范围 [0, 100] 内 0 <= Node.val <= 100
     *
     * <p>进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。）
     */
    public static void main(String[] args) {
        ListNode node3 = new ListNode(3);
        node3.next = new ListNode(4);
        ListNode node2 = new ListNode(2);
        node2.next = node3;
        ListNode node1 = new ListNode(1);
        node1.next = node2;

        ListNode listNode = solution(node1);

        int[] res = new int[4];
        int i = 0;
        while (listNode.next != null) {
            res[i] = listNode.val;
            i++;
            listNode = listNode.next;
        }
        res[i] = listNode.val;
        System.out.println(Arrays.toString(res));
    }

    /** 时间复杂度：O(log n)，空间复杂度：O(n) */
    public static ListNode solution(ListNode head) {
        ListNode list1 = new ListNode(0);
        list1.next = head;
        ListNode list2 = list1;

        while (head != null && head.next != null) {
            list2.next = head.next;
            head.next = list2.next.next;
            list2.next.next = head;
            list2 = list2.next.next;
            head = list2.next;
        }
        return list1.next;
    }
}
