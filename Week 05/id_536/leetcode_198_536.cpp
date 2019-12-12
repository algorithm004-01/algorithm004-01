#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    /******
     �ⷨ1��DP
            dp[i]��ʾ��ǰi�������������ٵ����������
            dp[i] = max( dp[i-2] + nums[i],  ����i��
                         dp[i-1])            ������i��
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

        vector<int> dp(n,0);
        dp[0] = nums[0];
        dp[1] = max(nums[0],nums[1]);

        for(int i = 2; i < n; ++i)
           dp[i] = max(dp[i-2] + nums[i], dp[i-1]);

        return dp[n-1];
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
    //vector<int> nums{2,1,1,2};//Ԥ�ڽ��4
    vector<int> nums{2, 5, 17, 3, 9, 28, 19, 29, 5, 7, 31};//Ԥ�ڽ��107
    int res = s.rob(nums);
    cout << res << endl;
    return 0;
}
