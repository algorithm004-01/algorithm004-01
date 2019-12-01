#!/usr/bin/env python3.7
class Solution:
    def merge(self, nums1, m, nums2, n):
        nums1[m:] = nums2[:n]
        nums1.sort()


t1 = [1, 2, 3, 4, 5, 0, 0, 0]
m = 5
t2 = [3, 4, 5]
n = 3
Solution().merge(t1, m, t2, n)
print(t1)
