#Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that: 
#
# 
# Only one letter can be changed at a time 
# Each transformed word must exist in the word list. Note that beginWord is not a transformed word. 
# 
#
# Note: 
#
# 
# Return an empty list if there is no such transformation sequence. 
# All words have the same length. 
# All words contain only lowercase alphabetic characters. 
# You may assume no duplicates in the word list. 
# You may assume beginWord and endWord are non-empty and are not the same. 
# 
#
# Example 1: 
#
# 
#Input:
#beginWord = "hit",
#endWord = "cog",
#wordList = ["hot","dot","dog","lot","log","cog"]
#
#Output:
#[
#  ["hit","hot","dot","dog","cog"],
#  ["hit","hot","lot","log","cog"]
#]
# 
#
# Example 2: 
#
# 
#Input:
#beginWord = "hit"
#endWord = "cog"
#wordList = ["hot","dot","dog","lot","log"]
#
#Output: []
#
#Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
# 
#
# 
# 
# Related Topics Array String Backtracking Breadth-first Search



#leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    '''
    maintain a dict which has:
    key -> word can be transformed from words in value
    value -> set of curr words which can transform to

    example: 'cog' : set('dog', 'log')
    both 'dog' and 'log' can be transformed to 'cog'
    '''

    def findLadders(self, beginWord, endWord, dic):
        words = set(dic)
        if endWord not in words:
            return []
        parents = collections.defaultdict(set)
        forward, backward = {beginWord}, {endWord}
        direction = 1
        while forward and backward:
            if len(forward) > len(backward):
                forward, backward = backward, forward
                direction *= -1

            next_forward = set()
            words -= forward
            for word in forward:
                self._build_next(next_forward, word, words, parents, direction)
            forward = next_forward
            if next_forward & backward:
                res = []
                path = [endWord]
                res = self.dfs(res, path, endWord, beginWord, parents)
                return res
        return []

    def dfs(self, res, path, curr_word, dest_word, parents):
        if curr_word == dest_word:
            res.append(path[::-1])
            return res
        for word in parents[curr_word]:
            path.append(word)
            self.dfs(res, path, word, dest_word, parents)
            path.pop()
        return res

    def _build_next(self, next_forward, word, words, parents, direction):
        for i in range(len(word)):
            left, right = word[:i], word[i + 1:]
            for c in string.ascii_lowercase:
                new_word = left + c + right
                if new_word not in words:
                    continue
                next_forward.add(new_word)
                if direction == 1:
                    parents[new_word].add(word)
                else:
                    parents[word].add(new_word)

    def findLaddersII(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: List[List[str]]
        """
        dic = set(wordList)
        if endWord not in dic:
            return []
        fathers_dict = collections.defaultdict(set)
        curr_from = {beginWord}  # or {beginWord}
        while curr_from and endWord not in fathers_dict:
            derive_from = collections.defaultdict(set)
            for word in curr_from:
                self._build_children(derive_from, word, dic, fathers_dict)
            curr_from = derive_from  # move to next level
            fathers_dict.update(derive_from)
        res = [[endWord]]
        # build result from end to begin, backward
        while res and res[0][0] != beginWord:
            res = [[p] + row for row in res for p in fathers_dict[row[0]]]
        return res

    def _build_children(self, derive_from, word, word_dict, fathers_dict):
        for i in range(len(word)):
            for c in string.ascii_lowercase:
                derive = word[:i] + c + word[i+1:]
                if derive in word_dict and derive not in fathers_dict:
                    derive_from[derive].add(word)

#leetcode submit region end(Prohibit modification and deletion)
