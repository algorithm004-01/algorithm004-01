
from collections import deque

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if endWord not in wordList: return 0
        wordList = set(wordList)

        res, forward, backword = 2, {beginWord}, {endWord}
        while forward:
            if len(forward) > len(backword):
                forward, backword = backword, forward

            next_forward = set()
            for word in forward:
                for i in range(len(word)):
                    for k in range(26):
                        tmp = word[:i] + chr(ord("a") + k) + word[i + 1:]
                        if tmp in backword:
                            return res
                        if tmp in wordList:
                            next_forward.add(tmp)
                            wordList.remove(tmp)
            res += 1
            forward = next_forward
        return 0