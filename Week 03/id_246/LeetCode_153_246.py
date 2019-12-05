'''
find-minimum-in-rotated-sorted-array_153

假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

请找出其中最小的元素。

你可以假设数组中不存在重复元素。

示例 1:

输入: [3,4,5,1,2]
输出: 1
'''

def findMin(nums):
    l, r = 0, len(nums)-1

    # 找旋转点
    # 1. 如果某半边数组仍为旋转数组(头元素大于尾元素)，则最小值在这半边；
    # 2. 如果两半边数组均为有序数组，则最小值为左半边数组的头元素。
    while l < r:
        m = (l+r)//2
        if nums[l] >= nums[m] >= nums[r]:  #完全逆序
            return nums[r]
        elif nums[m] > nums[r]:    # 后半边旋转，前半边有序
            l = m+1
        elif nums[l] > nums[m]:    # 前半边旋转，后半边有序
            r = m    # 没有减1是为了考虑当前元素就是旋转点的情况
        else:        # 完全有序(nums[l] < nums[mid] < nums[r])
            return nums[l]
    return nums[l]