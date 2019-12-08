class Solution {
    public int maxProduct(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int tempMin = min;
            min = Math.min(nums[i], Math.min(max * nums[i], min * nums[i]));
            max = Math.max(nums[i], Math.max(max * nums[i], tempMin * nums[i]));
            result = Math.max(max, result);
        }
        
        return result;
    }
}