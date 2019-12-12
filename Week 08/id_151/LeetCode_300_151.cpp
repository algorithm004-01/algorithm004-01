class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        if (nums.empty())
            return 0;
        
        vector<int> dp(nums.size(), 1);
        int res = 1;
        
        for (int i = 1; i < nums.size(); ++i) {
            int m = 0;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j])
                    m = max(m, dp[j]);
            }
            
            dp[i] = m + 1;
            res = max(res, dp[i]);
        }
        
        return res;
    }
};
