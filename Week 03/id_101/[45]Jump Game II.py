#Given an array of non-negative integers, you are initially positioned at the first index of the array. 
#
# Each element in the array represents your maximum jump length at that position. 
#
# Your goal is to reach the last index in the minimum number of jumps. 
#
# Example: 
#
# 
#Input: [2,3,1,1,4]
#Output: 2
#Explanation: The minimum number of jumps to reach the last index is 2.
#    Jump 1 step from index 0 to 1, then 3 steps to the last index. 
#
# Note: 
#
# You can assume that you can always reach the last index. 
# Related Topics Array Greedy



#leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def jump(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """

        # so far jump max len
        # track curr jump max len from each pos
        # record previous jump max len
        # only update step when curr pos == prev jump max len
        # should not consider last item in array
        step, jump_max, prev_jump_max = 0, 0, 0
        for i in range(len(nums)-1):
            jump_max = max(jump_max, nums[i] + i)
            if i == prev_jump_max:
                prev_jump_max = jump_max
                step += 1
        return step

#leetcode submit region end(Prohibit modification and deletion)
