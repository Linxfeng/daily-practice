package com.practice.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 两数相加 */
public class AddTwoNums {
    /**
     * 题目描述：
     *
     * <p>给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
     *
     * <p>请你将两个数相加，并以相同形式返回一个表示和的链表。
     *
     * <p>你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * <p>示例 1：输入：l1 = [2,4,3], l2 = [5,6,4]，输出：[7,0,8]；解释：342 + 465 = 807.
     *
     * <p>示例 2：输入：l1 = [0], l2 = [0]，输出：[0]
     *
     * <p>示例 3：输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]，输出：[8,9,9,9,0,0,0,1]；解释：9999999+9999=10009998
     *
     * <p>提示：每个链表中的节点数在范围[1, 100]内；0 <= Node.val <= 9，题目数据保证列表表示的数字不含前导零
     *
     * <p>来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        // 将数组构造成链表
        int[] n1 = new int[] {2, 4, 3};
        ListNode l1 = new ListNode(n1[0]);
        constructListNode(l1, n1, 1);

        int[] n2 = new int[] {5, 6, 4};
        ListNode l2 = new ListNode(n2[0]);
        constructListNode(l2, n2, 1);

        // 两数相加
        ListNode listNode = addTwoNumbers(l1, l2);

        // 打印链表
        List<Integer> res = new ArrayList<>();
        while (listNode != null) {
            res.add(listNode.val);
            listNode = listNode.next;
        }
        System.out.println(Arrays.toString(res.toArray()));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(1) */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;

        // 进位
        int carry = 0;
        // 分别遍历两个链表，对应位置直接相加
        while (l1 != null || l2 != null) {
            // 较短的链表遍历完后可以认为它后续的数字都为0
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            // 值相加，加上进位
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            // 如果和大于10，则进位
            carry = sum / 10;
            // 继续向下遍历
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // 若加完了还有进位，则单独一位也要算上
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    /** 构造一个链表 */
    private static void constructListNode(ListNode node, int[] arr, int index) {
        if (index >= arr.length) {
            return;
        }
        node.next = new ListNode(arr[index]);
        constructListNode(node.next, arr, ++index);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
