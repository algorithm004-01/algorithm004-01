class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        int[] dp = new int[len];
        int maxLen = 1;
        for(int i = 0;i < len;i++){
            int tempLen = 1;
            for(int j = 0;j < i;j++){
                if(nums[i] > nums[j]){
                    tempLen = Math.max(dp[j] + 1,tempLen);
                }
            }
            //记录以索引i结尾的子数组的最长上升子序列长度
            dp[i] = tempLen;
            //记录此时的全局最优解
            if(tempLen > maxLen){
                maxLen = tempLen;
            }
        }
        return maxLen;
    }
}
