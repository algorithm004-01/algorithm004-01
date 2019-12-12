#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    /*****
     解法1：DP
            时间复杂度O(n)
            空间复杂度O(n)
    ******/
    int helper1(vector<int>& nums)
    {
        int n = nums.size();
        if(n == 0)
            return 0;
        if(n == 1)
            return nums[0];

        int dp[n];
        dp[0] = nums[0];

        int res = nums[0];
        for(int i=1;i<n;++i)
        {
            dp[i] = max(dp[i-1] + nums[i],nums[i]);
            res = max(res,dp[i]);
        }
        return res;
    }

    /*****
     解法2：DP,去掉数组dp[n],cur,pre来代替
            时间复杂度O(n)
            空间复杂度O(1)
    ******/
    int helper2(vector<int>& nums)
    {
        int n = nums.size();
        if(n == 0)
            return 0;
        if(n == 1)
            return nums[0];

        int cur;
        int pre = nums[0];
        int res = nums[0];
        for(int i=1;i<n;++i)
        {
            cur = max(pre + nums[i],nums[i]);
            res = max(res,cur);
            pre = cur;
        }
        return res;
    }

    int maxSubArray(vector<int>& nums) {
        int res;
        //res = helper1(nums);//DP
        res = helper2(nums);//DP2
        return res;
    }
};

int main()
{
    Solution s;
    vector<int> nums{-2,1,-3,4,-1,2,1,-5,4};//测试案例，预期结果6
    int res = s.maxSubArray(nums);
    cout << res << endl;
    return 0;
}
