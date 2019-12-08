#给出一个区间的集合，请合并所有重叠的区间。 
#
# 示例 1: 
#
# 输入: [[1,3],[2,6],[8,10],[15,18]]
#输出: [[1,6],[8,10],[15,18]]
#解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
# 
#
# 示例 2: 
#
# 输入: [[1,4],[4,5]]
#输出: [[1,5]]
#解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。 
# Related Topics 排序 数组



#leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: List[List[int]]
        """
        '''
        sort array by left side of interval
        if left of next interval < right of curr interval
        then track max of right and move to curr to next
        else create updated interval
        '''
        intervals = sorted(intervals)
        res = []
        n = len(intervals)
        i = 0
        while i < n:
            left = intervals[i][0]
            right = intervals[i][1]
            while i<n-1 and intervals[i+1][0] <= right:
                right = max(right, intervals[i + 1][1])
                i += 1
            res.append([left, right])
            i += 1
        return res
#leetcode submit region end(Prohibit modification and deletion)
