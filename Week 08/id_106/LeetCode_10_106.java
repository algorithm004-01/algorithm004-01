/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 *
 * https://leetcode.com/problems/regular-expression-matching/description/
 *
 * algorithms
 * Hard (25.81%)
 * Likes:    3331
 * Dislikes: 611
 * Total Accepted:    364.7K
 * Total Submissions: 1.4M
 * Testcase Example:  '"aa"\n"a"'
 *
 * Given an input string (s) and a pattern (p), implement regular expression
 * matching with support for '.' and '*'.
 * 
 * 
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * 
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * Note:
 * 
 * 
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters
 * like . or *.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'.
 * Therefore, by repeating 'a' once, it becomes "aa".
 * 
 * 
 * Example 3:
 * 
 * 
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * 
 * 
 * Example 4:
 * 
 * 
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore,
 * it matches "aab".
 * 
 * 
 * Example 5:
 * 
 * 
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 * 
 * 
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;
        for(int i = 1; i <= s.length(); i++){//不必要，boolean默认都是false
            dp[i][0]=false;
        }
        for(int j = 1; j <= p.length(); j++){
            dp[0][j]=false;
            if(p.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-2];
            }
        }
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=p.length();j++){
                if(p.charAt(j-1)==s.charAt(i-1)||p.charAt(j-1)=='.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i][j-2];
                    if(p.charAt(j-2)==s.charAt(i-1)||p.charAt(j-2) == '.'){
                        dp[i][j] = dp[i][j] | dp[i-1][j];
                    }
                }else{
                    dp[i][j]=false;
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
// @lc code=end
/**
 * .代表匹配任意单个字符
 * *代表匹配0-n个前面的那一个元素
 *  即b* 可以是0 也可以是[1..n)个b
 * 用dp[i][j]表示s p两个字符串每个位置匹配的状态
 * 1 p与s当前位置字符相同 p.charAt(j)==s.charAt(i) 则dp[i][j] = dp[i-1][j-1]
 * 2 p 当前位置是. p.charAt(j)=='.' 无论s是什么字符一定匹配 dp[i][j] = dp[i-1][j-1];
 * 3 p 当前位置是* p.charAt(j)=='*' 
 *      3.1 根据*的定义 p.charAt(j-1)* == 0时(出现0次) 可以直接抹掉只需要考虑p.charAt(j-2) 则dp[i][j] = dp[i][j-2]
 *      3.2 p.charAt(j-1)* == [1..n) (出现1-n次) 
 *          此时当p.charAt(j-1)==s.charAt(i) 或者 p.charAt(j-1) == '.'说明s.charAt(i)属于p.charAt(j-1)*的一部分，可以抹掉只考虑s.charAt(i-1) 则dp[i][j] = dp[i-1][j] 
 *          这里要注意的部分是s.charAt(i)属于p.charAt(j-1)*的一部分，是否抹掉对值不影响，dp[i][j] = dp[i][j] | dp[i-1][j]
 * 4 p.charAt(j)!=s.charAt(i)     dp[i][j]=false
 * 
 * 
 * 总结以上状态转移方程有3种
 * dp[i][j] = dp[i-1][j-1]
 * dp[i][j] = dp[i-1][j] 
 * dp[i][j] = dp[i][j-2]
 * 或者false
 * 
   '' x a * b . c
'' T  F F F F F F
x  F  T F T F F F
a  F  F T T F F F
a  F  F F T F F F
b  F  F F F T F F
y  F  F F F F T F
c  F  F F F F F T
 */
