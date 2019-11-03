#
# @lc app=leetcode.cn id=169 lang=python3
#
# [169] 求众数
#

# @lc code=start
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        from collections import Counter
        return Counter(nums).most_common(1)[0][0]
# @lc code=end

