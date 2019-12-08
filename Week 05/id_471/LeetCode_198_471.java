class Solution {
    public int rob(int[] nums) {
        
        int preMax = 0, curMax = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int temp = curMax;
            curMax = Integer.max(curMax, preMax + nums[i]);
            preMax = temp;
        }
        
        return curMax;
    }
}