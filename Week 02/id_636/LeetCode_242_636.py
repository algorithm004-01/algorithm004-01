

class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # 1：暴力方法，字符串排序
        # 2：暴力办法，Hash 表，统计每个字符出现的频次
        # 3：长度为256的数组计数
        ## judge length
        if len(s) != len(t):
            return False

        sList = list(s)
        tList = list(t)

        sList.sort()
        tList.sort()

        return sList == tList

    def isAngramMap(self, s: str, t: str) -> bool:
        ## judge length
        if len(s) != len(t):
            return False

        sDict = dict()
        tDict = dict()

        for index in range(0, len(s)):
            tempDat_s = sDict.get(s[index])
            tempDat_t = tDict.get(t[index])

            if tempDat_s is None:
                tempDat_s = 0

            if tempDat_t is None:
                tempDat_t = 0

            sDict.update({
                s[index]: tempDat_s + 1
            })

            tDict.update({
                t[index]: tempDat_t + 1
            })

            print(sDict, tDict)

        return sDict == tDict

    def isAngramMapUpdate(self, s: str, t: str) -> bool:

        # check length
        if len(s) != len(t):
            return False
        # new dict
        sDict = dict()
        tDict = dict()

        for index in range(len(s)):
            sDict.update({
                s[index]: sDict.setdefault(s[index], 0) + 1
            })

            tDict.update({
                t[index]: tDict.setdefault(t[index], 0) + 1
            })

        return sDict == tDict

    def isAngramMapDefault(self, s: str, t: str)  -> bool:
        # check length
        if len(s) != len(t):
            return False

        from collections import defaultdict

        # new dict
        sDict = defaultdict(lambda: 0)
        tDict = defaultdict(lambda: 0)

        for index in range(len(s)):
            sDict[s[index]] += 1
            tDict[t[index]] += 1

            print(sDict, tDict)

        return sDict == tDict

    def isAngramCollections(self, s: str, t: str) -> bool:
        import collections
        return collections.Counter(s) == collections.Counter(t)

if __name__ == '__main__':
    s = Solution()

    str1 = "a"
    str2 = "b"

    print(s.isAngramMapDefault(str1, str2))
