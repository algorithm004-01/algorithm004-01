'''
vaild anagram_242

给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。

进阶:
如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
'''

#内置
import collections

def isAnagram_1(s, t):
    return collections.Counter(s) == collections.Counter(t)


#hash
def isAnagram_2(s, t):
    dic = {}
    for i in s:
        if i not in dic:
            dic[i] = 1
        else:
            dic[i] += 1

    for j in t:
        if j not in dic:
            return False
        else:
            dic[j] -= 1

    for val in dic.values():
        if val != 0:
            return False
    return True