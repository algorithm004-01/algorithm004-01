'''
edit-distance_72

给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。

你可以对一个单词进行如下三种操作：
插入一个字符
删除一个字符
替换一个字符

示例:
输入: word1 = "horse", word2 = "ros"
输出: 3

解释:
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')
'''

#dp
def minDistance(word1, word2):
    n, m = len(word1), len(word2)
    if n*m == 0:
        return n+m

    d = [[0] * (m+1) for _ in range(n+1)]

    for i in range(n+1):
        d[i][0] = i
    for j in range(m+1):
        d[0][j] = j

    for i in range(1, n+1):
        for j in range(1, m+1):
            left = d[i-1][j] + 1
            down = d[i][j-1] + 1
            left_down = d[i-1][j-1]
            if word1[i-1] != word2[j-1]:
                left_down += 1
            d[i][j] = min(left, down, left_down)
    return d[n][m]