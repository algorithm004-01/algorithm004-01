'''
relative-sort-array_1122

给你两个数组，arr1 和 arr2，

arr2 中的元素各不相同
arr2 中的每个元素都出现在 arr1 中
对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。

 
示例：

输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
输出：[2,2,2,1,4,3,3,9,6,7,19]
 

提示：

arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
arr2 中的元素 arr2[i] 各不相同
arr2 中的每个元素 arr2[i] 都出现在 arr1 中
'''

#计数排序
def relativeSortArray(arr1, arr2):
    arr = [0 for _ in range(1001)] #生成一个1001大小的数组用来存放每个数出现的次数
    ans = []
    for i in range(len(arr1)):
        arr[arr1[i]] += 1
    for i in range(len(arr2)):
        while arr[arr2[i]] > 0:
            ans.append(arr2[i])
            arr[arr2[i]] -= 1
    for i in range(len(arr)):
        while arr[i] > 0:
            ans.append(i)
            arr[i] -= 1
    return ans
