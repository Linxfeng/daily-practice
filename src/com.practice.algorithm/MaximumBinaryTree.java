package com.practice.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** 最大二叉树 */
public class MaximumBinaryTree {
    /**
     * 题目描述：
     *
     * <p>给定一个不重复的整数数组nums。最大二叉树可以用下面的算法从nums递归地构建:创建一个根节点，其值为nums中的最大值。
     *
     * <p>递归地在最大值左边的子数组前缀上构建左子树。递归地在最大值右边的子数组后缀上构建右子树。返回nums构建的最大二叉树。
     *
     * <p>示例1：输入：nums = [3,2,1,6,0,5]，输出：[6,3,5,null,2,0,null,null,1]
     *
     * <p>解释：从顶而下从左至右依次输出二叉树节点，若无节点则输出null。
     *
     * <p>示例2：输入：nums = [3,2,1]，输出：[3,null,2,null,1]
     *
     * <p>提示：1 <= nums.length <= 1000，0 <= nums[i] <= 1000，nums中的所有整数互不相同
     *
     * <p>来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/maximum-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 0, 5};
        // 根据给定数组构造一棵最大二叉树
        TreeNode treeNode = constructMaximumBinaryTree(nums);
        // 按要求输出数组
        List<Integer> result = getTreeNodeVarList(treeNode);

        result.forEach(System.out::println);
    }

    /** 时间复杂度：O(n^2)，空间复杂度：O(n) */
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        // 可以使用递归来构造题目要求的二叉树
        return construct(nums, 0, nums.length - 1);
    }

    /** 构造二叉树 */
    public static TreeNode construct(int[] nums, int left, int right) {
        // 当区间无效时，返回一棵空树
        if (left > right) {
            return null;
        }
        // 找出数组中最大值的下标
        int best = left;
        for (int i = left + 1; i <= right; ++i) {
            if (nums[i] > nums[best]) {
                best = i;
            }
        }
        // 以最大值为根节点，递归构造二叉树
        TreeNode node = new TreeNode(nums[best]);
        node.left = construct(nums, left, best - 1);
        node.right = construct(nums, best + 1, right);
        return node;
    }

    /** 将给定的二叉树按自上而下、从左往右拆分到list中返回 */
    public static ArrayList<Integer> getTreeNodeVarList(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        if (node != null) {
            queue.add(node);
        }
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            while (cnt-- > 0) {
                TreeNode t = queue.poll();
                if (t == null) {
                    result.add(null);
                    continue;
                }
                result.add(t.val);
                if (t.left != null || t.right != null) {
                    queue.add(t.left);
                    queue.add(t.right);
                }
            }
        }
        return result;
    }

    /** 定义一棵二叉树 */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
