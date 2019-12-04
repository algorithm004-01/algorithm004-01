class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        result = True
        set_tmp = set(s)
        if set_tmp == set(t):
            for i in set_tmp:
                result = result and (s.count(i) == t.count(i))
        else:
            result = False
        return (result)
