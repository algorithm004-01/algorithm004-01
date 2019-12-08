'''
merge sorted array_88

给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

示例:
输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6
'''

#合并后排序, 时间复杂度较高
num1 = [1,2,3]
num2 = [5,5]

def merge_1(num1, m, num2, n):
    num1[:] = sorted(num1[:m] + num2)
    return num1


#双指针，从前往后

def merge_2(num1, m, num2, n):
    num1_copy = num1[:m]
    num1[:] = []
    p1 = 0
    p2 = 0
    while p1 < m and p2 < n:
        if num1_copy[p1] < num2[p2]:
            num1.append(num1_copy[p1])
            p1 += 1
        else:
            num1.append(num2[p2])
            p2 += 1

    if p1 < m:
        num1[p1+p2:] = num1_copy[p1:]
    if p2 < n:
        num1[p1+p2:] = num2[p2:]
    return num1


#双指针，从后往前

def merge_3(num1, m, num2, n):
    p1 = m-1
    p2 = n-1
    p = m + n -1
    while p1 >= 0 and p2 >= 0:
        if num1[p1] < num2[p2]:
            num1[p] = num2[p2]
            p2 -= 1
        else:
            num1[p] = num1[p1]
            p1 -= 1
        p -= 1
    num1[:p2+1] = num2[:p2+1]
    return num1