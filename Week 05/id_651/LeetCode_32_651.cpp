/*
给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
示例 1:
输入: "(()"
输出: 2
解释: 最长有效括号子串为 "()"
示例 2:
输入: ")()())"
输出: 4
解释: 最长有效括号子串为 "()()"

思路： 
    以')' 作为标准， 判断当前的值是什么
        如果是'(', 则加上 dp[i-2] 的值
        如果是')', 则判断下前面是否有一对有效括号(i-dp[i-1] > 0 且 s[i-dp[i-1]-1] == '(')
                    记录前一对括号的有效数字+2+前前对括号

*/
# include <iostream>
# include <windows.h>
# include <vector>
using namespace std;

class Solution {
public:
    int longestValidParentheses(string s) {
        int result = 0;
        vector<int> dp(s.size(), 0);
        for(int i=1;i< s.size();i++){
            if (s[i] == ')'){
                if (s[i-1] == '('){
                    // 判断是否有前一个有效的（）
                    if (i - dp[i] > 2) dp[i] = dp[i-2] + 2;
                    else dp[i] = 2;
                }
                else if (i-dp[i-1]>0 && s[i-dp[i-1]-1] == '('){
                    // 判断是否有前一个有效的（）, 当前值+前一个+上上个
                    if (i - dp[i-1] - 2 > 0) dp[i] = dp[i-1] + 2 + dp[i-dp[i-1] -2];
                    else dp[i] = dp[i-1] + 2;
                }
            }
            result = max(result, dp[i]);
        }
        return result;
    }
}

int main(){
    Solution sol;
    return 0;
}