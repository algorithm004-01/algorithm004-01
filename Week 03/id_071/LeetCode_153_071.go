package week03

// 3.3 https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
func findMin(nums []int) int {

	if len(nums) == 1 {
		return nums[0]
	}

	low, high := 0,len(nums)-1
	
	if nums[high] > nums[0]{
		return nums[0]
	}

	for low <= high {
		mid := low + (high-low)/2
		if nums[mid] > nums[mid + 1] {
			return nums[mid + 1]
		}
		if nums[mid] < nums[mid - 1]{
			return nums[mid]
		}
		
		if nums[mid] > nums[0] {
			low = mid + 1
		}else{
			high = mid - 1
		}
	}
	return -1
}