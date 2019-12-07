/*
 * @lc app=leetcode id=1143 lang=java
 *
 * [1143] Longest Common Subsequence
 *
 * https://leetcode.com/problems/longest-common-subsequence/description/
 *
 * algorithms
 * Medium (57.21%)
 * Likes:    335
 * Dislikes: 8
 * Total Accepted:    19.8K
 * Total Submissions: 34.6K
 * Testcase Example:  '"abcde"\n"ace"'
 *
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence.
 * 
 * A subsequence of a string is a new string generated from the original string
 * with some characters(can be none) deleted without changing the relative
 * order of the remaining characters. (eg, "ace" is a subsequence of "abcde"
 * while "aec" is not). A common subsequence of two strings is a subsequence
 * that is common to both strings.
 * 
 * 
 * 
 * If there is no common subsequence, return 0.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: text1 = "abcde", text2 = "ace" 
 * Output: 3  
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: text1 = "abc", text2 = "abc"
 * Output: 3
 * Explanation: The longest common subsequence is "abc" and its length is 3.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: text1 = "abc", text2 = "def"
 * Output: 0
 * Explanation: There is no such common subsequence, so the result is 0.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * The input strings consist of lowercase English characters only.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i = 0;i < text1.length(); i++){
            for(int j = 0; j< text2.length(); j++){
                // System.out.println("i: "+i+", j: "+j);
                if(text1.charAt(i) == text2.charAt(j)) dp[i+1][j+1] = dp[i][j] + 1;
                else dp[i+1][j+1] = Math.max(dp[i+1][j],dp[i][j+1]);
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
// @lc code=end
/*  
  M K O I R
M 0 
O   1 2
R     2 2    
E       2 2

a[i][j]
if char equals
f[i+1][j+1] = f[i][j] + 1;
else
f[i+1][j+1] = Math.Max(f[i+1][j],f[i][j+1])
 */
