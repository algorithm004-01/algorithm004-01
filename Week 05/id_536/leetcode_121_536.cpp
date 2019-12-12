#include <iostream>
#include <vector>
#include <string.h>

using namespace std;

/*DP,��leetcod_121���������
  ʱ�临�Ӷ�O(n)
  �ռ临�Ӷ�O(n)
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
        dp[0][0] = 0;         //��ʼ��һ��ǳ���״̬
        dp[0][1] = -prices[0];//��ʼ��һ�����״̬

        //process
        for(int i=1;i<n;++i)//��2�쿪ʼ����
        {
             dp[i][0] = max(dp[i-1][0],dp[i-1][1] + prices[i]);//���������
             dp[i][1] = max(dp[i-1][1], -prices[i]);           //���������
        }

        //return
        return dp[n-1][0];
    }
};

int main()
{
    Solution s;
    vector<int> prices{7,1,5,3,6,4};//Ԥ�ڽ��5
    //vector<int> prices{7,6,4,3,1};//Ԥ�ڽ��0
    int res = s.maxProfit(prices);
    cout << res << endl;
    return 0;
}
