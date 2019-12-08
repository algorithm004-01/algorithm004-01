import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        // for (int i = nums.length - 1; i >= 0; i--) {
        //     int index = (i + k) % nums.length;   
        // }
        int[] res = new int[nums.length];
        int index = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            index = (i + k) % nums.length;
            res[index] = nums[i];
        }
        System.arraycopy(res, 0, nums, 0, res.length);
    }
}
// @lc code=end

