package algorithm00401

func majorityElement(nums []int) int {
	return division(nums, 0, len(nums)-1)
}

func division(nums []int, start, end int) int {
	if start == end {
		return nums[start]
	}

	mid := (end-start)/2 + start
	left := division(nums, start, mid)
	right := division(nums, mid+1, end)

	if left == right {
		return left
	}

	leftCount := countInRange(nums, left, start, end)
	rightCount := countInRange(nums, right, start, end)

	if leftCount > rightCount {
		return left
	}
	return right
}

func countInRange(nums []int, num, start, end int) int {
	count := 0
	for i := start; i <= end; i++ {
		if nums[i] == num {
			count++
		}
	}
	return count
}
