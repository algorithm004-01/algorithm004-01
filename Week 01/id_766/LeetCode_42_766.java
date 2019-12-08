/*
 * @lc app=leetcode.cn id=42 lang=java
 *
 * [42] 接雨水
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int n = height.length;
        int[] left_max = new int[n];
        int[] right_max = new int[n];
        left_max[0] = height[0];
        int res = 0;
        right_max[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) left_max[i] = Math.max(left_max[i - 1], height[i]);
        for (int i = n - 2; i >= 0; i--) {
            right_max[i] = Math.max(right_max[i + 1], height[i]);
            res += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return res;
    }
}
// @lc code=end

