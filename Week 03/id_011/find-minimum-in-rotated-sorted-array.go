package algorithm00401

func findMin(nums []int) int {
	l, r := 0, len(nums)-1
	for l < r {
		mid := l + (r-l)/2
		if nums[l] >= nums[mid] && nums[mid] >= nums[r] {
			return nums[r]
		} else if nums[mid] > nums[r] {
			l = mid + 1
		} else if nums[l] > nums[mid] {
			r = mid
		} else {
			return nums[l]
		}
	}
	return nums[l]
}
