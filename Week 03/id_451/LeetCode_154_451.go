func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}
func findMin(nums []int) int {
	if len(nums) == 0 {
		return 1<<32 - 1
	}
	if len(nums) == 1 {
		return nums[0]
	}
	if len(nums) == 2 {
		if nums[0] < nums[1] {
			return nums[0]
		}
		return nums[1]
	}
	r := len(nums) - 1
	mid := r / 2
	if nums[0] < nums[mid] && nums[mid] < nums[r] {
		return nums[0]
	}
	if nums[0] > nums[mid] {
		return findMin(nums[0 : mid+1])
	}
	if nums[mid] > nums[r] {
		return findMin(nums[mid : r+1])
	}
	return min(findMin(nums[0:mid]), findMin(nums[mid:r+1]))
}
