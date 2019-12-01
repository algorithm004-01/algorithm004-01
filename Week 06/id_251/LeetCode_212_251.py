# 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
#
# 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。 
#
# 示例: 
#
# 输入: 
# words = ["oath","pea","eat","rain"] and board =
# [
#  ['o','a','a','n'],
#  ['e','t','a','e'],
#  ['i','h','k','r'],
#  ['i','f','l','v']
# ]
#
# 输出: ["eat","oath"]
#
# 说明: 
# 你可以假设所有输入都由小写字母 a-z 组成。
#
# 提示: 
#
# 
# 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？ 
# 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。 
# 
# Related Topics 字典树 回溯算法

"""
1. words 遍历 --> board search
    O(N*m*n*4^k)
2. trie
a. all words --> Trie 构建起 prefix
b board, DFS
O(N*k + m*n*4^k) = O(m*n*4^k)
"""

# leetcode submit region begin(Prohibit modification and deletion)

from collections import defaultdict

# 四联通构建
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]
END_FO_WORD = "#"


class Solution(object):
    def findWords(self, board, words):
        """
        :type board: List[List[str]]
        :type words: List[str]
        :rtype: List[str]
        """
        if not board or not board[0]: return []
        if not words: return []
        self.result = set()

        # 构建trie
        root = defaultdict()
        for word in words:
            node = root
            for char in word:
                node = node.setdefault(char, defaultdict())
            node[END_FO_WORD] = END_FO_WORD

        self.m, self.n = len(board), len(board[0])
        for i in range(self.m):
            for j in range(self.n):
                if board[i][j] in root:
                    self._dfs(board, i, j, '', root)
        return list(self.result)

    def _dfs(self, board, i, j, cur_word, cur_dict):
        cur_word += board[i][j]
        cur_dict = cur_dict[board[i][j]]
        if END_FO_WORD in cur_dict:
            self.result.add(cur_word)
        tmp, board[i][j] = board[i][j], '@'
        for k in range(4):
            x, y = i + dx[k], j + dy[k]
            if 0 <= x < self.m and 0 <= y < self.n \
                    and board[x][y] != '@' and board[x][y] in cur_dict:
                self._dfs(board, x, y, cur_word, cur_dict)
        board[i][j] = tmp


# trie 优秀题解
class Solution2(object):
    def findWords(self, board, words):
        """
        :type board: List[List[str]]
        :type words: List[str]
        :rtype: List[str]
        """
        trie = {}
        for word in words:
            node = trie
            for char in word:
                node = node.setdefault(char, {})
            node['#'] = True

        def bfs(i, j, node, cur_word, visited):
            if '#' in node:  # 已有字典树结束
                res.add(cur_word)
            for di, dj in ((-1, 0), (1, 0), (0, -1), (0, 1)):
                x, y = i + di, j + dj
                if -1 < x < m and -1 < y < n and board[x][y] in node and (x, y) not in visited:
                    bfs(x, y, node[board[x][y]], cur_word + board[x][y], visited | {(x, y)})

        res, m, n = set(), len(board), len(board[0])
        for i in range(m):
            for j in range(n):
                if board[i][j] in trie:
                    bfs(i, j, trie[board[i][j]], board[i][j], {(i, j)})
        return list(res)
