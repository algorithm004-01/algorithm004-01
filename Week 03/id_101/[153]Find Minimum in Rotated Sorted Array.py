#Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand. 
#
# (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]). 
#
# Find the minimum element. 
#
# You may assume no duplicate exists in the array. 
#
# Example 1: 
#
# 
#Input: [3,4,5,1,2] 
#Output: 1
# 
#
# Example 2: 
#
# 
#Input: [4,5,6,7,0,1,2]
#Output: 0
# 
# Related Topics Array Binary Search



#leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        '''
        The proof that the loop will exit: after each iteration either the 'end' decreases
        or the 'start' increases, so the interval [start, end] will always shrink.
        '''
        start, end = 0, len(nums) - 1
        while start < end:
            mid = start + (end - start) // 2
            if nums[mid] < nums[end]:
                # minimum in left part
                end = mid
            elif nums[mid] > nums[end]:
                # minimum in right part
                start = mid+1
        return nums[start]
        
#leetcode submit region end(Prohibit modification and deletion)
