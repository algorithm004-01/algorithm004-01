def revert(array):
    left, right = 0, len(array) - 1
    while left < right:
        mid = left + (right - left) // 2
        if array[left] < array[mid]:
            left = mid
        else:
            right = mid

    return right


if __name__ == '__main__':
    print(revert([4, 5, 6, 1, 2, 3]))
    print(revert([4, 5, 6, 0, 1, 2, 3]))
    print(revert([4, 5, 6, 7, 0, 1, 2]))
    print(revert([4, 5, 6, 7, -3, -2, 0, 1, 2]))
    print(revert([]))
    print(revert([1]))
