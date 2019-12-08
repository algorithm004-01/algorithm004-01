
# 贪心算法
# 先给g和s排序，这是首要做的，这一步很重要
# 通过遍历循环s，从s中找到大于g中的元素，统计出最终找到的j的个数即可！
class Solution:
    def findContentChildren(self, g, s) -> int:
        g.sort()
        s.sort()
        j = 0
        for i in range(len(s)):
            if j >= len(g):
                break
            if s[i] >= g[j]:
                j += 1
        return j
