/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int area = 0;
        int f = 0;
        int l = height.length - 1;
        while (l > f) {
            int thisHeight = Math.min(height[f], height[l]);
            int thisArea = thisHeight * (l - f);
            area = Math.max(area, thisArea);
            if (height[f] < height[l]) {
                f++;
            } else {
                l--;
            }
        }
        return area;
    }

}
// @lc code=end
