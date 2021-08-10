'''
isomorphic-strings_205

给定两个字符串 s 和 t，判断它们是否是同构的。

如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。

所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。

示例 1:

输入: s = "egg", t = "add"
输出: true
'''

def isIsomorphic_1(s, t):
    return [*map(s.index, s)] == [*map(t.index, t)]

def isIsomorphic_2(s, t):
    d1, d2 = {}, {}
    for i, val in enumerate(s):
        d1[val] = d1.get(val, []) + [i]
    for i, val in enumerate(t):
        d2[val] = d2.get(val, []) + [i]
    return sorted(d1.values()) == sorted(d2.values())

def isIsomorphic_3(s, t):
    return len(set(zip(s, t))) == len(set(s)) == len(set(t))

def isIsomorphic_4(s, t):
    return [s.find(i) for i in s] == [t.find(j) for j in t]

def isIsomorphic_5( s, t):
    return map(s.find, s) == map(t.find, t)