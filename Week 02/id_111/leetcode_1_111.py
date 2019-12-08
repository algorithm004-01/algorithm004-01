# 两数之和
"""
给定一个整数数组 nums 和一个目标值 target，
请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
示例:
给定 nums = [2, 7, 11, 15], target = 9
因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
"""
#暴力解法 遍历每个元素 i 查看是否存在元素 j = target - i
#这样时间复杂度就是O(n^2)
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i in range(0,len(nums)):
            for j in range(i+1,len(nums)):
                if nums[i] == target - nums[j]:
                    return i,j
#哈希表法：
#字典模拟哈希

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        _dict = {}#定义空字典
        for i, m in enumerate(nums):
            _dict[m] = i#i值赋给下标

        for i, m in enumerate(nums):
            j = _dict.get(target - m) #在哈希表中匹配出目标值
            if j is not None and i != j:
                return [i, j]#如果目标值不等于初始值自身 则返回
                #return [_dict.get(target - m), i]
            
时间复杂度：O(n)O(n)，
我们把包含有 nn 个元素的列表遍历两次。由于哈希表将查找时间缩短到 O(1)O(1) ，所以时间复杂度为 O(n)O(n)。

空间复杂度：O(n)O(n)，
所需的额外空间取决于哈希表中存储的元素数量，该表中存储了 nn 个元素。
