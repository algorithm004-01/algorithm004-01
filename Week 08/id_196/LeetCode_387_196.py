#给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
#
# 案例: 
#
# 
#s = "leetcode"
#返回 0.
#
#s = "loveleetcode",
#返回 2.
# 
#
# 
#
# 注意事项：您可以假定该字符串只包含小写字母。 
# Related Topics 哈希表 字符串



#leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """
        count = collections.Counter(s)


        index = 0
        for ch in s:
            if count[ch] == 1:
                return index
            else:
                index += 1
        return -1



#leetcode submit region end(Prohibit modification and deletion)
