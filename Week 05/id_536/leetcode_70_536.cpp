#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    /*****
     �ⷨ1��DP
            ʱ�临�Ӷ�O(n)
    *****/
    int dp(int n)
    {
        if(n == 0 || n == 1)
            return n;
        int ans[n+1] = {0};
        ans[1] = 1;
        ans[2] = 2;
        for(int i=3;i<=n;++i)
          ans[i] = ans[i-1] + ans[i-2];
        return ans[n];
    }

    /*****
     �ⷨ2���ݹ飬�м����ݴ�
            ʱ�临�Ӷ�O(n)
    *****/
    int recurse(int n,vector<int>& ans)
    {
        //terminator
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;

        //process,drill
        if(ans[n] == 0)
            ans[n] = recurse(n-1,ans)+recurse(n-2,ans);

        return ans[n];

    }

    int climbStairs(int n) {
        int res;
        //res = dp(n);//��̬�滮
        //�ݹ鿪ʼ
        vector<int> ans(n+1,0);
        res = recurse(n,ans);
        //�ݹ����
        return res;
    }
};

int main()
{
    Solution s;
    int n = 5;
    int res = s.climbStairs(n);
    cout << res << endl;
    return 0;
}
