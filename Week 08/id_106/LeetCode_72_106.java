/*
 * @lc app=leetcode id=72 lang=java
 *
 * [72] Edit Distance
 *
 * https://leetcode.com/problems/edit-distance/description/
 *
 * algorithms
 * Hard (39.75%)
 * Likes:    2664
 * Dislikes: 41
 * Total Accepted:    206.7K
 * Total Submissions: 515.1K
 * Testcase Example:  '"horse"\n"ros"'
 *
 * Given two words word1 and word2, find the minimum number of operations
 * required to convert word1 to word2.
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * 
 * Insert a character
 * Delete a character
 * Replace a character
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation: 
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation: 
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 * 
 * 
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        int s1 = word1.length();
        int s2 = word2.length();
        int[][] dp = new int[s1+1][s2+1];
        for (int i=1;i<=s1;i++){
            dp[i][0] = i;
        }
        for(int j=1;j<=s2;j++){
            dp[0][j] = j;
        }
        for (int i=1;i<=s1;i++){
            for(int j=1;j<=s2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]),dp[i][j-1])+1;
                }
            }
        }
        return dp[s1][s2];
    }
}
// @lc code=end

/**
 * 使用数学归纳法和DP
 * 要将word1[0..i) 转化为 word2[0..j) 假设这个编辑的最小步数是dp[i][j]
 * 1 当word1或者word2的长度为0时，从一个单词向其转化需要的步数就是这个单词的长度dp[i][0]=i dp[0][j]=j 
 * 2 假设已经知道word1[0..i-1)到word2[0..j-1)的最短路径 dp[i-1][j-1]
 *   此时如果word1[i-1]=word2[j-1]那么不会再有变化的操作，则dp[i][j] =  dp[i-1][j-1]
 *   此时如果word1[i-1]!=word2[j-1]那么根据三种可选操作有以下情况
 *   2.1 replace 用word2[j-1]替换word1[i-1] 使得word1[i-1]=word2[j-1] ==>dp[i][j] = dp[i-1][j-1]+1
 *   2.2 delete 如果word1[0..i-1) 和 word2[0..j)相同，那么就将word1[i-1]删掉 ==>dp[i][j] = dp[i-1][j]+1
 *   2.3 insert 如果word1[0..i-1)+word[j-1] 和 word2[0..j)相同，那么就将word1[0..i)后加上word2[j-1] ==>dp[i][j] = dp[i][j-1]+1
 *   在上述三种情况中选取最小的情况
 */
