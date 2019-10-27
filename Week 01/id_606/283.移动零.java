/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 *
 * https://leetcode-cn.com/problems/move-zeroes/description/
 *
 * algorithms
 * Easy (56.98%)
 * Likes:    414
 * Dislikes: 0
 * Total Accepted:    76K
 * Total Submissions: 132.8K
 * Testcase Example:  '[0,1,0,3,12]'
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 
 * 示例:
 * 
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 
 * 说明:
 * 
 * 
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * 
 * 
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int nonzeroIndex = 0;//0的位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i > nonzeroIndex) {
                    nums[nonzeroIndex] = nums[i];//0的位置，设置i
                    nums[i] = 0;//不是0的位置设置为0
                }
                nonzeroIndex++;
            }
        }
 
    }
}
// @lc code=end
