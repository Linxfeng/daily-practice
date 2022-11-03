package com.practice.algorithm.recursion;

import java.util.Arrays;

/** 反转链表 */
public class ReverseLinkedList {
    /**
     * 题目描述：
     *
     * <p>给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     *
     * <p>示例 1：输入：head = [1,2,3,4,5]，输出：[5,4,3,2,1]
     *
     * <p>示例 2：输入：head = [1,2]，输出：[2,1]
     *
     * <p>示例 3：输入：head = [] 输出：[]
     *
     * <p>提示：链表中节点的数目范围是 [0, 5000]；-5000 <= Node.val <= 5000
     *
     * <p>进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
     */
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(3);
        listNode.next = listNode1;
        ListNode result = solution(listNode);
        System.out.println(
                Arrays.toString(new int[] {result.val, result.next.val, result.next.next.val}));
    }

    /** 时间复杂度：O(log n)，空间复杂度：O(n) */
    public static ListNode solution(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
