package com.practice.algorithm.other;

import java.util.Arrays;
import java.util.List;

/** 多边形的面积 */
public class AreaOfPolygon {
    /**
     * 题目描述：
     *
     * <p>给出一个简单多边形(没有缺口)，它的边要么是垂直的，要么是水平的。要求计算多边形的面积。
     *
     * <p>多边形被放置在一个 X-Y 的卡笛尔平面上，它所有的边都平行于两条坐标轴之一。然后按逆时针方向给出各顶点的坐标值。
     *
     * <p>所有的坐标值都是整数(因此多边形的面积也为整数)。
     *
     * <p>输入描述：每行给出多边形一个顶点的坐标值 X 和 Y (都为整数并且用空格隔开)。
     *
     * <p>顶点按逆时针方向逐个给出。并且多边形的每一个顶点的坐标值 -200≤x,y≤200。多边形最后是靠从最后一个顶点到第一个顶点画一条边来封闭的。
     *
     * <p>输出描述：一个整数，表示多边形的面积。
     *
     * <p>示例1：输入 0 0 4 0 4 1 3 1 3 3 2 3 2 2 1 2 1 3 0 3；输出 9
     */
    public static void main(String[] args) {
        // 对于封闭多边形，在卡笛尔平面内，其面积 S += (xLast - xCurrent) * (yLast + yCurrent) * 0.5;
        System.out.println(
                solution(
                        Arrays.asList(
                                Arrays.asList(0, 0),
                                Arrays.asList(4, 0),
                                Arrays.asList(4, 1),
                                Arrays.asList(3, 1),
                                Arrays.asList(3, 3),
                                Arrays.asList(2, 3),
                                Arrays.asList(2, 2),
                                Arrays.asList(1, 2),
                                Arrays.asList(1, 3),
                                Arrays.asList(0, 3))));
    }

    /** 时间复杂度：O(n)，空间复杂度：O(1) */
    public static int solution(List<List<Integer>> list) {
        // 利用多边形面积公式求解：S += (xLast - xCurrent) * (yLast + yCurrent) * 0.5;
        int result = 0;

        // 表示上一个坐标点的x y坐标值
        int xLast = list.get(0).get(0);
        int yLast = list.get(0).get(1);

        // 遍历每个坐标，求面积
        for (int i = 1; i < list.size(); i++) {
            // 表示当前坐标点的x y坐标值
            int xCurrent = list.get(i).get(0);
            int yCurrent = list.get(i).get(1);

            result += (xLast - xCurrent) * (yLast + yCurrent) * 0.5;

            // 更新上一个点的坐标值
            xLast = xCurrent;
            yLast = yCurrent;
        }

        // 用最后一个的坐标点与第一个坐标点进行一次面积运算
        result += (xLast - list.get(0).get(0)) * (yLast + list.get(0).get(1)) * 0.5;
        // 返回面积
        return result;
    }
}
