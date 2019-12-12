#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    /******
     解法1：DP
            本题在leetcode198题基础上求解，分2种情况：
            1、不打劫第1家，  求dp1[i],1<i<n-1;
            2、不打劫最后一家,求dp2[i],0<i<n-2;
            最终结果max(dp1[n-1],dp2[n-2])
            时间复杂度O(n)
            空间复杂度O(n)
    ******/
    int helper1(vector<int>& nums) {
        int n = nums.size();
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        if(n == 2) return max(nums[0],nums[1]);

        vector<int> dp1(n,0);//不抢第1家
        vector<int> dp2(n,0);//不抢最后1家

        dp1[0] = 0;
        dp2[0] = nums[0];
        dp1[1] = nums[1];
        dp2[1] = max(nums[0],nums[1]);

        for(int i = 2; i < n ; ++i)
        {
            dp1[i] = max(dp1[i-2] + nums[i],dp1[i-1]);//不打劫第1家
            if(i < n-1)
               dp2[i] = max(dp2[i-2] + nums[i],dp2[i-1]);//不打劫最后1家
        }

        return dp1[n-1] > dp2[n-2]? dp1[n-1] : dp2[n-2];
    }

    int rob(vector<int>& nums) {
        int res;
        res = helper1(nums);
        return res;
    }
};

int main()
{
    Solution s;
    vector<int> nums{1,2,3,1};//预期结果4
    //vector<int> nums{2,3,2};//预期结果3
    int res = s.rob(nums);
    cout << res << endl;
    return 0;
}
