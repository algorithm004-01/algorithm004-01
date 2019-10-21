class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        snowBall = 0
        index = 0
        while index < len(nums):
            if nums[index] == 0:
                snowBall += 1
            elif snowBall > 0:
                nums[index] , nums[index - snowBall] = nums[index - snowBall],nums[index]
            index += 1
  
