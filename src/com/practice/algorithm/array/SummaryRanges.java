package com.practice.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/** 汇总区间 */
public class SummaryRanges {
    /**
     * 题目描述：
     *
     * <p>给定一个无重复元素的有序整数数组 nums 。返回恰好覆盖数组中所有数字的最小有序区间范围列表。
     *
     * <p>也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
     *
     * <p>列表中的每个区间范围 [a,b] 应该按如下格式输出："a->b" （a != b）；"a" （a == b）
     *
     * <p>示例 1：输入：nums = [0,1,2,4,5,7] 输出：["0->2","4->5","7"]
     *
     * <p>解释：区间范围是：[0,2] --> "0->2"，[4,5] --> "4->5"，[7,7] --> "7"
     *
     * <p>示例 2：输入：nums = [0,2,3,4,6,8,9] 输出：["0","2->4","6","8->9"]
     *
     * <p>示例 3：输入：nums = [] 输出：[]
     *
     * <p>示例 4：输入：nums = [-1] 输出：["-1"]
     *
     * <p>示例 5：输入：nums = [0] 输出：["0"]
     *
     * <p>提示：0<=nums.length<=20；-2^31<=nums[i]<= 2^31 - 1；nums中的所有值都互不相同；nums按升序排列
     */
    public static void main(String[] args) {
        System.out.println(solution(new int[] {0, 1, 2, 4, 5, 7}));
    }

    /** 时间复杂度：O(n log n)，空间复杂度：O(log n) */
    public static List<String> solution(int[] nums) {
        List<String> list = new ArrayList<>();
        int n = nums.length;
        int pre = 0;
        int next = 0;
        for (int i = 0; i < n; i++) {
            if (i + 1 < n && nums[i + 1] - nums[i] == 1) {
                next = i + 1;
            } else {
                if (next < i) {
                    next = i;
                }
                if (pre != next) {
                    list.add(nums[pre] + "->" + nums[next]);
                    pre = i + 1;
                }
                if (pre == next) {
                    list.add(nums[pre] + "");
                    pre = i + 1;
                }
            }
        }
        return list;
    }
}
