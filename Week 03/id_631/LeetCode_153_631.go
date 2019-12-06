//二分查找
// 75.89% 68.18%
func findMin(nums []int) int {
    if len(nums) == 0 {
		return 0
	}
    
	l, r := 0, len(nums) - 1
	for l + 1 < r {
		mid := l + (r - l) / 2
		if nums[mid] <= nums[r] {
			r = mid
		} else {
			l = mid
		}
	}
	if nums[l] > nums[r] {
		return nums[r]
	}
	return nums[l]
}