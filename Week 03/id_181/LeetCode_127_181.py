# [127. 单词接龙 - 力扣（LeetCode）](https://leetcode-cn.com/problems/word-ladder/submissions/)

from collections import defaultdict
# BFS
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        """
        :type beginWord:str
        :type endWord:str
        :type wordList:List[str]
        :rtype:int
        """
        
        if endWord not in wordList or not endWord or not beginWord or not wordList:
            return 0
        
        L = len(beginWord)
        
        all_combo_dict =  defaultdict(list)
        
        for word in wordList:
            for i in range(L):
                 # 获取所有单词缺位映射
                all_combo_dict[word[:i]+"*"+word[i+1:]].append(word)
                
        queue = [(beginWord,1)]
        
        visited = {beginWord:True} # 标记已经访问过的单词
        
        while queue:
            current_word,level = queue.pop(0)
            for i in range(L):
                # 当前单词可以配对的形式 intermediate_word
                intermediate_word = current_word[:i] + "*" + current_word[i+1:]
                # 以此获取 all_combo_dict中可能的结果
                for word in all_combo_dict[intermediate_word]:
                    if word == endWord:
                        return level + 1
                    
                    if word not in visited:                    
                        visited[word] = True
                        # 继续寻找下一个的单词
                        queue.append((word,level + 1))
                        
                all_combo_dict[intermediate_word] = []
                
        return 0
        
        