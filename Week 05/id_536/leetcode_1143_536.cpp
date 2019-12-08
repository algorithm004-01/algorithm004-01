#include <iostream>
#include <string.h>

using namespace std;

class Solution {
public:
    /******
     解法1：DP
            时间复杂度O(len1*len2)
    ******/
    int dp(string text1, string text2)
    {
        int len1 = text1.size();
        int len2 = text2.size();
        int ans[len1+1][len2+1];
        memset(ans,0,sizeof(ans));
        for(int i=1;i<=len1;++i)
        {
            for(int j=1;j<=len2;++j)
            {
                if(text1[i-1] == text2[j-1])
                    ans[i][j] = ans[i-1][j-1] + 1;
                else
                    ans[i][j] = max(ans[i-1][j],ans[i][j-1]);
            }
        }
        return ans[len1][len2];
    }

    int longestCommonSubsequence(string text1, string text2) {
        int res;
        res = dp(text1,text2);
        return res;
    }
};

int main()
{
    Solution s;
    string text1 = "bsbininm";
    string text2 = "jmjkbkjkv";
    int res = s.longestCommonSubsequence(text1,text2);
    cout << res << endl;
    return 0;
}
