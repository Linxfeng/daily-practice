package com.practice.algorithm.recursion;

import java.util.Arrays;

/** 排序链表 */
public class SortedLinkedList {
    /**
     * 题目描述：
     *
     * <p>给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     *
     * <p>进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
     *
     * <p>示例 1：输入：head = [4,2,1,3]；输出：[1,2,3,4]
     *
     * <p>示例 2：输入：head = [-1,5,3,4,0]；输出：[-1,0,3,4,5]
     *
     * <p>示例 3：输入：head = []；输出：[]
     *
     * <p>提示：链表中节点的数目在范围 [0, 5 * 10^4] 内；-10^5 <= Node.val <= 10^5
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {4, 2, 1, 3})));
        System.out.println(Arrays.toString(solution(new int[] {-1, 5, 3, 4, 0})));
    }

    /** 时间复杂度：O(n log n)，空间复杂度：O(1) */
    public static int[] solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int n = nums.length;

        // 构建链表head
        int i = 1;
        ListNode head = new ListNode(nums[0]);
        ListNode node = head;
        while (i < n) {
            node.next = new ListNode(nums[i]);
            node = node.next;
            i++;
        }

        // 排序：时间复杂度：O(n log n)，空间复杂度：O(1)
        ListNode listNode = mergeSort(head);

        // 转换链表为数组返回
        int[] res = new int[n];
        i = 0;
        while (i < n) {
            res[i++] = listNode.val;
            listNode = listNode.next;
        }

        return res;
    }

    /** 对链表排序 */
    public static ListNode mergeSort(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        if (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        ListNode left = head;
        ListNode right = p1.next;
        p1.next = null;
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    public static ListNode merge(ListNode left, ListNode right) {
        ListNode head;
        if (left.val < right.val) {
            head = left;
            left = left.next;
        } else {
            head = right;
            right = right.next;
        }

        ListNode tmp = head;
        while (left != null && right != null) {
            if (left.val < right.val) {
                tmp.next = left;
                left = left.next;
            } else {
                tmp.next = right;
                right = right.next;
            }
            tmp = tmp.next;
        }
        tmp.next = left != null ? left : right;
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
