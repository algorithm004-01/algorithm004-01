#!/usr/bin/env python3.7


class Solution:
    def groupAnagrams(self, strs):
        dct = {}
        for s in strs:
            key = "".join(sorted(s))
            if key in dct:
                dct[key].append(s)
            else:
                dct[key] = [s]
        return [dct[x] for x in dct]


test = ["eat", "tea", "tan", "ate", "nat", "bat"]

print(Solution().groupAnagrams(test))
