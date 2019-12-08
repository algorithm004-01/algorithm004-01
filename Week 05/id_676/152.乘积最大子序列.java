/*
 * @lc app=leetcode.cn id=152 lang=java
 *
 * [152] 乘积最大子序列
 */

// @lc code=start
class Solution {
    public int maxProduct(int[] nums) {
        int[] dpmax = new int[nums.length];
        int[] dpmin = new int[nums.length];
        dpmax[0] = nums[0];
        dpmin[0] = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dpmax[i] = nums[i]*Math.max(1,Math.max(dpmax[i-1], dpmin[i-1]));
            dpmin[i] = nums[i]*Math.min(1,Math.min(dpmax[i-1],dpmin[i-1]));
            max = Math.max(max, Math.max(dpmax[i], dpmin[i]));
        }
        return max;
    }
}
// @lc code=end
class SolutionOne {
    public int maxProduct(int[] nums) {
        int imax = nums[0];
        int imin = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {  //判断当前元素的符号，如果为负，交换最大最小
                int temp = imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max(nums[i], nums[i]*imax);
            imin = Math.min(nums[i], nums[i]*imin);
            max = Math.max(max, imax);
        }
        return max;
    }
}
