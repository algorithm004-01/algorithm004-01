"""
两字符串各个字符数量相减为0
"""

class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # 长度不等，直接返回False
        if len(s) != len(t):
            return False
        counter = {}
        for i in s:
            if i not in counter:
                counter[i] = 1
            else:
                counter[i] += 1
        for j in t:
            if j not in counter:
                return False
            counter[j] -= 1
        # 查看最后的结果是否为0
        for key, value in counter.items():
            if value != 0:
                return False
        return True
