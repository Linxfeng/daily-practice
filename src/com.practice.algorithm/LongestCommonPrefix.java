package com.practice.algorithm;

/** 最长公共前缀 */
public class LongestCommonPrefix {
    /**
     * 题目描述：
     *
     * <p>编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * <p>如果不存在公共前缀，返回空字符串 ""。
     *
     * <p>示例 1：输入：strs = ["flower","flow","flight"]；输出："fl"
     *
     * <p>示例 2：输入：strs = ["dog","racecar","car"]；输出：""。解释：输入不存在公共前缀。
     *
     * <p>提示：1 <= strs.length <= 200；0 <= strs[i].length <= 200；strs[i] 仅由小写英文字母组成
     *
     * <p>来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/longest-common-prefix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        // 这道题可以使用横向扫描
        System.out.println(longestCommonPrefix(new String[] {"flower", "flow", "flight"}));
    }

    /** 时间复杂度：O(nm)，空间复杂度：O(1) */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 依次遍历字符串数组中的每个字符串，对于每个遍历到的字符串，更新最长公共前缀
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int length = Math.min(prefix.length(), strs[i].length());
            int index = 0;
            while (index < length && prefix.charAt(index) == strs[i].charAt(index)) {
                index++;
            }
            prefix = prefix.substring(0, index);

            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }
}
