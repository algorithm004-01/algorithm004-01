class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robber(nums, 0, nums.length - 2), robber(nums, 1, nums.length - 1));
    }
    
    public int robber(int[] nums, int start, int end) {
        int preMax = 0, curMax = 0;
        
        for (int i = start; i <= end; i++) {
            int temp = curMax;
            curMax = Math.max(preMax + nums[i], curMax);
            preMax = temp;   
        }
        
        return curMax;
    }
}