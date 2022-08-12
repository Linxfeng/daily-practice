package com.practice.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 用户分组 */
public class GroupThePeople {
    /**
     * 题目描述：
     *
     * <p>有 n 个人被分成数量未知的组。每个人都被标记为一个从 0 到 n - 1 的唯一ID。
     *
     * <p>给定一个整数数组 groupSizes ，其中 groupSizes[i] 是第 i 个人所在的组的大小。例如，如果 groupSizes[1] = 3 ，则第 1
     * 个人必须位于大小为 3 的组中。
     *
     * <p>返回一个组列表，使每个人 i 都在一个大小为 groupSizes[i] 的组中。
     *
     * <p>每个人应该恰好只出现在一个组中，并且每个人必须在一个组中。如果有多个答案，返回其中任何一个。可以保证给定输入至少有一个有效的解。
     *
     * <p>示例 1：输入：groupSizes = [3,3,3,3,3,1,3] 输出：[[5],[0,1,2],[3,4,6]] 解释： 第一组是 [5]，大小为
     * 1，groupSizes[5] = 1。 第二组是 [0,1,2]，大小为 3，groupSizes[0] = groupSizes[1] = groupSizes[2] = 3。
     * 第三组是 [3,4,6]，大小为 3，groupSizes[3] = groupSizes[4] = groupSizes[6] = 3。 其他可能的解决方案有
     * [[2,1,6],[5],[0,4,3]] 和 [[5],[0,6,2],[4,3,1]]。
     *
     * <p>示例 2：输入：groupSizes = [2,1,3,3,3,2] 输出：[[1],[0,5],[2,3,4]]
     *
     * <p>提示：groupSizes.length == n，1 <= n <= 500，1 <= groupSizes[i] <= n
     *
     * <p>来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/group-the-people-given-the-group-size-they-belong-to
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        GroupThePeople o = new GroupThePeople();
        System.out.println(o.groupThePeople(new int[] {3, 3, 3, 3, 3, 1, 3}));
        System.out.println(o.groupThePeople(new int[] {2, 1, 3, 3, 3, 2}));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(n) */
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;

        // groupSizes[i]对应位置i的数组
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(groupSizes[i])) {
                map.put(groupSizes[i], new ArrayList<>());
            }
            map.get(groupSizes[i]).add(i);
        }

        // 分组
        List<List<Integer>> result = new ArrayList<>();
        map.forEach(
                (k, v) -> {
                    if (v.size() > k) {
                        for (int i = 0; i < v.size(); i += k) {
                            result.add(v.subList(i, i + k));
                        }
                    } else {
                        result.add(v);
                    }
                });
        return result;
    }
}
