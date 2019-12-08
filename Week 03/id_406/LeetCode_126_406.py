class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        wordset = set(wordList)
        wordset.discard(beginWord)
        if endWord not in wordset:
            return []
        k = 1
        bfs = {beginWord}
        d = {}
        d[beginWord]=[[beginWord]]
        while len(bfs)>0:
            if endWord in bfs:
                break
            bfs1 = set()
            next1 = wordset.copy()
            for word in bfs:
                for i in range(len(word)):
                    for c in "abcdefghijklmnopqrstuvwxyz":
                        newWord = word[:i] + c + word[i + 1:]
                        if newWord in wordset and newWord != word:
                            if newWord not in d:
                                d[newWord] = []
                                for obj in d[word]:
                                    d[newWord].append(obj+[newWord])
                            else:
                                for obj in d[word]:
                                    d[newWord].append(obj+[newWord])
                            if k==1:
                                wordset.remove(newWord)
                            next1.discard(newWord)
                            bfs1.add(newWord)
            bfs = bfs1
            wordset = next1
            k += 1
        return d.get(endWord, [])