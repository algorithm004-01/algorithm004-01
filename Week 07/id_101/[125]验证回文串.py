#给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
#
# 说明：本题中，我们将空字符串定义为有效的回文串。 
#
# 示例 1: 
#
# 输入: "A man, a plan, a canal: Panama"
#输出: true
# 
#
# 示例 2: 
#
# 输入: "race a car"
#输出: false
# 
# Related Topics 双指针 字符串



#leetcode submit region begin(Prohibit modification and deletion)
import re


class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        # regex
        s = re.sub(r'[^a-zA-Z0-9]', '', s).lower()
        return s[::-1] == s

    def isParlindrome(self, s: str):
        """two pointer"""
        l, r = 0, len(s)-1
        while l < r:
            while l < r and not s[l].isalnum():
                l += 1
            while l < r and not s[r].isalnum():
                r -= 1
            if s[l].lower() != s[r].lower():
                return False
            l, r = l+1, r-1
        return True



        
#leetcode submit region end(Prohibit modification and deletion)
