class Solution(object):
    def findLadders(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: List[List[str]]
        """

        def backtrack(res, routine, path, endWord):
            if len(routine[endWord]) == 0:
                res.append([endWord] + path)
            else:
                for pre in routine[endWord]:
                    backtrack(res, routine, [endWord] + path, pre)

        lookup = set(wordList) | set([beginWord])
        res, cur, routine = [], set([beginWord]), {word: [] for word in lookup}
        while cur and endWord not in cur:
            next_queue = set()
            for word in cur:
                lookup.remove(word)
            for word in cur:
                for i in range(len(word)):
                    for j in range(97, 123):
                        tmp = word[:i] + chr(j) + word[i + 1:]
                        if tmp in lookup:
                            next_queue.add(tmp)
                            routine[tmp].append(word)
            cur = next_queue

        if cur:
            backtrack(res, routine, [], endWord)
        return res


