package com.practice.algorithm.string;

/** 字符串转换 */
public class StringConversion {
    /**
     * 题目描述：
     *
     * <p>已知一个字符串a，b。 字符串b中包含特殊符号'.', '*'。 '.'表示该字符可以变成任意字符，'*'表示该字符的前一个字符可以变成任意多个。
     * 现在我们想知道b可否通过特殊符号变成a。 a* 可以转化为a,aa,aaa,aaaa…
     *
     * <p>输入描述：第一行输入字符串a.(1<=len(a)<=1000) 第二行输入字符串b.(1<=len(b)<=1000)
     *
     * <p>输出描述：如果可以输出"yes", 否则输出"no"
     *
     * <p>示例 1：输入 aa a*；输出 yes
     */
    public static void main(String[] args) {
        // 将字符串转为char数组操作
        System.out.println(solution("aa", "a*"));
        System.out.println(solution("abbacddd", "a.*a..*"));
        System.out.println(solution("abc", "a.*"));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(1) */
    public static String solution(String a, String b) {
        boolean result = true;
        int n = a.length();

        // 定义字符串b的下标和上一位字符
        int index = 0;
        char last = '.';

        for (int i = 0; i < n; i++) {
            // 若字符串b已遍历完，a还有剩余，则无法转换
            if (index > b.length() - 1) {
                result = false;
                break;
            }
            // 若b当前字符为'.'，则可以匹配任意字符，同时更新上一个字符的值
            if (b.charAt(index) == '.' || a.charAt(i) == b.charAt(index)) {
                last = a.charAt(i);
                index++;
            } else if (index > 0 && b.charAt(index) == '*' && a.charAt(i) == last) {
                // 若b的非首位字符是'*'，则需要根据上一个字符来进行匹配多个相同字符
                boolean flag = true;
                for (int j = i; j < n; j++) {
                    if (a.charAt(j) != last) {
                        i = j - 1;
                        flag = false;
                        break;
                    }
                }
                // 若a字符串已遍历完，b也遍历完，则直接返回成功
                if (flag && index == b.length() - 1) {
                    break;
                }
                index++;
            } else {
                // 单反有一个字符匹配不上，则返回失败
                result = false;
                break;
            }
        }

        return result ? "yes" : "no";
    }
}
