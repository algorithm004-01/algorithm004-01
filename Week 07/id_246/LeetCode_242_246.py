'''
valid-anagram_242

给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
'''

def isAnagram(s, t):
    result = True
    set_tmp = set(s)
    if set_tmp == set(t):
        for i in set_tmp:
            result = result and (s.count(i) == t.count(i))
    else:
        result = False
    return result