func rotate(nums []int, k int)  {
	swapArray(nums, 0, len(nums))
	swapArray(nums, 0, k % len(nums))
	swapArray(nums, k % len(nums), len(nums))
}

func swapArray(nums []int, start, end int) {
	for i := start; i < (end - start) / 2 + start; i++ {
		right := end - 1 - (i - start)
		temp := nums[i]
		nums[i] = nums[right]
		nums[right] = temp
	}
}