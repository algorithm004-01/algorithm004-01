#Given an array of strings, group anagrams together. 
#
# Example: 
#
# 
#Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
#Output:
#[
#  ["ate","eat","tea"],
#  ["nat","tan"],
#  ["bat"]
#] 
#
# Note: 
#
# 
# All inputs will be in lowercase. 
# The order of your output does not matter. 
# 
# Related Topics Hash Table String



#leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        ans = collections.defaultdict(list)
        ord_a = ord('a')
        for s in strs:
            counter = [0] * 26
            # consist tuple with counter array as key of map
            for c in s:
                counter[ord(c) - ord_a] += 1
            ans[tuple(counter)].append(s)
        return ans.values()
        
#leetcode submit region end(Prohibit modification and deletion)
