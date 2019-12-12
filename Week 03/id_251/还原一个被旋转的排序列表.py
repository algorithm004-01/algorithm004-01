"""
约束条件：列表中没有重复元素
"""


def revert(array):
    left, right = 0, len(array) - 1
    while left < right:
        mid = left + (right - left) // 2
        # 找到旋转后第二段的起点
        if array[mid] > array[right]:
            left = mid + 1
        else:
            right = mid
    return array[left:] + array[:left]


if __name__ == '__main__':
    print(revert([4, 5, 6, 1, 2, 3]))
    print(revert([4, 5, 6, 0, 1, 2, 3]))
    print(revert([4, 5, 6, 7, 0, 1, 2]))
    print(revert([4, 5, 6, 7, -3, -2, 0, 1, 2]))
    print(revert([]))
    print(revert([1]))
    print(revert([1, 2, 3]))
