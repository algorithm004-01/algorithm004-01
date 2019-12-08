class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        s_set = set(s)
        if s_set != set(t):
            return False
        for char in s_set:
            if s.count(char) != t.count(char):
                return False
        return True