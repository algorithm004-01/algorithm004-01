/*
定义一个 dp\text{dp}dp 数组，其中第 i 个元素表示以下标为 iii 的字符结尾的最长有效子字符串的长度。我们将 dp\text{dp}dp 数组全部初始化为 0 

And the DP idea is :

If s[i] is '(', set longest[i] to 0,because any string end with '(' cannot be a valid one.

Else if s[i] is ')'

     If s[i-1] is '(', longest[i] = longest[i-2] + 2

     Else if s[i-1] is ')' and s[i-longest[i-1]-1] == '(', longest[i] = longest[i-1] + 2 + longest[i-longest[i-1]-2]

For example, input "()(())", at i = 5, longest array is [0,2,0,0,2,0], longest[5] = longest[4] + 2 + longest[1] = 6.

*/

class Solution {
public:
    int longestValidParentheses(string s) {
        int res = 0;

        vector<int> longest(s.size()+1, 0);
        for(int i = 1; i < s.size(); ++i) {
            // if(s[i] == ')') {
            //     if(s[i-1] == '(') {
            //         longest[i] = (i-2) >= 0 ? (longest[i-2] + 2) : 2;
            //         res = max(longest[i], res);
            //     } else { // if s[i-1] == ')', combine the previous length.
            //         if(i-longest[i-1]-1 >= 0 && s[i-longest[i-1]-1] == '('){
            //             longest[i] = longest[i-1] + 2 + ((i-longest[i-1]-2 >= 0)?longest[i-longest[i-1]-2]:0);
            //             res = max(longest[i], res);
            //         }
            //     }
            // }
            if(s[i] == ')' && i - longest[i] && s[i - longest[i] - 1] == '(') {
                longest[i + 1] = longest[i] + longest[i - longest[i] - 1] + 2;
            }
            res = max(res, longest[i + 1]);
        }
        return res;
    }
};