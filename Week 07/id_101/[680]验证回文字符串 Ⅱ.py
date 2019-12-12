#给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
#
# 示例 1: 
#
# 
#输入: "aba"
#输出: True
# 
#
# 示例 2: 
#
# 
#输入: "abca"
#输出: True
#解释: 你可以删除c字符。
# 
#
# 注意: 
#
# 
# 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。 
# 
# Related Topics 字符串



#leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def validPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        # two pointer, whenever mismatch, exclude char at left or right pointer, and keep comparing remaining substrings
        l, r = 0, len(s)-1
        while l < r:
            if s[l] != s[r]:
                one, two = s[l:r], s[l+1:r+1]
                return one==one[::-1] or two==two[::-1]
            l, r = l+1, r-1
        return True

        
#leetcode submit region end(Prohibit modification and deletion)
