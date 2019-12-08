"""
给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。

示例:

输入: 
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

输出: ["eat","oath"]
说明:
你可以假设所有输入都由小写字母 a-z 组成。
"""
class TrieNode():
    def __init__(self):
        self.children = collections.defaultdict(TrieNode)
        self.isWord = False
class Trie():
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        node = self.root
        for w in word:
            node = node.children[w]
        node.isWord = True

class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        res = []
        trie = Trie()
        node = trie.root
        for w in words:
            trie.insert(w)
        for i in range(len(board)):
            for j in range(len(board[0])):
                self.dfs(board, node, i, j, "", res)
        return res
    
    def dfs(self,board, node,i,j,path,res):
        if node.isWord:
            res.append(path)
            node.isWord = False
        if i<0 or i>= len(board) or j < 0 or j >= len(board[0]):
            return
        tmp = board[i][j]
        node = node.children.get(tmp)
        if not node:
            return
        board[i][j] = '#'
        # 四个方向扩散
        self.dfs(board, node,i+1,j, path+tmp, res)
        self.dfs(board, node,i-1,j, path+tmp, res)
        self.dfs(board, node,i,j+1, path+tmp, res)
        self.dfs(board, node,i,j-1, path+tmp, res)
        board[i][j] = tmp

    def findWords(self, board, words):
        root = {}
        for word in words:
            node = root
            for c in word:
                node = node.setdefault(c, {})
            node[None] = True
        board = {i + 1j*j: c
                 for i, row in enumerate(board)
                 for j, c in enumerate(row)}

        found = []
        for z in board:
            self.search(root, z, '')
        return found

    def search(self, node, z, word):
        if node.pop(None, None):
            found.append(word)
        c = board.get(z)
        if c in node:
            board[z] = None
            for k in range(4):
                search(node[c], z + 1j**k, word + c)
            board[z] = c

if __name__ == "__main__":
    pass