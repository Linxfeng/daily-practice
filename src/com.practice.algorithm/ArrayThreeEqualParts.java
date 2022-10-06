package com.practice.algorithm;

import java.util.Arrays;

/** 数组三等分 */
public class ArrayThreeEqualParts {
    /**
     * 题目描述：
     *
     * <p>给定一个由0和1组成的数组arr，将数组分成3个非空的部分，使得所有这些部分表示相同的二进制值。
     *
     * <p>如果可以做到，请返回任何 [i, j]，其中 i+1 < j，这样一来：
     *
     * <p>arr[0], arr[1], ..., arr[i] 为第一部分；
     *
     * <p>arr[i + 1], arr[i + 2], ..., arr[j - 1] 为第二部分；
     *
     * <p>arr[j], arr[j + 1], ..., arr[arr.length - 1] 为第三部分。这三个部分所表示的二进制值相等。
     *
     * <p>如果无法做到，就返回 [-1, -1]。
     *
     * <p>注意，在考虑每个部分所表示的二进制时，应当将其看作一个整体。例如，[1,1,0] 表示十进制中的 6，而不会是 3。
     *
     * <p>此外，前导零也是被允许的，所以 [0,1,1] 和 [1,1] 表示相同的值。
     *
     * <p>示例 1：输入：arr = [1,0,1,0,1] 输出：[0,3]
     *
     * <p>示例 2：输入：arr = [1,1,0,1,1] 输出：[-1,-1]
     *
     * <p>示例 3：输入：arr = [1,1,0,0,1] 输出：[0,2]
     *
     * <p>提示：3 <= arr.length <= 3 * 10^4；arr[i] 是 0 或 1
     *
     * <p>来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/three-equal-parts
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[] {1, 0, 1, 0, 1})));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(1) */
    public static int[] solution(int[] arr) {
        // 统计arr数组中1的数量
        int sum = Arrays.stream(arr).sum();
        // 若1的数量不能被3等分，则数组无法三等分
        if (sum % 3 != 0) {
            return new int[] {-1, -1};
        }
        // 若arr数组中没有1，则任意分配都可满足要求
        if (sum == 0) {
            // 假设arr长度最小为3，则返回0,2
            return new int[] {0, 2};
        }
        // 被三等分出来的1的数量
        int partial = sum / 3;
        int first = 0, second = 0, third = 0, cur = 0;
        for (int i = 0; i < arr.length; i++) {
            // 找到arr中第1个出现1的位置first
            if (arr[i] == 1) {
                if (cur == 0) {
                    first = i;
                } else if (cur == partial) {
                    // 第partial+1个出现1的位置second
                    second = i;
                } else if (cur == 2 * partial) {
                    // 第2×partial+1个出现1的位置third
                    third = i;
                }
                cur++;
            }
        }
        // 表示二进制值的长度
        int len = arr.length - third;
        if (first + len <= second && second + len <= third) {
            int i = 0;
            // 判断是否满足条件
            while (third + i < arr.length) {
                if (arr[first + i] != arr[second + i] || arr[first + i] != arr[third + i]) {
                    return new int[] {-1, -1};
                }
                i++;
            }
            // 返回满足条件的答案
            return new int[] {first + len - 1, second + len};
        }
        // 不满足条件
        return new int[] {-1, -1};
    }
}
