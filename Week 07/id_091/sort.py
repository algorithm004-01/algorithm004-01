# 1.冒泡排序
def bubbleSort(nums):
    for i in range(len(nums) - 1):
        for j in range(len(nums) - i - 1):
            if nums[j] > nums[j + 1]:
                nums[j], nums[j + 1] = nums[j + 1], nums[j]
    return nums


nums = [61, 81, 31, 2, 9, 1]

print(bubbleSort(nums))


# 2.选择排序
def selectSort(list):
    for i in range(len(list) - 1):
        for j in range(i, len(list)):
            if list[j] < list[i]:
                min = j
                list[i], list[min] = list[min], list[i]
    return list


print(selectSort([1, 3, 2]))


# 3.插入排序
def insertSort(list):
    for i in range(1, len(list)):
        j = i - 1
        key = list[i]
        while j >= 0:
            if list[j] > key:
                list[j + 1] = list[j]
                list[j] = key
            j -= 1
    return list


print(insertSort([4, 3, 2, 4]))


# 4.快排
def quickSort(list, start, r):
    if start < r:
        q = partion(list, start, r)
        quickSort(list, start, q)
        quickSort(list, q + 1, r)


def partion(list, start, r):
    i = start - 1
    for j in range(start, r):
        if list[j] <= list[r]:
            i += 1
            list[i], list[j] = list[j], list[i]
    list[i + 1], list[r] = list[r], list[i + 1]
    return i


list = [3, 2, 4, 1]
quickSort(list, 0, 3)
print(list)


# 5.希尔排序
def shellSort(slist):
    gap = len(slist)
    while gap > 1:
        gap = gap // 2
        for i in range(gap, len(slist)):
            for j in range(i % gap, i, gap):
                if slist[i] < slist[j]:
                    slist[i], slist[j] = slist[j], slist[i]
    return slist


list = shellSort([14, 5, 6, 7, 3, 2, 6, 9, 8])
print(list)

# 6.堆排序
import copy


def heapSort(hlist):
    def heapAdjust(parent):
        child = 2 * parent + 1  # left child
        while child < len(heap):
            if child + 1 < len(heap):
                if heap[child + 1] > heap[child]:
                    child += 1  # right child
            if heap[parent] >= heap[child]:
                break
            heap[parent], heap[child] = heap[child], heap[parent]
            parent, child = child, 2 * child + 1

    heap, hlist = copy.copy(hlist), []
    for i in range(len(heap) // 2, -1, -1):
        heapAdjust(i)
    while len(heap) != 0:
        heap[0], heap[-1] = heap[-1], heap[0]
        hlist.insert(0, heap.pop())
        heapAdjust(0)
    return hlist


hlist = heapSort([4, 5, 6, 7, 3, 2, 6, 9, 8])
print(hlist)


# 7.归并排序
def mergeSort(array):
    def mergeArr(arr_l, arr_r):
        array = []
        while len(arr_l) and len(arr_r):
            if arr_l[0] <= arr_r[0]:
                array.append(arr_l.pop(0))
            elif arr_l[0] > arr_r[0]:
                array.append(arr_r.pop(0))
        if len(arr_l) != 0:
            array += arr_l
        elif len(arr_r) != 0:
            array += arr_r
        return array

    def recursive(array):
        if len(array) == 1:
            return array
        mid = len(array) // 2
        arr_l = recursive(array[:mid])
        arr_r = recursive(array[mid:])
        return mergeArr(arr_l, arr_r)

    return recursive(array)


list = mergeSort([4, 5, 6, 7, 3, 2, 6, 9, 8])
print(list)


# 8.计数排序
def countingSort(a, k):  # k = max(a)
    n = len(a)  # 计算a序列的长度
    b = [0 for i in range(n)]  # 设置输出序列并初始化为0
    c = [0 for i in range(k + 1)]  # 设置计数序列并初始化为0，
    for j in a:
        c[j] = c[j] + 1
    for i in range(1, len(c)):
        c[i] = c[i] + c[i - 1]
    for j in a:
        b[c[j] - 1] = j
        c[j] = c[j] - 1
    return b


# 9.桶排序
def bucketSort(a):
    buckets = [0] * ((max(a) - min(a)) + 1)  # 初始化桶元素为0
    for i in range(len(a)):
        buckets[a[i] - min(a)] += 1  # 遍历数组a，在桶的相应位置累加值
    b = []
    for i in range(len(buckets)):
        if buckets[i] != 0:
            b += [i + min(a)] * buckets[i]
    return b


arr = [14, 25, 36, 17, 3, 2, 6, 9, 8]
list = bucketSort(arr)
print(list)


# 10.基数排序
def radixSort(array):
    bucket, digit = [[]], 0
    while len(bucket[0]) != len(array):
        bucket = [[], [], [], [], [], [], [], [], [], []]
        for i in range(len(array)):
            num = (array[i] // 10 ** digit) % 10
            bucket[num].append(array[i])
        array.clear()
        for i in range(len(bucket)):
            array += bucket[i]
        digit += 1
    return array


list = radixSort([4, 5, 6, 7, 3, 2, 6, 9, 8])
print(list)
