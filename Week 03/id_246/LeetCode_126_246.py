'''
word-ladder_126

给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：

每次转换只能改变一个字母。
转换过程中的中间单词必须是字典中的单词。
说明:

如果不存在这样的转换序列，返回一个空列表。
所有单词具有相同的长度。
所有单词只由小写字母组成。
字典中不存在重复的单词。
你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
示例 1:

输入:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

输出:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
'''

#bfs + dfs
from collections import defaultdict

def findLadders_1(beginWord, endWord, wordList):
    neighbors = defaultdict(list)
    for w in wordList:
        for i in range(len(w)):
            placeholder = w[:i] + '_' + w[i+1:]
            neighbors[placeholder] += w

    #bfs
    tree = defaultdict(set)
    cur_layer = {beginWord}

    while cur_layer and not endWord in cur_layer:
        next_layer = defaultdict(set)
        for word in cur_layer:
            for i in range(len(word)):
                placeholder = word[:i] + '_' + word[i+1:]
                for neigh in neighbors[placeholder]:
                    if not neigh in tree:
                        next_layer[neigh].add(word)
        tree.update(next_layer)
        cur_layer = next_layer

    #dfs
    def dfs(source, dest):
        if source == dest:
            return [[source]]
        return [pre_path + [dest] for parent in tree[dest] for pre_path in dfs(source, parent)]

    return dfs(beginWord,endWord)


    # 优化
from collections import defaultdict

def findLadders_2(beginWord, endWord, wordList):
    if endWord not in wordList: return []
    forword, backword, wordList, dic = {beginWord}, {endWord}, set(wordList), defaultdict(set)
    flag, letters, length = True, set('qwertyuioplkjhgfdsazxcvbnm'), len(endWord)
    while forword:
        if len(forword) > len(backword):
            forword, backword, flag = backword, forword, not flag
        cur = set()
        wordList -= forword
        for word in forword:
            for idx in range(length):
                x,y = word[:idx], word[idx+1:]
                for letter in letters:
                    temp = x + letter + y
                    if temp in wordList:
                        cur.add(temp)
                        if flag: dic[temp].add(word)
                        else: dic[word].add(temp)
        if cur&backword:
            res = [[endWord]]
            while res[0][0] != beginWord:
                res = [[x]+y for y in res for x in dic[y[0]]]
            return res
        forword = cur
    return []