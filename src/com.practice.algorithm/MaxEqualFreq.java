package com.practice.algorithm;

import java.util.HashMap;
import java.util.Map;

/** 最大相等频率 */
public class MaxEqualFreq {
    /**
     * 题目描述：
     *
     * <p>给你一个正整数数组 nums，请你帮忙从该数组中找出能满足下面要求的最长前缀，并返回该前缀的长度。
     *
     * <p>从前缀中恰好删除一个元素后，剩下每个数字的出现次数都相同。如果删除这个元素后没有剩余元素存在，仍可认为每个数字都具有相同的出现次数（0次）
     *
     * <p>示例 1：输入：nums = [2,2,1,1,5,3,3,5]，输出：7
     *
     * <p>解释：对于长度为7的子数组 [2,2,1,1,5,3,3]，如果我们从中删去nums[4]=5，就可以得到[2,2,1,1,3,3]，里面每个数字都出现了两次。
     *
     * <p>示例 2：输入：nums = [1,1,1,2,2,2,3,3,3,4,4,4,5]，输出：13
     *
     * <p>提示：2 <= nums.length <= 10^5，1 <= nums[i] <= 10^5
     *
     * <p>来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/maximum-equal-frequency
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5};
        System.out.println(maxEqualFreq(nums));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(n) */
    public static int maxEqualFreq(int[] nums) {
        int result = 0;
        // 统计每个元素出现的次数
        Map<Integer, Integer> count = new HashMap<>();
        // 统计出现次数为f的数字的频率
        Map<Integer, Integer> freq = new HashMap<>();
        // 最大出现频率
        int maxFreq = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果上次统计了频率，则将上次的结果-1（因为这个数要统计到本次结果中）
            if (freq.containsKey(count.get(nums[i]))) {
                freq.put(count.get(nums[i]), freq.get(count.get(nums[i])) - 1);
            }
            // 统计次数和频率
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            freq.put(count.get(nums[i]), freq.getOrDefault(count.get(nums[i]), 0) + 1);
            maxFreq = Math.max(maxFreq, count.get(nums[i]));

            // 判断条件成立的情况：
            int n = i + 1;
            // 1. 出现的最大频率为1，所有数的出现次数都是一次，则可以删除任意元素满足要求
            // 2. 所有数的出现次数都是maxFreq或maxFreq−1，且最大出现次数的数只有一个，则删除最大出现次数的数满足要求
            // 3. 所有数的出现次数都是maxFreq，且有一个数出现次数为1，则删除出现次数为1的数满足要求
            if (maxFreq == 1
                    || freq.get(maxFreq) == 1
                            && freq.get(maxFreq) * maxFreq
                                            + freq.getOrDefault(maxFreq - 1, 0) * (maxFreq - 1)
                                    == n
                    || freq.get(maxFreq) * maxFreq + 1 == n && freq.get(1) == 1) {
                // 每次循环，都将满足条件的最大长度更新
                result = Math.max(result, n);
            }
        }
        return result;
    }
}
