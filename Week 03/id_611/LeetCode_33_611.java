/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        int minIdx = findMinidx(nums);
        if(target == nums[minIdx]) return minIdx;
        int m = nums.length -1;
        int start = (target <= nums[m]) ? minIdx : 0;
        int end = (target > nums[m]) ? minIdx : m; 
        
        while(start <= end){
            int mid = (start+(end - start)) >>>1;
            if(nums[mid] == target) return mid;
            else if(target > nums[mid]) start = mid +1;
            else end = mid -1;
        }
        return -1;
    }

    public int findMinidx(int[] nums){
        int start = 0 , end = nums.length -1;
        while(start < end){
            int mid = (start + ( end - start)) >>>1;
            if (nums[mid] > nums[end]) start = mid + 1;
            else end = mid;
        }
        return start;
    }
}
// @lc code=end

