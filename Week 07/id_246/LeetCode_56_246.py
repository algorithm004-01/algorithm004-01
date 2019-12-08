'''
merge-intervals_56

给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
'''

#1
def merge_1(intervals):
    if (not intervals): return []
    n = len(intervals)
    intervals.sort()
    res = []
    left = intervals[0][0]
    right = intervals[0][1]

    for i in range(1, n):
        if (intervals[i][0] <= right):
            if (intervals[i][1] > right):
                right = intervals[i][1]
        else:
            res.append([left, right])
            left = intervals[i][0]
            right = intervals[i][1]
    res.append([left, right])
    return res

#2
def merge_2(intervals):
    intervals = sorted(intervals)
    res = []
    n = len(intervals)
    i = 0
    while (i<n):
        left = intervals[i][0]
        right = intervals[i][1]
        while (i<n-1 and intervals[i+1][0] <= right):
            i += 1
            right = max(intervals[i][1], right)
        res.append([left, right])
    return res