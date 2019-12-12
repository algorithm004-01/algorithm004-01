#include <iostream>
#include <queue>
#include <set>

using namespace std;

class Solution {
public:
    /*****
     �ⷨ1:�ݹ�
           ʱ�临�Ӷ�O(n)
           �ռ临�Ӷ�O()
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
     �ⷨ2:DP
           dp���̣�f(n) =  {  0              ; ��n=0
                              1 + min{f(n-Ci)}; ��n>0
           ע:nΪ��CiΪӲ����ֵ��iΪ��ֵ������
           ʱ�临�Ӷ�O(n*amount),nΪӲ������
           �ռ临�Ӷ�O(amount)
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
     �ⷨ3:BFS + ��֦
           ?ʱ�临�Ӷ�O(2^n-T),nΪ�㼶����ȥ����֦�ĸ���ʱ��T��
    *****/
    int helper3(vector<int>& coins, int amount) {
        queue<int> q;      //�洢ʣ���amount
        set<int> visited;  //�ѷ��ʹ������ڼ�֦
        q.push(amount);
        int res = 0;       //��Ҹ�����������
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
                    else   //��һ�����
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
        if(n == 0)        //Ӳ�Ҹ���0
            return -1;
        if(amount == 0)   //����0
            return 0;

        //�ݹ鿪ʼ
        //res = helper1(coins,amount);
        //�ݹ����
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
