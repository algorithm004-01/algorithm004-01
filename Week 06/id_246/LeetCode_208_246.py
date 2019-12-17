'''
implement-trie-prefix-tree_208

实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。

示例:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // 返回 true
trie.search("app");     // 返回 false
trie.startsWith("app"); // 返回 true
trie.insert("app");
trie.search("app");     // 返回 true
说明:

你可以假设所有的输入都是由小写字母 a-z 构成的。
保证所有输入均为非空字符串。
'''

#1
class Trie(object):
    def __init__(self):
        self.root = {}

    def insert(self, word):
        node = self.root
        for char in word:
            if char in node.keys():
                node = node[char]
            else:
                node[char] = {}
                node = node[char]
        node['is_word'] = True

    def search(self, word):
        node = self.root
        for char in word:
            if char in node.keys():
                node = node[char]
            else:
                return False
        if 'is_word' in node.keys():
            return True
        else:
            return False

    def startsWith(self, prefix):
        node = self.root
        for char in prefix:
            if char in node.keys():
                node = node[char]
            else:
                return False
        return True

 #2
from functools import reduce
import collections

class Trie(object):
    def __init__(self):
        T = lambda: collections.defaultdict(T)
        self.root = T()

    def insert(self, word):
        reduce(dict.__getitem__, word, self.root)['#'] = True

    def search(self, word):
        return '#' in reduce(lambda cur, c: cur.get(c, {}), word, self.root)

    def startsWith(self, prefix):
        return bool(reduce(lambda cur, c: cur.get(c, {}), prefix, self.root))