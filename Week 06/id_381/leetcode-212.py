class Trie(object):
    def __init__(self):
        self.root = {}
        self.end_word = '#'

    def insert(self, word):
        node = self.root
        for w in word:
            node = node.setdefault(w, {})
        node[self.end_word] = self.end_word


class Solution:
    def dfs(self, node, i, j, path):
        if '#' in node and node['#']=='#':
            self.result.append(path)
            node['#'] = '##'
        if i > len(self.board)-1 or i < 0 or j > len(self.board[0])-1 or j < 0:
            return
        char = self.board[i][j]
        if char not in node:
            return
        self.board[i][j] = '*'
        for ii, jj in [(i+1, j), (i-1, j), (i, j-1), (i, j+1)]:
            self.dfs(node[char], ii, jj, path+char)
        self.board[i][j] = char

    def findWords(self, board, words) -> list:
        self.board = board
        self.result = []
        trie = Trie()
        for word in words:
            trie.insert(word)
        for i, tmp_i in enumerate(board):
            for j, tmp_j in enumerate(tmp_i):
                self.dfs(trie.root, i, j, '')
        return self.result
