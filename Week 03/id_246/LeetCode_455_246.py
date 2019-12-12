'''
assign-cookies_455

假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。

注意：

你可以假设胃口值为正。
一个小朋友最多只能拥有一块饼干。

示例 1:
输入: [1,2,3], [1,1]
输出: 1

示例 2:
输入: [1,2], [1,2,3]
输出: 2

'''

def findContentChildren(g,s):  #g：胃口， s: 饼干
    res = 0
    g.sort()
    s.sort()
    g_length = len(g)
    s_length = len(s)
    i = 0
    j = 0
    while i< g_length and j < s_length:
        if g[i] <= s[j]:
            res += 1
            i += 1
            j += 1
        else:
            j += 1
    return res