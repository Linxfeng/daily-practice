package com.practice.algorithm.string;

/** 外观数列 */
public class AppearanceArray {
    /**
     * 题目描述：
     *
     * <p>给定一个正整数 n ，输出外观数列的第 n 项。
     *
     * <p>「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
     *
     * <p>你可以将其视作是由递归公式定义的数字字符串序列：
     *
     * <p>solution(1) = "1"；solution(n) 是对 solution(n-1) 的描述，然后转换成另一个数字字符串。
     *
     * <p>前五项如下：1 11 21 1211 111221；第一项是数字 1 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11" 描述前一项，这个数是 11 即 “ 二 个
     * 1 ” ，记作 "21" 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211" 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 +
     * 二 个 1 ” ，记作 "111221"
     *
     * <p>要描述一个数字字符串，首先要将字符串分割为最小数量的组，每个组都由连续的最多相同字符组成。
     *
     * <p>然后对于每个组，先描述字符的数量，然后描述字符，形成一个描述组。
     *
     * <p>要将描述转换为数字字符串，先将每组中的字符数量用数字替换，再将所有描述组连接起来。
     *
     * <p>示例 1：输入：n = 1；输出："1"。解释：这是一个基本样例。
     *
     * <p>示例 2：输入：n = 4；输出："1211"。
     *
     * <p>解释： solution(1) = "1"，solution(2) = 读 "1" = 一 个 1 = "11"，solution(3) = 读 "11" = 二 个 1 =
     * "21"，solution(4) = 读 "21" = 一 个 2 + 一 个 1 = "12" + "11" = "1211"
     *
     * <p>提示：1 <= n <= 30
     */
    public static void main(String[] args) {
        System.out.println(solution(1));
        System.out.println(solution(4));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(n) */
    public static String solution(int n) {
        String pre = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder temp = new StringBuilder();
            char c = pre.charAt(0);
            int cnt = 1;
            for (int j = 1; j < pre.length(); j++) {
                char cc = pre.charAt(j);
                if (c == cc) {
                    cnt++;
                } else {
                    temp.append(cnt).append(c);
                    cnt = 1;
                    c = cc;
                }
            }
            temp.append(cnt).append(c);
            pre = temp.toString();
        }
        return pre;
    }
}
