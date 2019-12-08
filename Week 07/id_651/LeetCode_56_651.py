"""
给出一个区间的集合，请合并所有重叠的区间。

示例 1:
输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

示例 2:
输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
"""

class Solution:
	def merge(self, intervals):
		intervals = sorted(intervals)
		result = []
		length = len(intervals)
		i = 0
		while i<length:
			left = intervals[i][0]
			right = intervals[i][-1]
			while i < length-1 and intervals[i+1][0] <= right:
				i += 1
				right = max(intervals[i][-1], right)
			result.append([left, right])
			i += 1
		return result
