#include <iostream>
#include <vector>
#include <string.h>

using namespace std;

/*��̬�滮˼·��
  0��ǰ�᣺���������Ե������뵱������
     ʱ�临�Ӷȣ�O(n*k),nΪ��������,kΪ���״���
     �ռ临�Ӷȣ�O(n*k),���Լ�ΪO(1)
  1��DP״̬���壺
    dp[i][j][0]��ʾ��i�졢��j�ʽ��ס������й�Ʊ���������
    dp[i][j][1]��ʾ��i�졢��j�ʽ��ס����й�Ʊ���������
    ע������0 <= i < prices.size();0 < j <= k;
    ������漴Ϊdp[prices.size()-1][k][0]��
    ע�����1�죬����k�ʽ��ף����ҹ�Ʊȫ������
  2��DP״̬���̣�
    dp[i][j][0] = max(dp[i-1][j][0],dp[i-1][j][1] + prices[i]);
                         ��Ϣ                ����
    dp[i][j][1] = max(dp[i-1][j][1],dp[i-1][j-1][0] - prices[i]);
                         ��Ϣ                ����
  3����ʼ��
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
        const int k = 2;     //������ཻ��2��
        int dp[n][k+1][2];   //k+1��Ϊ�˷�ֹ����״̬���������±�j-1<0�����쳣
        memset(dp,0,sizeof(dp));
        for(int i=1;i<=k;++i)//��ʼ��һ�����״̬
            dp[0][i][1] = -prices[0];

        //process
        for(int i=1;i<n;++i)//��2�쿪ʼ����
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
