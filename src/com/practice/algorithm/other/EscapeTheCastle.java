package com.practice.algorithm.other;

/** 逃离城堡 */
public class EscapeTheCastle {
    /**
     * 题目描述：
     *
     * <p>小艺酱误入龙族结界，被恶龙带回城堡。小艺酱决定逃离城堡，逃离龙族结界，总路程为c。
     *
     * <p>小艺酱的速度是vp，饿龙速度为vd。饿龙会在t小时后发现小艺酱出逃。小艺酱担心自己跑不出去，准备了好多珍宝。
     *
     * <p>每当饿龙追上自己的时候小艺酱就会丢下一个珍宝，饿龙捡到珍宝会返回自己的城堡进行研究，研究f小时后，再出城堡追赶小艺。
     *
     * <p>小艺想知道自己至少需要丢多少珍宝才能让自己安全逃出结界。
     *
     * <p>输入描述：输入整数vp，vd，t，f，c。(1<=vp，cd<=100，1<=t，f<=10，1<=c<=1000)
     *
     * <p>输出描述：输出答案。
     *
     * <p>示例 1：输入 1 2 1 1 10，输出 2
     */
    public static void main(String[] args) {
        // 折返追及问题。公式：追及所需要的时间：x = vp * t / (vd - vp)
        System.out.println(solution(1, 2, 1, 1, 10));
    }

    /** 时间复杂度：O(log n)，空间复杂度：O(1) */
    public static int solution(int vp, int vd, int t, int f, int c) {
        int result = 0;

        // 当后者速度小于等于前者，则追不上，无需珍宝
        if (vd <= vp) {
            return 0;
        }

        // 推演追及的过程，每次追上则result+1
        double x = 1;
        double time = t;
        while (x > 0) {
            x = catchUp(vp, vd, time, c);
            if (x > 0) {
                // 每次追上都需要一件珍宝
                result++;
                // 恶龙返回，需再花费时间 x + f 小时，再次追及
                time = time + x + x + f;
            }
        }
        return result;
    }

    /** 是否能够追上，能追上，则返回花费的时间x，不能追上则返回-1 */
    public static double catchUp(int vp, int vd, double t, int c) {
        // 追上前者需要花费x小时，则 x = vp * t / (vd - vp)
        double x = (double) vp * t / (double) (vd - vp);

        // 是否在追上之前逃出
        if (vp * (t + x) >= c) {
            return -1;
        }
        return x;
    }
}
