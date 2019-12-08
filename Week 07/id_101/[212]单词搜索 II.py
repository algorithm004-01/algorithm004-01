#给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。 
#
# 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。 
#
# 示例: 
#
# 输入: 
#words = ["oath","pea","eat","rain"] and board =
#[
#  ['o','a','a','n'],
#  ['e','t','a','e'],
#  ['i','h','k','r'],
#  ['i','f','l','v']
#]
#
#输出: ["eat","oath"] 
#
# 说明: 
#你可以假设所有输入都由小写字母 a-z 组成。 
#
# 提示: 
#
# 
# 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？ 
# 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。 
# 
# Related Topics 字典树 回溯算法



#leetcode submit region begin(Prohibit modification and deletion)
class TrieNode(object):
    def __init__(self):
        self.isWord = False
        self.children = collections.defaultdict(TrieNode)

class Trie(object):
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        node = self.root
        for c in word:
            node = node.children[c]
        node.isWord = True

    def search(self, word):
        node = self.root
        for c in word:
            node = node.children.get(c)
            if not node:
                return False
        return node.isWord


dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]


class Solution(object):
    def findWords(self, board, words):
        """
        :type board: List[List[str]]
        :type words: List[str]
        :rtype: List[str]
        """
        res = []
        trie = Trie()
        node = trie.root
        for word in words:
            trie.insert(word)
        for i in range(len(board)):
            for j in range(len(board[0])):
                self.dfs(board, node, i, j, "", res)
        return res

    def dfs(self, board, node, i, j, path, res):
        if node.isWord:
            res.append(path)
            node.isWord = False
        if 0<=i<len(board) and 0<=j<len(board[0]):
            c = board[i][j]
            node = node.children.get(c)
            if not node:
                return
            board[i][j] = "#"  # mark visited
            for k in range(4):  # four directions
                ni = i + dx[k]
                nj = j + dy[k]
                self.dfs(board, node, ni, nj, path+c, res)
            board[i][j] = c  # reset to original value

        
#leetcode submit region end(Prohibit modification and deletion)
