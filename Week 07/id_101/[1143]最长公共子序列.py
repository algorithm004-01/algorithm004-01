#给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。 
#
# 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。 
#例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。 
#
# 若这两个字符串没有公共子序列，则返回 0。 
#
# 
#
# 示例 1: 
#
# 输入：text1 = "abcde", text2 = "ace" 
#输出：3  
#解释：最长公共子序列是 "ace"，它的长度为 3。
# 
#
# 示例 2: 
#
# 输入：text1 = "abc", text2 = "abc"
#输出：3
#解释：最长公共子序列是 "abc"，它的长度为 3。
# 
#
# 示例 3: 
#
# 输入：text1 = "abc", text2 = "def"
#输出：0
#解释：两个字符串没有公共子序列，返回 0。
# 
#
# 
#
# 提示: 
#
# 
# 1 <= text1.length <= 1000 
# 1 <= text2.length <= 1000 
# 输入的字符串只含有小写英文字符。 
# 
# Related Topics 动态规划



#leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def longestCommonSubsequence(self, text1, text2):
        """
        :type text1: str
        :type text2: str
        :rtype: int
        """
        """
        if s[i] == t[j]
            dp[i+1][j+1] = dp[i][j] + 1
        else
            dp[i+1][j+1] = max(dp[i][j+1], dp[i+1][j])
        dp array size should be len(s)+1 and len(t)+1
        specifically when dealing with string
        """
        dp = [[0] * (len(text2)+1) for _ in range(len(text1)+1)]
        for i, c in enumerate(text1):
            for j, d in enumerate(text2):
                dp[i+1][j+1] = 1 + dp[i][j] if c == d else max(dp[i][j+1], dp[i+1][j])
        return dp[-1][-1]

    def longestCommonSubsequenceII(self, text1, text2):
        """
        :type text1: str
        :type text2: str
        :rty
        """
        # only needs information of previous row to update current row.
        # So we just use a two-row 2D array to save and update the matching results for chars in s1 and s2
        """
        1: use k ^ 1 and k ^= 1 to switch between dp[0] (row 0) and dp[1] (row 1).
        2: use 1 - i % 2 and i % 2 to switch between dp[0] (row 0) and dp[1] (row 1)
        Time: O(m*n), space: O(min(m, n))
        """
        m, n = len(text1), len(text2)
        # let second string length smaller
        if m < n:
            return self.longestCommonSubsequenceII(text2, text1)
        dp = [[0] * (n+1) for _ in range(2)]
        for i, c in enumerate(text1):
            for j, d in enumerate(text2):
                dp[1-i%2][j+1] = 1 + dp[i%2][j] if c == d else max(dp[i%2][j+1], dp[1-i%2][j])
        return dp[m%2][-1]

#leetcode submit region end(Prohibit modification and deletion)
