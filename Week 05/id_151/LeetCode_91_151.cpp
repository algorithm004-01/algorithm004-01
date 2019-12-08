class Solution {
public:
    int numDecodings(string s) {
        if (s.empty() || s[0] == '0')
            return 0;
    /*
        "226"
        '2' 1
        '2' 2
        
        i. 子问题:    f(i) = max(s(i) + f(i - 1), if (s(i-1,i) <= 'Z') s(i-1,i) + f(i - 2))
        ii. 状态定义: dp[i] 到i位置所能decode的个数
        iii. DP方程:
    */
            
        vector<int> dp(s.size(), 1);
        for (int i = 0; i < s.size(); ++i) {
            if (i - 1 >= 0) {                
                string tmp(s, i-1, 2);
                if (tmp == "00") 
                    return 0;
                if (s[i] == '0') {
                    dp[i-1] = 0;
                }
                //cout << "tmp=" << tmp << endl;
                if (atoi(tmp.c_str()) <= 26) {
                    if (i - 2 >= 0) {
                        dp[i] = dp[i-1] + dp[i-2];
                    } else {
                        dp[i] = dp[i-1] + 1;
                    }
                } else {
                    dp[i] = dp[i-1];
                }
            }
        }
        
        /*
        for (int i = 0; i < dp.size(); ++i)
            cout << dp[i] << ",";
        cout << endl;
        */
        
        return dp[s.size()-1];
    }
};
