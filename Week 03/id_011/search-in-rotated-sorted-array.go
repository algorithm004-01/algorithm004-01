package algorithm00401

func search(nums []int, target int) int {
	l, r := 0, len(nums)
	for l < r {
		mid := l + (r-l)/2
		if nums[mid] == target {
			return mid
		} else if nums[l] == target {
			return l
		} else if nums[r-1] == target {
			return r - 1
		}
		if nums[l] < nums[mid] {
			if target > nums[mid] || nums[l] > target {
				l = mid + 1
			} else {
				r = mid
			}
		} else {
			if nums[mid] > target || target > nums[r-1] {
				r = mid
			} else {
				l = mid + 1
			}
		}
	}
	return -1
}
