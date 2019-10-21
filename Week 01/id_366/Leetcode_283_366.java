/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 ) {
                nums[count] = nums[i];
                count++;
            }
        }
        for (; count < nums.length; count++) {
            nums[count] = 0;
        }

    }
}
// @lc code=end

