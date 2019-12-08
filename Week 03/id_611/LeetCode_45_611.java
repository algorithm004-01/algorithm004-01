/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {
        int end = 0;
        int maxPostion = 0;
        int step = 0;
        for(int i = 0; i < nums.length-1; i++){
            maxPostion = Math.max(maxPostion, nums[i] + i);
            if(i == end){
                end = maxPostion ;
                step++;
            }
        }
        return step;
    }
}
// @lc code=end

