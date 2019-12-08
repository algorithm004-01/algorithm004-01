class Solution {
    public int maxSubArray(int[] nums) {
        int maxResult = nums[0];
        int curMax = maxResult;
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(curMax + nums[i], nums[i]);
            maxResult = Math.max(maxResult, curMax);
        }
        
        return maxResult;
    }
}