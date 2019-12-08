import random
from collections import deque


def bubble_sort(arr):
    length = len(arr)
    for i in range(length - 1):
        for j in range(length - 1 - i):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
    return arr


def selection_sort(arr):
    length = len(arr)
    for i in range(length - 1):
        min_index = i
        for j in range(i + 1, length):
            if arr[j] < arr[min_index]:
                min_index = j
        arr[i], arr[min_index] = arr[min_index], arr[i]
    return arr


def insertion_sort(arr):
    length = len(arr)
    for i in range(1, length):
        pre_index = i - 1
        current = arr[i]
        while pre_index >= 0 and arr[pre_index] > current:
            arr[pre_index + 1] = arr[pre_index]
            pre_index -= 1
        arr[pre_index + 1] = current
    return arr


def merge_sort(arr):
    length = len(arr)
    if length < 2:
        return arr
    mid = length >> 1
    left = arr[:mid]
    right = arr[mid:]
    return merge(merge_sort(left), merge_sort(right))


def merge(left, right):
    res = []
    while len(left) > 0 and len(right) > 0:
        # while left and right:
        res.append(left.pop(0) if left[0] < right[0] else right.pop(0))
    res = res + left + right
    return res


def merge_sort2(arr, l, r):
    if l < r:
        mid = l + ((r - l) >> 1)
        merge_sort2(arr, l, mid)
        merge_sort2(arr, mid + 1, r)
        merge2(arr, l, mid, r)
    return arr


def merge2(arr, l, mid, r):
    temp = [0] * (r - l + 1)
    i = l
    j = mid + 1
    k = 0
    while i <= mid and j <= r:
        if arr[i] < arr[j]:
            temp[k] = arr[i]
            i += 1
        else:
            temp[k] = arr[j]
            j += 1
        k += 1
    while i <= mid:
        temp[k] = arr[i]
        i += 1
        k += 1
    while j <= r:
        temp[k] = arr[j]
        j += 1
        k += 1
    for i in range(len(temp)):
        arr[l + i] = temp[i]


def merge_sort_in_place(arr, l, r):
    if l < r:
        mid = l + ((r - l) >> 1)
        merge_sort_in_place(arr, l, mid)
        merge_sort_in_place(arr, mid + 1, r)
        merge_in_place(arr, l, mid, r)
    return arr


def merge_in_place(arr, l, mid, r):
    left = arr[l:mid + 1]
    right = arr[mid + 1:r + 1]
    k = l
    while left and right:
        arr[k] = left.pop(0) if left[0] < right[0] else right.pop(0)
        k += 1
    tail = left if left else right
    for n in tail:
        arr[k] = n
        k += 1


def quick_sort(arr, l, r):
    if l < r:
        i, j = l, r
        pivot = arr[l]
        while i != j:
            while j > i and arr[j] > pivot:
                j -= 1
            if j > i:
                arr[i] = arr[j]
                i += 1
            while i < j and arr[i] < pivot:
                i += 1
            if i < j:
                arr[j] = arr[i]
                j -= 1
        arr[i] = pivot
        quick_sort(arr, l, i - 1)
        quick_sort(arr, i + 1, r)
    return arr


def quick_sort2(arr, l, r):
    if l >= r:
        return arr
    pivot = partition(arr, l, r)
    quick_sort(arr, l, pivot - 1)
    quick_sort(arr, pivot + 1, r)
    return arr


def partition(arr, l, r):
    pivot = r
    counter = l
    for i in range(l, r):
        if arr[i] < arr[pivot]:
            arr[counter], arr[i] = arr[i], arr[counter]
            counter += 1
    arr[pivot], arr[counter] = arr[counter], arr[pivot]
    return counter


def heap_sort(arr):
    # index start from 1
    heap = deque(arr)
    heap.appendleft(0)

    length = len(heap) - 1
    # the last node with children
    last_non_left = length >> 1
    for i in range(last_non_left):
        heapify(heap, last_non_left - i, length)

    for i in range(length - 1):
        heap[1], heap[length - i] = heap[length - i], heap[1]
        heapify(heap, 1, length - i - 1)

    return [heap[i] for i in range(1, len(heap))]


def heapify(heap, start, end):
    tmp = heap[start]
    i = start
    j = i * 2

    while j <= end:
        if j < end and heap[j] < heap[j + 1]:
            j += 1
        if tmp < heap[j]:
            heap[i] = heap[j]
            i = j
            j = i * 2
        else:
            break
    heap[i] = tmp


if __name__ == "__main__":
    arr = [random.randint(-100, 100) for _ in range(10)]
    # print(bubble_sort(arr))
    # print(selection_sort(arr))
    # print(insertion_sort(arr))
    # print(merge_sort(arr))
    # print(merge_sort_in_place(arr, 0, len(arr) - 1))
    # print(merge_sort2(arr, 0, len(arr) - 1))
    # print(quick_sort(arr, 0, len(arr) - 1))
    print(quick_sort2(arr, 0, len(arr) - 1))
    print(heap_sort(arr))