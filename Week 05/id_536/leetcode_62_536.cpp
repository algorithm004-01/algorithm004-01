#include <iostream>
#include <string.h>

using namespace std;

class Solution {
public:
    /******
     �ⷨ1���ݹ飬��ʱ
            ʱ�临�Ӷȣ�O(2^n)
    *******/
    int helper(int x,int y,int m,int n,int &res)
    {
        //terminator
        if(x == 0 || y == 0)
            return 1;

        //process,recurse
        res = helper(x-1,y,m,n,res) + helper(x,y-1,m,n,res);

        return res;
    }

    int recurse(int m,int n)
    {
        if(m<=0 || n<=0)
            return 0;
        if(m==1 || n==1)
            return 1;
        int res = 0;
        helper(m-1,n-1,m,n,res);
        return res;
    }

    /******
     �ⷨ2��DP
            ʱ�临�Ӷ�O(m*n)
    *******/
    int dp(int m,int n)
    {
        int dp[m][n];
        //memset(dp,0,sizeof(dp));
        for(int i=0;i<m;++i)
            dp[i][0] = 1;
        for(int j=0;j<n;++j)
            dp[0][j] = 1;
        for(int i=1;i<m;++i)
        {
            for(int j=1;j<n;++j)
            {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    int uniquePaths(int m, int n) {
        int res;
        //res = recurse(m,n);//�ݹ鷨
        res = dp(m,n);//��̬�滮
        return res;
    }
};

int main()
{
    Solution s;
    int m,n,res;
    m = 7;
    n = 3;
    res = s.uniquePaths(m,n);
    cout << res << endl;
    return 0;
}
