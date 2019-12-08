package week03 

import "fmt"

// 3.1 https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
func search(nums []int, target int) int {
	low, high := 0, len(nums) - 1
	for low <= high {
		mid := low + (high - low)/2
		fmt.Print(mid, "\n")
		if nums[0] > target || nums[0] > nums[mid] || target > nums[mid] {
			low = mid + 1
		} else {
			high = mid
		}
		fmt.Print(low, high, "\n")
	}

	if low == high && nums[low] == target {
		return low
	}

	return -1
}

// 3.2 https://leetcode-cn.com/problems/search-a-2d-matrix/
func searchMatrix(matrix [][]int, target int) bool {
	
	return false
}