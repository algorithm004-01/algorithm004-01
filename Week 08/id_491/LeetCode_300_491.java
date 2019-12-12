class Solution {
    public int lengthOfLIS(int[] nums) {
        int max = 0;
        int[] memo = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int tempMax = 0;
            if(i == 0) {
                tempMax = 1;
            } else {
                for(int j = i - 1; j >= 0; j--) {
                    if(nums[j] < nums[i]) {
                        tempMax = Math.max(tempMax, memo[j] + 1);
                    }
                }
            }
            tempMax = Math.max(tempMax, 1);
            memo[i] = tempMax;
            max = Math.max(tempMax, max);
        }
        
        return max;
    }
}
