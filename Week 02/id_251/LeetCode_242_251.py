# 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
#
# 示例 1: 
#
# 输入: s = "anagram", t = "nagaram"
# 输出: true
# 
#
# 示例 2: 
#
# 输入: s = "rat", t = "car"
# 输出: false
#
# 说明: 
# 你可以假设字符串只包含小写字母。
#
# 进阶: 
# 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
# Related Topics 排序 哈希表

"""
1 排序， ==
2 hash_map
    ! hash_map 2 个字典
    !! ord ascii码 自己构造字典
    !!!  一个字典
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """

    # 1 排序法
    def isAnagram1(self, s, t):
        return sorted(s) == sorted(t)

    # 2 hash_map 2 个字典
    def isAnagram2_1(self, s, t):
        dic1, dic2 = {}, {}
        for c in s:
            dic1[c] = dic1.get(c, 0) + 1
        for c in t:
            dic2[c] = dic2.get(c, 0) + 1
        return dic1 == dic2

    # 2 hash_map ord ascii码 自己构造字典
    def isAnagram2_2(self, s, t):
        dic1, dic2 = [0] * 26, [0] * 26
        for c in s:
            dic1[ord(c) - ord('a')] += 1
        for c in t:
            dic2[ord(c) - ord('a')] += 1
        return dic1 == dic2

    # 2 hash_map 一个字典
    def isAnagram2_3(self, s, t):
        # 这个一定要加
        if len(s) != len(t):
            return False
        dic = [0] * 26
        for c in s:
            dic[ord(c) - ord('a')] += 1

        for c in t:
            dic[ord(c) - ord('a')] -= 1
            if dic[ord(c) - ord('a')] < 0:
                return False
        return True

    # 一个字典
    def isAnagram2_4(self, s, t):
        # 这个一定要加
        if len(s) != len(t):
            return False
        dic = {}
        for c in s:
            dic[c] = dic.get(c, 0) + 1

        for c in t:
            dic[c] = dic.get(c, 0) - 1
            if dic[c] < 0:
                return False
        return True

# leetcode submit region end(Prohibit modification and deletion)
