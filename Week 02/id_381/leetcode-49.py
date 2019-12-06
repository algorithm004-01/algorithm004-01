from collections import defaultdict
class Solution:
    def groupAnagrams(self, strs: list) -> list:
        tmp_dict = defaultdict(list)
        for i, item in enumerate(strs):
            tmp = ''.join(sorted(item))
            # 与上面的相比，这里直接加上item会更好
            tmp_dict[tmp].append(item)
        return tmp_dict.values()
