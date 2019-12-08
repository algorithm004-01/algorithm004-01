'''
group anagrams_49

给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:
输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

说明：
所有输入均为小写字母。
不考虑答案输出的顺序。。
'''

#排序数组分类
strs = ["eat", "tea", "tan", "ate", "nat", "bat"]

def groupAnagrams_1(strs):
    ans = collections.defaultdict(list)
    for s in strs:
        ans[tuple(sorted(s))].append(s)
    return ans.values()


#按计数分类

def groupAnagrams_2(strs):
    ans = collections.defaultdict(list)
    for s in strs:
        count = [0] * 26
        for c in s:
            count[ord(c)-ord('a')] += 1
        ans[tuple(count)].append(s)
    return ans.values()