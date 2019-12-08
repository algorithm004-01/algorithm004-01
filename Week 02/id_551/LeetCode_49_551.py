class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        # 以 26 字符计数 tuple 作为 key 构建 map
        # {(0, 1, 2, 1, 0, 0 ... , 1), ["abc", "bca"],}
        #  (0, 1, 0, 1, 0, 0 ... , 1), ["xcsr", "cxsr"],}
        
        # res { tuple: list}
        res = collections.defaultdict(list)
        
        for s in strs:
            # 计数器
            counter = [0] * 26
            for c in s:
                counter[ord(c) - ord('a')] += 1
            res[tuple(counter)].append(s)
        
        return res.values()
