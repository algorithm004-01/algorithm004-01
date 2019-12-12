'''
search-in-rotated-sorted-array_33

假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别。

示例 1:
输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4

示例 2:
输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1
'''

#二分
def search(nums, target):
    left, right = 0, len(nums)-1
    mid = (left+right) //2

    while left <= right:
        if nums[mid] == target:
            return mid
        judge1 = nums[left] < nums[mid] and target < nums[mid] and target >= nums[left]
        #半边有序
        judge2 = nums[left] > nums[mid] and (target < nums[mid] or target >= nums[left])
        #半边旋转
        if judge1 or judge2:   #半边有序
            right = mid - 1
            mid = (left + right)//2
        else:
            left = mid + 1
            mid = (left + right)//2
    return -1