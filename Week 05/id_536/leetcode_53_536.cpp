#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    /*****
     �ⷨ1��DP
            ʱ�临�Ӷ�O(n)
            �ռ临�Ӷ�O(n)
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
     �ⷨ2��DP,ȥ������dp[n],cur,pre������
            ʱ�临�Ӷ�O(n)
            �ռ临�Ӷ�O(1)
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
    vector<int> nums{-2,1,-3,4,-1,2,1,-5,4};//���԰�����Ԥ�ڽ��6
    int res = s.maxSubArray(nums);
    cout << res << endl;
    return 0;
}
