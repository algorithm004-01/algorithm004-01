#有序数组去重
"""
给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
示例 1:
给定数组 nums = [1,1,2], 
函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 
你不需要考虑数组中超出新长度后面的元素。
"""

# 解题思路：查看他人解法后理解写出：
# 有序数组，重复项必相邻
"""
 双指针法采用前后两个指针，a b 
 a起始下标为0 ，b起始下标为1
 1. 比较 a b 两数是否相等 
    如相等，a 不动， b向后移动一位
    如不相等，a 先不动， 复制 b位置的元素到 a+1 的位置， a 后移一位 ，b后移一位
 2. 重复上述过程，直到b 等于数组的长度
 3. 返回 a+1 即为新数组的长度
 这样不用剔除数组中的元素，时间复杂度应该是 O(n)?
"""
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        a,b=0,1
        while b<len(nums):       
            if nums[a]==nums[b]:
                b=b+1
            else:
                nums[a+1]=nums[b]
                a,b=a+1,b+1
        return a+1

#外网上看到的别人的解法,类似
#class Solution:
    def removeDuplicates_2(self, nums: List[int]) -> int:
    """
    1. 定义 len_ 
    2. 如果数组长度为 0 则 0
        用i 作下标遍历数组，遇到n[i]不等于相邻元素时，将值赋给 len_
        最后返回 len_ 值
    3. 时间复杂度 O(n) 一样是需要遍历完整个数组

    """
        len_ = 1
        if len(nums)==0:
            return 0
        for i in range(1,len(nums)):
            if nums[i] != nums[i-1]:
                nums[len_] = nums[i]
                len_ += 1
        return len_

#优化项：
#假设极端情况，数组中没有重复元素，则每次判断a!=b 都会将数值复制一遍
# 可以对复制值前先作一个判断 b-a>1 即 中间存在重复值时，才进行复制：

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        a,b=0,1
        while b<len(nums):       
            if nums[a]==nums[b]:
                b=b+1
            else:
                 if b - a > 1:
                    nums[a+1]=nums[b]
                a,b=a+1,b+1 #这里好像执行有问题
        return a+1
