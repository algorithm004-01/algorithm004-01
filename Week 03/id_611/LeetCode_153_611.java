/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        if(nums.length==0) return 0;
        int left =0;
        int right = nums.length -1;
        while(left < right){
            int mid = (right + left) /2;
            if(nums[mid] > nums[right]) left = mid +1;
            else right = mid;
        }
        return nums[left];
    }
}
// @lc code=end

