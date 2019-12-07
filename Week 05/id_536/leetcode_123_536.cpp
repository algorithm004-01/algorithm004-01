#include <iostream>
#include <vector>
#include <string.h>

using namespace std;

/*动态规划思路：
  0、前提：本题假设可以当天买入当天卖出
     时间复杂度：O(n*k),n为交易天数,k为交易次数
     空间复杂度：O(n*k),可以简化为O(1)
  1、DP状态定义：
    dp[i][j][0]表示第i天、第j笔交易、不持有股票的最大收益
    dp[i][j][1]表示第i天、第j笔交易、持有股票的最大收益
    注：其中0 <= i < prices.size();0 < j <= k;
    最大收益即为dp[prices.size()-1][k][0]；
    注：最后1天，做完k笔交易，并且股票全部卖出
  2、DP状态方程：
    dp[i][j][0] = max(dp[i-1][j][0],dp[i-1][j][1] + prices[i]);
                         休息                卖出
    dp[i][j][1] = max(dp[i-1][j][1],dp[i-1][j-1][0] - prices[i]);
                         休息                买入
  3、初始化
    dp[0][j][0] = 0;
    dp[0][j][1] = -prices[0];
*/
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        //terminator
        int n = prices.size();
        if(n == 0) return 0;

        //initial
        const int k = 2;     //本题最多交易2次
        int dp[n][k+1][2];   //k+1是为了防止后续状态方程数组下标j-1<0出现异常
        memset(dp,0,sizeof(dp));
        for(int i=1;i<=k;++i)//初始第一天持有状态
            dp[0][i][1] = -prices[0];

        //process
        for(int i=1;i<n;++i)//第2天开始处理
        {
            for(int j=1;j<=k;++j)
            {
                 dp[i][j][0] = max(dp[i-1][j][0],dp[i-1][j][1] + prices[i]);
                 dp[i][j][1] = max(dp[i-1][j][1],dp[i-1][j-1][0] - prices[i]);
            }
        }

        //return
        return dp[n-1][k][0];
    }
};

int main()
{
    Solution s;
    //vector<int> prices{3,3,5,0,0,3,1,4};
    vector<int> prices{1,2,3,4,5};
    int res = s.maxProfit(prices);
    cout << res << endl;
    return 0;
}
