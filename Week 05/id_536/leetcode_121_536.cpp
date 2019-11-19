#include <iostream>
#include <vector>
#include <string.h>

using namespace std;

/*DP,在leetcod_121基础上求解
  时间复杂度O(n)
  空间复杂度O(n)
*/
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        //terminator
        int n = prices.size();
        if(n == 0) return 0;

        //initial
        int dp[n][2];
        //memset(dp,0,sizeof(dp));
        dp[0][0] = 0;         //初始第一天非持有状态
        dp[0][1] = -prices[0];//初始第一天持有状态

        //process
        for(int i=1;i<n;++i)//第2天开始处理
        {
             dp[i][0] = max(dp[i-1][0],dp[i-1][1] + prices[i]);//不变或卖出
             dp[i][1] = max(dp[i-1][1], -prices[i]);           //不变或买入
        }

        //return
        return dp[n-1][0];
    }
};

int main()
{
    Solution s;
    vector<int> prices{7,1,5,3,6,4};//预期结果5
    //vector<int> prices{7,6,4,3,1};//预期结果0
    int res = s.maxProfit(prices);
    cout << res << endl;
    return 0;
}
