#include <iostream>
#include <string.h>
#include <vector>

using namespace std;

class Solution {
public:
    /******
     �ⷨ1��DP����������
            ʱ�临�Ӷ�O(n*n)
    *******/
    int dp(vector<vector<int>>& triangle)
    {
        int n = triangle.size();//����
        if(n == 0)
            return 0;
        if(n == 1)
            return triangle[0][0];

        //�����Ա����ͳһ�߼�����
        int ans[n+1][n+1];
        for(int i=0;i<=n;++i)
            for(int j=0;j<=n;++j)
               ans[i][j] = INT_MAX;
        ans[0][0] = 0;
        ans[0][1] = 0;

        int temp = INT_MAX;
        for(int i = 1; i <= n ; ++i)
        {
            for(int j = 1; j <= triangle[i-1].size(); ++j)
            {
                //����ͼʾ���Զ����¿���������ݽṹֻ�����·������·���·��
                ans[i][j] = min(ans[i-1][j-1],ans[i-1][j]) + triangle[i-1][j-1];
                if(i == n && ans[i][j] < temp)//���һ�н����С�ļ�Ϊ��
                    temp = ans[i][j];
            }
        }
        return temp;
    }

    /******
     �ⷨ2��DP���������������
            ʱ�临�Ӷ�O(n*n)
    *******/
    int dp2(vector<vector<int>>& triangle)
    {
        int n = triangle.size();//����
        if(n == 0)
            return 0;
        if(n == 1)
            return triangle[0][0];
        int ans[n][n];
        //vector<vector<int>> ans(n,vector<int>(n));
        ans[0][0] = triangle[0][0];

        int temp = INT_MAX;
        for(int i = 1; i < n ; ++i)
        {
            for(int j = 0; j < triangle[i].size(); ++j)
            {
                if(j == 0)//��1��
                    ans[i][j] = ans[i-1][j] + triangle[i][j];
                else if(j == triangle[i].size() - 1)//ÿ�����һ��
                    ans[i][j] = ans[i-1][j-1] + triangle[i][j];
                else
                    ans[i][j] = min(ans[i-1][j-1],ans[i-1][j]) + triangle[i][j];

                if(i == n-1 && ans[i][j] < temp)//���һ�н����С�ļ�Ϊ��
                    temp = ans[i][j];
            }
        }
        return temp;
    }

    int minimumTotal(vector<vector<int>>& triangle) {
        int res;
        //res = dp(triangle);//�ⷨ1
        res = dp2(triangle);//�ⷨ2
        return res;
    }
};

int main()
{
    Solution s;
    vector<vector<int>> triangle{{2},{3,4},{6,5,7},{4,1,8,3}};//���԰�����Ԥ��11
    /********�ⷨ1��ans[n+1][n+1]ֵ�仯·��
         0 1 2 3 4       0 1 2 3 4     0 1 2 3 4        0 1  2  3  4
         ----------      ----------    ----------       ----------
       0|0 0 m m m     0|0 0 m m m     0|0 0 m m m    0|0 0  m  m  m
       1|m m m m m     1|m 2 m m m     1|m 2 m m m    1|m 2  m  m  m
       2|m m m m m  -> 2|m m m m m ->  2|m 5 6 m m -> 2|m 5  6  m  m
       3|m m m m m     3|m m m m m     3|m m m m m    3|m 11 10 13 m
       4|m m m m m     4|m m m m m     4|m m m m m    4|m 15 11 18 16  -> res = 11
    *********/
    //vector<vector<int>> triangle{{-1},{-2,-3}};//���԰�����Ԥ��-4
    //vector<vector<int>> triangle{{-1},{3,2},{-3,1,-1}};//���԰�����Ԥ��-1
    int res = s.minimumTotal(triangle);
    cout << res << endl;
    return 0;
}
