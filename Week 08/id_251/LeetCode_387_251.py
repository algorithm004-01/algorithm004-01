# 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
#
# 案例: 
#
# 
# s = "leetcode"
# 返回 0.
#
# s = "loveleetcode",
# 返回 2.
# 
#
# 
#
# 注意事项：您可以假定该字符串只包含小写字母。 
# Related Topics 哈希表 字符串

"""
1 字典
2 字母表
"""
import collections


class Solution(object):
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """
        dic = collections.Counter(s)

        for i, c in enumerate(s):
            if dic[c] == 1:
                return i
        return -1


class Solution2:
    def firstUniqChar(self, s):
        letters = 'abcdefghijklmnopqrstuvwxyz'
        index = [s.index(l) for l in letters if s.count(l) == 1]
        return min(index) if len(index) > 0 else -1
