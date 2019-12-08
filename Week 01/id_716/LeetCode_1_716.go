package id_716

// https://leetcode-cn.com/problems/two-sum/

// 1. 暴力法，O(n^2)复杂度的遍历查找
func twoSum1(nums []int, target int) []int {
	length := len(nums)
	if length <= 1 {
		return []int{}
	}
	
	for i := 0; i < length - 1; i++ {
		diff := target - nums[i]
		for j := i + 1; j < length; j++ {
            if diff == nums[j] {
				return []int{i, j}
			}
		}
	}
	
	return []int{}
}

// 2. hash 表法，使用临时的映射表空间记录已经遍历过的数字
func twoSum2(nums []int, target int) []int {
	length := len(nums)
	if length <= 1 {
		return []int{}
	}

	// 记录访问过的数字
	tracker := make(map[int]int)
	for i := 0; i < length; i++ {
		delta := target - nums[i]
		v, ok := tracker[delta]
		if ok {
			return []int{v, i}
		}
		tracker[nums[i]] = i
	}

	return []int{}
}
