/*
 * @lc app=leetcode.cn id=493 lang=java
 *
 * [493] 翻转对
 */

// @lc code=start
class Solution {
        
    public int res;
    public int reversePairs(int[] nums) {
        res = 0;
        mergeSort(nums, 0, nums.length-1);
        return res;
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (right <= left) {
            return;
        }
        int middle = left + (right - left)/2;
        mergeSort(nums, left, middle);
        mergeSort(nums,middle+1, right);

        //count elements
        int count = 0;
        for (int l = left, r = middle+1; l <= middle;) {
            if (r > right || (long)nums[l] <= 2*(long)nums[r]) {
                l++;
                res += count;
            } else {
                r++;
                count++;
            }
        }
        
        //sort
        Arrays.sort(nums, left, right + 1);   
    }
}
// @lc code=end

