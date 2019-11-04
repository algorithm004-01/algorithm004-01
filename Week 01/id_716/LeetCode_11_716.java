// package io.github.shniu.arts.training.week01;

// https://leetcode-cn.com/problems/container-with-most-water/
public class LeetCode_11_716 {

    // 1. 暴力法, 时间复杂度高，O(n^2)
    public int maxArea1(int[] height) {
        int maxarea = 0;

        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int minHeight = Math.min(height[i], height[j]);
                maxarea = Math.max(maxarea, minHeight * (j - i));
            }
        }

        return maxarea;
    }

    // 2. 双指针法
    // 2.1 写法
    public int maxArea21(int[] height) {
        int maxarea = 0;

        for (int left = 0, right = height.length - 1; left < right;) {
            int minHeight = Math.min(height[left], height[right]);
            maxarea = Math.max(maxarea, minHeight * (right - left));
            // 看一下谁短就谁往里收缩一步
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxarea;
    }

    // 2.2 2.1写法的改进版
    public int maxArea22(int[] height) {
        int maxarea = 0;

        for (int left = 0, right = height.length - 1; left < right;) {
            int minHeight = height[left] < height[right] ? height[left++] : height[right--];
            // 注意这里要+1
            maxarea = Math.max(maxarea, minHeight * (right - left + 1));
        }

        return maxarea;
    }

    // 2.3 更高效的写法
    public int maxArea23(int[] height) {
        int maxarea = 0;

        for (int left = 0, right = height.length - 1; left < right;) {
            int minHeight = Math.min(height[left], height[right]);
            maxarea = Math.max(maxarea, minHeight * (right - left));

            // 减少无用的面积计算次数，排除掉不需要计算的情况
            while (height[left] <= minHeight && left < right) left++;
            while (height[right] <= minHeight && left < right) right--;
        }

        return maxarea;
    }
}

