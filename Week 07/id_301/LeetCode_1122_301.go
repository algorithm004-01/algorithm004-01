package main

import (
	"sort"
)

/**
给你两个数组，arr1 和 arr2，

arr2 中的元素各不相同
arr2 中的每个元素都出现在 arr1 中
对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾

输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
输出：[2,2,2,1,4,3,3,9,6,7,19]
*/
func relativeSortArray(arr1 []int, arr2 []int) []int {
	sort.Ints(arr1)

	var res []int
	mapArr1 := map[int]int{}
	for _, v := range arr1 {
		if _, ok := mapArr1[v]; ok {
			mapArr1[v]++
		} else {
			mapArr1[v] = 1
		}
	}
	for _, v := range arr2 {
		for i := 0; i < mapArr1[v]; i++ {
			res = append(res, v)
		}
		delete(mapArr1, v)
	}
	for _, v := range arr1 {
		for i := 0; i < mapArr1[v]; i++ {
			res = append(res, v)
		}
		delete(mapArr1, v)
	}

	return res
}
