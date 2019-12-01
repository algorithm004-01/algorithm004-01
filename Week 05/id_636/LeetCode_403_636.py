class Solution:
    def canCross(self, stones: List[int]) -> bool:
        if not stones:return False
        stones_set = set(stones)
        from collections import defaultdict
        stones_dict = defaultdict(set)
        stones_dict[stones[0]] = {0}
        for stone in stones:
            for key in stones_dict[stone]:
                stoneKey = stone + key
                if key + 1 > 0 and (stoneKey + 1) in stones_set:
                    stones_dict[stoneKey + 1].add(key + 1)
                if key > 0 and stoneKey in stones_set:
                    stones_dict[stoneKey].add(key)
                if key - 1 > 0 and (stoneKey - 1) in stones_set:
                    stones_dict[stoneKey - 1].add(key - 1)
        return not(not (stones_dict[stones[-1]]))
