#Given two strings s and t , write a function to determine if t is an anagram of s. 
#
# Example 1: 
#
# 
#Input: s = "anagram", t = "nagaram"
#Output: true
# 
#
# Example 2: 
#
# 
#Input: s = "rat", t = "car"
#Output: false
# 
#
# Note: 
#You may assume the string contains only lowercase alphabets. 
#
# Follow up: 
#What if the inputs contain unicode characters? How would you adapt your solution to such case? 
# Related Topics Hash Table Sort



#leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    # def isAnagram(self, s, t):
    #     """
    #     :type s: str
    #     :type t: str
    #     :rtype: bool
    #     """
    #     # one line solution with builtin lib
    #     return collections.Counter(s) == collections.Counter(t)

    # use array with 26 alphabets as counter map
    def isAnagram(self, s, t):
        if len(s) != len(t):
            return False
        counter = [0] * 26
        ord_a = ord('a')
        for cs in s:
            counter[ord(cs) - ord_a] += 1
        for ct in t:
            counter[ord(ct) - ord_a] -= 1
            if counter[ord(ct) - ord_a] < 0:
                return False
        return True

        
#leetcode submit region end(Prohibit modification and deletion)
