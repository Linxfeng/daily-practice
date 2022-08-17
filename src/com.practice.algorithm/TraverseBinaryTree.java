package com.practice.algorithm;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** 分层遍历二叉树 */
public class TraverseBinaryTree {
    /**
     * 题目描述：
     *
     * <p>给定一棵二叉树，节点定义如下: structNode { Node *pLeft; Node *pRight; int data; };
     * 要求按分层遍历该二叉树，即从上到下按层次访问该二叉树(每一层将单独输出一行)，每一层要求访问的顺序为从左到右，并将节点依次编号。
     *
     * <p>输入描述： 输入一行字符串。1(2)表示2是1的子树。(1<=str.length<=1000)
     *
     * <p>输出描述： 输出二叉树的层次。每层占一行。
     *
     * <p>示例1：输入：1(2(4,5(7,8)),3(6))
     *
     * <p>输出 1 2 3 4 5 6 7 8
     */
    public static void main(String[] args) {
        Map<Integer, List<String>> map =
                TraverseBinaryTree.traverseBinaryTree("-1(2(4,5(7,8)),3(6))");
        for (int i = 0; i < map.keySet().size(); i++) {
            // 按层级输出，每层的数字之间以空格隔开
            System.out.println(String.join(" ", map.get(i)));
        }
    }

    /** 时间复杂度：O(n)，空间复杂度：O(n) */
    public static Map<Integer, List<String>> traverseBinaryTree(String exp) {
        int index = 0;
        // 可以将字符串按字符挨个判断
        Map<Integer, List<String>> map = new LinkedHashMap<>();
        char[] chars = exp.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            // 左右括号代表数字的层级，此处用index表示层级
            if (c == '(') {
                index++;
            } else if (c == ')') {
                index--;
            } else if (c != ' ' && c != ',') {
                // 排除空格和逗号，其余字符都取出
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                // 若多个字符相连，需要将其拼接在一起，整体输出，避免有负数和浮点数
                int j = i + 1;
                while (j < chars.length
                        && chars[j] != '('
                        && chars[j] != ')'
                        && chars[j] != ' '
                        && chars[j] != ',') {
                    sb.append(chars[j]);
                    j++;
                }
                i = j - 1;
                if (!map.containsKey(index)) {
                    map.put(index, new ArrayList<>());
                }
                // 使用字符串存储数字，便于输出时空格拼接
                map.get(index).add(sb.toString());
            }
        }
        return map;
    }
}
