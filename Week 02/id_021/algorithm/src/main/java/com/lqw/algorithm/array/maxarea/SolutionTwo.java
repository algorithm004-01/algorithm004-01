package com.lqw.algorithm.array.maxarea;

/**
 * @author linqiwen
 */
public class SolutionTwo {

    public int maxArea(int[] height) {
        int max = 0;
        int temp = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int minHigh = height[i] < height[j] ? height[i++] : height[j--];
            if (minHigh > temp) {
                temp = minHigh;
                int area = (j - i + 1) * minHigh;
                max = Math.max(max, area);
            }
        }
        return max;
    }

}
