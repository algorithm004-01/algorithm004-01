class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        dic1, dic2 = {}, {}
        for item in s:
            dic1[item] = dic1.get(item, 0) + 1
        for item in t:
            dic2[item] = dic2.get(item, 0) + 1
        #print(dic1, dic2) {'a': 3, 'n': 1, 'g': 1, 'r': 1, 'm': 1} {'n': 1, 'a': 3, 'g': 1, 'r': 1, 'm': 1}
        return dic1 == dic2

    def isAnagram2(self, s, t):
        dic1, dic2 = [0] * 26, [0] * 26
        print(dic1, dic2)
        for item in s:
            dic1[ord(item) - ord('a')] += 1
        for item in t:
            dic2[ord(item) - ord('a')] += 1
        #print(dic1, dic2) [3, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0] [3, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0]
        print(dic1, dic2)
        return dic1 == dic2

    def isAnagram3(self, s, t):
        #print(sorted(s), sorted(t))['a', 'a', 'a', 'g', 'm', 'n', 'r'] ['a', 'a', 'a', 'g', 'm', 'n', 'r']

        return sorted(s) == sorted(t)


if __name__ == '__main__':
    s = "a"
    t = "n"
    solution = Solution()
    res = solution.isAnagram2(s, t)
    print(res)
