# 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
#
# 示例: 
#
# Trie trie = new Trie();
#
# trie.insert("apple");
# trie.search("apple");   // 返回 true
# trie.search("app");     // 返回 false
# trie.startsWith("app"); // 返回 true
# trie.insert("app");
# trie.search("app");     // 返回 true
#
# 说明: 
#
# 
# 你可以假设所有的输入都是由小写字母 a-z 构成的。 
# 保证所有输入均为非空字符串。 
# 
# Related Topics 设计 字典树


# leetcode submit region begin(Prohibit modification and deletion)
class Trie(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = {}
        self.end_of_word = '#'

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: None
        """
        node = self.root
        for char in word:
            node = node.setdefault(char, {})
        node[self.end_of_word] = self.end_of_word

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        node = self.root
        for char in word:
            if char not in node:
                return False
            node = node[char]
        return self.end_of_word in node

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        node = self.root
        for char in prefix:
            if char not in node:
                return False
            node = node[char]
        return True


if __name__ == '__main__':
    t = Trie()
    typ = {
        'Trie': t,
        'insert': t.insert,
        'search': t.search,
        'startsWith': t.startsWith
    }
    funcs = ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
    args = [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
    correct_res = [None, None, True, False, True, None, True]
    # res = []
    # for func, arg in zip(funcs, args):
    #     res.append(typ[func](arg[0]) if arg else None)
    res = [typ[func](arg[0]) if arg else None for func, arg in zip(funcs, args)]
    print(res == correct_res)
