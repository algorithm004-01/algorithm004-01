class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """        
        l = len(nums)
        if l <= 0:
            return False
        elif l == 1:
            return nums
        else:
            k = k % l
            self.reverse(nums, 0, l - 1)
            self.reverse(nums, 0, k - 1)
            self.reverse(nums, k, l - 1)
        return nums
    def reverse(self,nums,start,end):
        while start<end:
            nums[start],nums[end]=nums[end],nums[start]
            start+=1
            end-=1
