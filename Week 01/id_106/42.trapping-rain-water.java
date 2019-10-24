/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 *
 * https://leetcode.com/problems/trapping-rain-water/description/
 *
 * algorithms
 * Hard (45.14%)
 * Likes:    4656
 * Dislikes: 82
 * Total Accepted:    364.6K
 * Total Submissions: 805.7K
 * Testcase Example:  '[0,1,0,2,1,0,1,3,2,1,2,1]'
 *
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * 
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped. Thanks
 * Marcos for contributing this image!
 * 
 * Example:
 * 
 * 
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * 
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        int v = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--) { //寻找左边最大值
                max_left = Math.max(max_left, height[j]);
            }
            for (int j = i; j < size; j++) { //寻找右边最大值
                max_right = Math.max(max_right, height[j]);
            }
            v += Math.min(max_left, max_right) - height[i];
        }
        return v;
    }
}
// @lc code=end

/**
 * 每个位置左右最大值中较小值为水的高度，同时还要减去在这范围中元素本身的高度
 */