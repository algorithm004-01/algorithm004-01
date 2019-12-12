# 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
#
# 示例: 
#
# 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
# 输出:
# [
#  ["ate","eat","tea"],
#  ["nat","tan"],
#  ["bat"]
# ]
#
# 说明： 
#
# 
# 所有输入均为小写字母。 
# 不考虑答案输出的顺序。 
# 
# Related Topics 哈希表 字符串

"""
1 排序数组分类
2 按计数分类
"""


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """

    # 1 排序数组分类 O(nklog(k))
    def groupAnagrams1(self, strs):
        import collections
        dic = collections.defaultdict(list)
        for s in strs:
            dic[tuple(sorted(s))].append(s)
        return dic.values()

    # 1 排序数组分类2 拼接列表慢 O(2nklog(k))
    def groupAnagrams1_2(self, strs):
        dic = {}
        for s in strs:
            dic[tuple(sorted(s))] = dic.get(tuple(sorted(s)), []) + [s]
        return dic.values()

    # 2 按计数 最优 O(kn)
    def groupAnagrams2(self, strs):
        import collections
        dic = collections.defaultdict(list)
        for s in strs:
            count = [0] * 26
            for c in s:
                count[ord(c) - ord('a')] += 1
            dic[tuple(count)].append(s)
        return dic.values()

    # 2 按计数 拼接列表慢 O(2kn)
    def groupAnagrams2_1(self, strs):
        dic = {}
        for s in strs:
            count = [0] * 26
            for c in s:
                count[ord(c) - ord('a')] += 1
            dic[tuple(count)] = dic.get(tuple(count), []) + [s]
        return dic.values()
# leetcode submit region end(Prohibit modification and deletion)
