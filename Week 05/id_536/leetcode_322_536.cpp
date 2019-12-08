#include <iostream>
#include <queue>
#include <set>

using namespace std;

class Solution {
public:
    /*****
     解法1:递归
           时间复杂度O(n)
           空间复杂度O()
    *****/
    int helper1(vector<int>& coins, int amount) {
        //terminator
        if(amount == 0)
            return 1;

        //process

        //drill

        //combine

    }

    /*****
     解法2:DP
           dp方程：f(n) =  {  0              ; 当n=0
                              1 + min{f(n-Ci)}; 当n>0
           注:n为余额，Ci为硬币面值，i为面值种类数
           时间复杂度O(n*amount),n为硬币种类
           空间复杂度O(amount)
    *****/
    int helper2(vector<int>& coins, int amount) {
        vector<int> dp(amount+1,amount+1);
        dp[0] = 0;
        for(int i = 1; i <= amount; ++i)
        {
            for(int j = 0; j < coins.size(); ++j)
            {
                if(coins[j] <= i)
                    dp[i] = min(dp[i-coins[j]] + 1,dp[i]);
            }
        }
        return dp[amount] == amount +1 ? -1 : dp[amount];
    }

    /*****
     解法3:BFS + 剪枝
           ?时间复杂度O(2^n-T),n为层级，需去除剪枝的个数时间T。
    *****/
    int helper3(vector<int>& coins, int amount) {
        queue<int> q;      //存储剩余额amount
        set<int> visited;  //已访问过金额，用于剪枝
        q.push(amount);
        int res = 0;       //零币个数，即层数
        while(!q.empty())
        {
            ++res;
            int width = q.size();
            while(width--)
            {
                int curAmount = q.front();
                q.pop();
                for(int i=0;i<coins.size();++i)
                {
                    int nextAmount = curAmount - coins[i];
                    if(nextAmount == 0)
                        return res;
                    else if(nextAmount < 0 || visited.count(nextAmount))
                        continue;
                    else   //下一层入队
                    {
                        visited.insert(nextAmount);
                        q.push(nextAmount);
                    }
                }
            }
        }
        return -1;
    }

    int coinChange(vector<int>& coins, int amount) {
        int res;
        int n = coins.size();
        if(n == 0)        //硬币个数0
            return -1;
        if(amount == 0)   //总数0
            return 0;

        //递归开始
        //res = helper1(coins,amount);
        //递归结束
        res = helper2(coins,amount);//BFS
        //res = helper3(coins,amount);//BFS

        return res;
    }
};

int main()
{
    Solution s;
    vector<int> coins{1,2,5};
    int amount = 100;
    int res = s.coinChange(coins,amount);
    cout << res << endl;
    return 0;
}
