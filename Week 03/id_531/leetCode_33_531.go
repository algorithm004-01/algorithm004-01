package id_531

func search(nums []int, target int) int {
	if len(nums) <= 0 {
		return -1
	}
	// 二分查找，单调性，边界，可索引
	bpIndex := findBreakPoint(nums)
	var left, right int
	if bpIndex == 0 {
		left, right = 0, len(nums)-1
	} else {
		if nums[0] == target {
			return 0
		}
		if nums[0] < target {
			left, right = 0, bpIndex-1
		} else {
			left, right = bpIndex, len(nums)-1
		}
	}

	for left <= right {
		mid := left + (right-left)>>1
		if nums[mid] == target {
			return mid
		}
		if nums[mid] > target {
			right = mid - 1
		} else {
			left = mid + 1
		}
	}
	return -1
}

func findBreakPoint(nums []int) int {
	bpIndex := 0
	count := len(nums)
	for i := 1; i < count; i++ {
		if nums[i] < nums[i-1] {
			bpIndex = i
		}
	}
	return bpIndex
}

func BFindBreakPoint(nums []int) int {
	left, right := 0, len(nums)-1
	lastElement := nums[right]
	for left < right {
		mid := left + (right-left)>>1
		if nums[mid] < lastElement {
			right = mid
		} else {
			left = mid + 1
		}
	}
	return left
}
